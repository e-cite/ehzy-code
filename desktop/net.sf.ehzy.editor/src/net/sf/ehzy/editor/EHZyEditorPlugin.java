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

import net.sf.ehzy.preferences.IPreferences;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.ui.EclipseUIPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * This is the central singleton for the EHZy editor plugin.
 */
public final class EHZyEditorPlugin extends EMFPlugin {
	
	/**
	 * The plugin ID as specified in the manifest.
	 */
	public static final String PLUGIN_ID = "net.sf.ehzy.editor"; //$NON-NLS-1$
	
	/**
	 * Keep track of the singleton.
	 */
	public static final EHZyEditorPlugin INSTANCE = new EHZyEditorPlugin();
	
	/**
	 * Keep track of the singleton.
	 */
	private static Implementation plugin;

	/**
	 * Create the instance.
	 */
	public EHZyEditorPlugin() {
		super
			(new ResourceLocator [] {
			});
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * @return the singleton instance.
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}
	
	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * @return the singleton instance.
	 */
	public static Implementation getPlugin() {
		return plugin;
	}
	
	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 */
	public static class Implementation extends EclipseUIPlugin {
		/**
		 * Creates an instance.
		 */
		public Implementation() {
			super();
			plugin = this;
		}
	}
	
	/**
	 * Returns the preferences access service implementation.
	 * @return the preferences access service implementation
	 */
	public IPreferences getPreferences() {
		BundleContext context = getPlugin().getBundle().getBundleContext();
		ServiceReference<IPreferences> reference = context.getServiceReference(IPreferences.class);
		return context.getService(reference);
	}

}
