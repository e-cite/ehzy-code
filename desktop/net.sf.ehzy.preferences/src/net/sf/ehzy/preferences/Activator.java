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
package net.sf.ehzy.preferences;

import net.sf.ehzy.preferences.internal.PreferencesImpl;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The class that controls the plug-in lifecycle.
 * @author vwegert
 *
 */
public class Activator extends AbstractUIPlugin {

	/**
	 * The plug-in ID. 
	 */
	public static final String PLUGIN_ID = "net.sf.ehzy.preferences"; //$NON-NLS-1$
	
	private static Activator instance;
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		instance = this;
		context.registerService(IPreferences.class, new PreferencesImpl(), null);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		instance = null;
		super.stop(context);
	}
	
	/**
	 * Returns the current instance.
	 * @return the current instance
	 */
	public static Activator getInstance() {
		return instance;
	}
}
