/*******************************************************************************
 * Copyright (c) 2012 Volker Wegert and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Volker Wegert - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package net.sf.ehzy.editor;

/**
 * Auxiliary class to perform some hex / string operations.
 * @author vwegert
 *
 */
public class HexUtil {

	private static final String HEX_DIGITS = "0123456789ABCDEF"; //$NON-NLS-1$

	/**
	 * Converts a byte array to a hexadecimal string. The bytes can be grouped with the 
	 * groups separated by dashes.
	 * @param data
	 * @param groupSize number of bytes to be grouped together
	 * @return the result string
	 */
	public static String toHexString(byte[] data, int groupSize) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			int v = data[i] & 0xff;
			buf.append(HEX_DIGITS.charAt(v >> 4));
			buf.append(HEX_DIGITS.charAt(v & 0xf));
			if (groupSize > 0) {
				if (((i % groupSize) != 0) && (i < data.length - 1)) {
					buf.append("-"); //$NON-NLS-1$
				}
			}
		}
		return buf.toString();
	}   	

	/**
	 * Converts a byte array to a hexadecimal string.
	 * @param data
	 * @return the result string
	 */
	public static String toHexString(byte[] data) {
		return toHexString(data, -1);
	}

}
