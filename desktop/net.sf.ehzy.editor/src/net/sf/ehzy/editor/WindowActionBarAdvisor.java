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
package net.sf.ehzy.editor;

import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ContributionItemFactory;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

/**
 * RCP's action bar advisor
 */
public class WindowActionBarAdvisor extends ActionBarAdvisor {

	/**
	 * Default constructor.
	 * @param configurer the action bar configurer
	 */
	public WindowActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.application.ActionBarAdvisor#fillMenuBar(org.eclipse.jface.action.IMenuManager)
	 */
	@Override
	protected void fillMenuBar(IMenuManager menuBar) {
		IWorkbenchWindow window = getActionBarConfigurer().getWindowConfigurer().getWindow();
		menuBar.add(createFileMenu(window));
		menuBar.add(createEditMenu(window));
		menuBar.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		menuBar.add(createWindowMenu(window));
		menuBar.add(createHelpMenu(window));					
	}
	
	/**
	 * Creates the 'File' menu.
	 * @param window 
	 * @return the file menu
	 */
	protected IMenuManager createFileMenu(IWorkbenchWindow window) {
		IMenuManager menu = new MenuManager(Messages.WindowActionBarAdvisor_FileMenuText, IWorkbenchActionConstants.M_FILE);    
		menu.add(new GroupMarker(IWorkbenchActionConstants.FILE_START));

		menu.add(new Separator());
		menu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		menu.add(new Separator());
		addToMenuAndRegister(menu, ActionFactory.CLOSE.create(window));
		addToMenuAndRegister(menu, ActionFactory.CLOSE_ALL.create(window));
		menu.add(new Separator());
		addToMenuAndRegister(menu, ActionFactory.SAVE.create(window));
		addToMenuAndRegister(menu, ActionFactory.SAVE_AS.create(window));
		addToMenuAndRegister(menu, ActionFactory.SAVE_ALL.create(window));
		menu.add(new Separator());
		addToMenuAndRegister(menu, ActionFactory.QUIT.create(window));
		menu.add(new GroupMarker(IWorkbenchActionConstants.FILE_END));
		return menu;
	}

	/**
	 * Creates the 'Edit' menu.
	 * @param window 
	 * @return the edit menu
	 */
	protected IMenuManager createEditMenu(IWorkbenchWindow window) {
		IMenuManager menu = new MenuManager(Messages.WindowActionBarAdvisor_EditMenuText, IWorkbenchActionConstants.M_EDIT);
		menu.add(new GroupMarker(IWorkbenchActionConstants.EDIT_START));

		addToMenuAndRegister(menu, ActionFactory.UNDO.create(window));
		addToMenuAndRegister(menu, ActionFactory.REDO.create(window));
		menu.add(new GroupMarker(IWorkbenchActionConstants.UNDO_EXT));
		menu.add(new Separator());

		addToMenuAndRegister(menu, ActionFactory.CUT.create(window));
		addToMenuAndRegister(menu, ActionFactory.COPY.create(window));
		addToMenuAndRegister(menu, ActionFactory.PASTE.create(window));
		menu.add(new GroupMarker(IWorkbenchActionConstants.CUT_EXT));
		menu.add(new Separator());

		addToMenuAndRegister(menu, ActionFactory.DELETE.create(window));
		addToMenuAndRegister(menu, ActionFactory.SELECT_ALL.create(window));
		menu.add(new Separator());

		menu.add(new GroupMarker(IWorkbenchActionConstants.ADD_EXT));

		menu.add(new GroupMarker(IWorkbenchActionConstants.EDIT_END));
		menu.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		return menu;
	}

	/**
	 * Creates the 'Window' menu.
	 * @param window 
	 * @return the window menu
	 */
	protected IMenuManager createWindowMenu(IWorkbenchWindow window) {
		IMenuManager menu = new MenuManager(Messages.WindowActionBarAdvisor_WindowMenuText, IWorkbenchActionConstants.M_WINDOW);

		addToMenuAndRegister(menu, ActionFactory.OPEN_NEW_WINDOW.create(window));
		addToMenuAndRegister(menu, ActionFactory.RESET_PERSPECTIVE.create(window));
		menu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		menu.add(ContributionItemFactory.OPEN_WINDOWS.create(window));

		return menu;
	}

	/**
	 * Creates the 'Help' menu.
	 * @param window 
	 * @return the help menu
	 */
	protected IMenuManager createHelpMenu(IWorkbenchWindow window) {
		IMenuManager menu = new MenuManager(Messages.WindowActionBarAdvisor_HelpMenuText, IWorkbenchActionConstants.M_HELP);
		// Welcome or intro page would go here
		// Help contents would go here
		// Tips and tricks page would go here
		menu.add(new GroupMarker(IWorkbenchActionConstants.HELP_START));
		menu.add(new GroupMarker(IWorkbenchActionConstants.HELP_END));
		menu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		return menu;
	}
	
	/**
	 * Adds the specified action to the given menu and also registers the action with the
	 * action bar configurer, in order to activate its key binding.
	 * @param menuManager 
	 * @param action 
	 */
	protected void addToMenuAndRegister(IMenuManager menuManager, IAction action) {
		menuManager.add(action);
		getActionBarConfigurer().registerGlobalAction(action);
	}
}