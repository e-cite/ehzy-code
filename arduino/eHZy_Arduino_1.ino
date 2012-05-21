/**
 * Copyright (c) 2012 Volker Wegert <ehzy@volker-wegert.de>
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   Volker Wegert - initial implementation
 *
 */
#include <stdarg.h>
#include <stdio.h>
#include <avr/pgmspace.h>
#include <SoftwareSerial.h>
#include <SD.h>

/***************************************************************************************************
 * CONSTANTS 
 ***************************************************************************************************/

/**
 * hardware pin assignments - modify this if you change the hardware layout
 */
#define IR_RX_PIN     7
#define IR_TX_PIN     6 // not used, but required for SoftwareSerial
#define PIEZO_PIN     5
#define SD_CS_PIN     4
#define SD_SS_PIN    10
#define DUMMY_RX_PIN  8
#define DUMMY_TX_PIN  9

/**
 * error codes (= numbers of error beeps)
 */
#define ERR_INVALID_HEADER       1
#define ERR_HEADER_TIMEOUT       2
#define ERR_SERIAL_OVERFLOW      3
#define ERR_BUFFER_OVERFLOW      4
#define ERR_FILE_OPEN_FAILED     5
#define ERR_INIT_SD_CARD_ERROR   6
#define ERR_NO_FILE_NAMES_LEFT   7

/**
 * success codes (= number of success beeps)
 */
#define SUCC_READY               1
#define SUCC_READ                2

/**
 * size of the SML message buffer = meximum number of bytes that can be received
 */
#define SML_MSG_BUFFER_SIZE    500

/**
 * size of a filename (8.3 + terminating 0x00 = 13 chars)
 */
#define FILENAME_SIZE           13 

/**
 * maximum number of files that can be stored
 */
#define MAX_FILE_NUMBER   99999999

/**
 * maximum time to wait for the end of a data packet received via IR
 */
#define SERIAL_READ_TIMEOUT_MS 100

/***************************************************************************************************
 * MESSAGES
 ***************************************************************************************************/

/**
 * maximum length of a message (entire text after variable substitution!)
 */
#define MAX_MESSAGE_LENGTH        50

/**
 * message numbers
 */
#define MSG_PROGRAM_STOPPED        0
#define MSG_NEXT_FILENAME          1
#define MSG_NO_FILE_NAMES_LEFT     2
#define MSG_INIT_HARDWARE          3
#define MSG_INIT_SD_CARD           4
#define MSG_INIT_SD_CARD_ERROR     5
#define MSG_BYTE_READ              6
#define MSG_BUFFER_OVERFLOW        7
#define MSG_SERIAL_OVERFLOW        8  
#define MSG_INVALID_HEADER         9
#define MSG_FILE_OPEN_FAILED      10
#define MSG_FILE_WRITTEN          11
#define MSG_FREE_MEMORY           12
#define MSG_NUM_BYTES_READ        13

/**
 * actual message texts - caution, adapt MAX_MESSAGE_LENGTH if required!
 *                               ....+....1....+....2....+....3....+....4....+....5
 */
prog_char msgText00[] PROGMEM = "Program stopped.";
prog_char msgText01[] PROGMEM = "Next output file name is '%s'";
prog_char msgText02[] PROGMEM = "No more file names left";
prog_char msgText03[] PROGMEM = "Initializing Hardware...";
prog_char msgText04[] PROGMEM = "Initializing SD Card...";
prog_char msgText05[] PROGMEM = "SD Card initialization failed";
prog_char msgText06[] PROGMEM = "Read byte %02hhu from IR receiver";
prog_char msgText07[] PROGMEM = "Message buffer overflow";
prog_char msgText08[] PROGMEM = "Serial buffer overflow";
prog_char msgText09[] PROGMEM = "Invalid escape sequence";
prog_char msgText10[] PROGMEM = "Unable to open output file";
prog_char msgText11[] PROGMEM = "%u bytes of data written to file '%s'";
prog_char msgText12[] PROGMEM = "%u bytes of memory available";
prog_char msgText13[] PROGMEM = "%u bytes read";

/**
 * table for easier access to the message texts
 */
PROGMEM const char *msgTextTable[] = {   
  msgText00,
  msgText01,
  msgText02,
  msgText03,
  msgText04,
  msgText05,
  msgText06,
  msgText07,
  msgText08,
  msgText09,
  msgText10,
  msgText11,
  msgText12,
  msgText13
};

/***************************************************************************************************
 * GLOBAL VARIABLES (YUCK!)
 ***************************************************************************************************/

/**
 * instance of the SoftwareSerial library to handle the IR communication
 */
SoftwareSerial mySerial(IR_RX_PIN, IR_TX_PIN);
SoftwareSerial dummySerial(DUMMY_RX_PIN, DUMMY_TX_PIN);

/**
 * variables to keep track of the name of the next file to be written
 */
unsigned long nextFileNumber = 0;
char nextFileName[FILENAME_SIZE];

/**
 * the global buffer to store the SML message currently being read
 */
unsigned char buffer[SML_MSG_BUFFER_SIZE];

/***************************************************************************************************
 * SUBROUTINES
 ***************************************************************************************************/

/** 
 * printMessage - reads a message text from the PROGMEM, performs variable substitution and 
 *                writes the resulting text to the serial console. Use MSG_* constants for
 *                messageNumber.
 */
void printMessage(int messageNumber, ...) {
  va_list args;
  char format[MAX_MESSAGE_LENGTH];
  char buffer[MAX_MESSAGE_LENGTH];
  va_start(args, messageNumber);
  strncpy_P(format, (char*)pgm_read_word(&(msgTextTable[messageNumber])), MAX_MESSAGE_LENGTH);
  vsnprintf(buffer, MAX_MESSAGE_LENGTH, format, args);
  Serial.println(buffer);
  va_end(args);
}

/**
 * reportFreeMemory - determines the amount of free memory and logs it to the serial console.
 */
void reportFreeMemory() {
  int freeMemory;
  uint8_t * heapptr, * stackptr;
  stackptr = (uint8_t *) malloc(4);     // use stackptr temporarily
  heapptr = stackptr;                   // save value of heap pointer
  free(stackptr);                       // free up the memory again (sets stackptr to 0)
  stackptr = (uint8_t *) (SP);          // save value of stack pointer
  freeMemory = stackptr - heapptr;
  printMessage(MSG_FREE_MEMORY, freeMemory);
}  

/**
 * errorSound - creates an acoustic error message using the piezo speaker. Use ERR_* constants 
 *              for the error number.
 */
void errorSound(int num) {
  tone(PIEZO_PIN, 440);
  delay(100);
  noTone(PIEZO_PIN);
  delay(20);  
  tone(PIEZO_PIN, 294);
  delay(200);
  noTone(PIEZO_PIN);
  delay(20);  
  for (int i = 0; i < num; i++) {
    tone(PIEZO_PIN, 370);
    delay(50);
    noTone(PIEZO_PIN);
    delay(20);
  }
}

/**
 * successSound - creates an acoustic success message using the piezo speaker. Use SUCC_* constants
 *                for the success number.
 */
void successSound(int num) {
  tone(PIEZO_PIN, 440);
  delay(100);
  noTone(PIEZO_PIN);
  delay(20);  
  tone(PIEZO_PIN, 587);
  delay(200);
  noTone(PIEZO_PIN);
  delay(20);  
  for (int i = 0; i < num; i++) {
    tone(PIEZO_PIN, 587);
    delay(50);
    noTone(PIEZO_PIN);
    delay(20);
  }
}

/**
 * stop - stops program execution in a controlled fashion (endless loop).
 */
void stop() {
  printMessage(MSG_PROGRAM_STOPPED);
  while(1);
}

/**
 * findNextFileNumber - determines the number and name of the next file available. This will change
 *                      the global variables nextFileName and nextFileNumber. This routine will
 *                      stop the entire program if no free filenames can be found.
 */
void findNextFileNumber() {
  do {
    sprintf(nextFileName, "%08lu.SML", nextFileNumber);
    if (!SD.exists(nextFileName)) {
      printMessage(MSG_NEXT_FILENAME, nextFileName);
      return;
    } else {
      nextFileNumber += 1;
      if (nextFileNumber > MAX_FILE_NUMBER) {
        printMessage(MSG_NO_FILE_NAMES_LEFT);
        errorSound(ERR_NO_FILE_NAMES_LEFT);
        stop();
      }
    }
  } while (true); 
}

/**
 * writeBufferToFile - writes the first messageLength bytes of the global message buffer to the
 *                     file specified by nextFileName. If the file was created successfully, this
 *                     routine emits a success beep and calls findNextFileNumber.
 */
void writeBufferToFile(int messageLength) {
  File outputFile;

  outputFile = SD.open(nextFileName, FILE_WRITE);
  if (!outputFile) {
    printMessage(MSG_FILE_OPEN_FAILED);
    errorSound(ERR_FILE_OPEN_FAILED);
  } else {
    outputFile.write(buffer, messageLength);
    outputFile.close();
    printMessage(MSG_FILE_WRITTEN, messageLength, nextFileName);
    successSound(SUCC_READ);
    findNextFileNumber();
  }
}

/**
 * isValidHeader - returns true if the global message buffer begins with a valid SML escape sequence.
 */
inline boolean isValidHeader() {
  return ((buffer[0] == 0x1b) ||
          (buffer[1] == 0x1b) ||
          (buffer[2] == 0x1b) ||
          (buffer[3] == 0x1b) ||
          (buffer[4] == 0x01) ||
          (buffer[5] == 0x01) ||
          (buffer[6] == 0x01) ||
          (buffer[7] == 0x01));
}

/***************************************************************************************************
 * MAIN ROUTINES
 ***************************************************************************************************/

/**
 * setup - initialization routine run once after the device is powered up.
 */
void setup() {
  // set the serial console speed
  Serial.begin(57600);
  
  // set the pin configuration
  printMessage(MSG_INIT_HARDWARE);
  pinMode(IR_RX_PIN, INPUT);
  pinMode(IR_TX_PIN, OUTPUT);
  pinMode(PIEZO_PIN, OUTPUT);
  pinMode(SD_SS_PIN, OUTPUT);
  pinMode(DUMMY_RX_PIN, INPUT);
  pinMode(DUMMY_TX_PIN, OUTPUT);

  // initialize the SD card library and check whether a card is available
  printMessage(MSG_INIT_SD_CARD);
  if (!SD.begin(SD_CS_PIN)) {
    printMessage(MSG_INIT_SD_CARD_ERROR);
    errorSound(ERR_INIT_SD_CARD_ERROR);
    stop();
  }

  // initialize the SoftwareSerial libary used to receive the IR data
  dummySerial.begin(9600);
  mySerial.begin(9600);
  
  // determine the first file name to use
  findNextFileNumber();

  // notify the user that we're ready to go...
  successSound(SUCC_READY);
}

/**
 * loop - main program, run in an endless loop
 */
void loop() {
  unsigned int nextBufferPosition = 0;
  unsigned long lastReadTime = 0;

  reportFreeMemory();

  // clear the message buffer
  memset(buffer, 0, sizeof(buffer));
  
  // remove a pending overflow flag (might have been left over from a previous run) 
  // and ensure that the SoftwareSerial library is listening
  mySerial.overflow(); 
  mySerial.listen();

  // wait until actual data is available
  while (!mySerial.available());

  // keep reading data until either the message buffer is filled or no more data was
  // received for SERIAL_READ_TIMEOUT_MS ms
  lastReadTime = millis();
  while (millis() - lastReadTime < SERIAL_READ_TIMEOUT_MS) {
    if (mySerial.available()) {
      buffer[nextBufferPosition] = mySerial.read();
      lastReadTime = millis();
      if (nextBufferPosition >= SML_MSG_BUFFER_SIZE) {
        dummySerial.listen(); // disable further IR input
        printMessage(MSG_BUFFER_OVERFLOW);
        errorSound(ERR_BUFFER_OVERFLOW);
        return;
      }
      nextBufferPosition += 1;
    }
  }

  // report an error if an overflow condition was encountered - the data received is useless
  // in this case :-(
  if (mySerial.overflow()) {
    dummySerial.listen(); // disable further IR input
    printMessage(MSG_SERIAL_OVERFLOW);
    errorSound(ERR_SERIAL_OVERFLOW);
  } else {
    dummySerial.listen(); // disable further IR input
    // check the header
    printMessage(MSG_NUM_BYTES_READ, nextBufferPosition + 1);
    if (!isValidHeader()) {
      // not a valid header - notify the user...
      printMessage(MSG_INVALID_HEADER);
      errorSound(ERR_INVALID_HEADER);
      // ...and empty the receiver buffer (wait for the end of the current data stream
      while (mySerial.available() > 0) {
        mySerial.read();
      }
    } else {
      writeBufferToFile(nextBufferPosition + 1);
    }
  }
}

