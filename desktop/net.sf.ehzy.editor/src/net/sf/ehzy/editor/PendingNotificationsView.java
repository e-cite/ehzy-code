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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.Iterator;
import java.util.List;

import net.sf.ehzy.model.Project;
import net.sf.ehzy.model.Recipient;
import net.sf.ehzy.preferences.IPreferences;

import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IPartService;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

/**
 * The view that displays the recipients that have notifications pending.
 * @author vwegert
 *
 */
public class PendingNotificationsView extends ViewPart {

	/**
	 * The content provider for the table viewer used by this view.
	 * @author vwegert
	 *
	 */
	private class ViewContentProvider implements IStructuredContentProvider {
		
		private Project project;
		
		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
		 */
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			if ((newInput != null) && (newInput instanceof Project)) {
				project = (Project)newInput;
			} 
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
		 */
		public void dispose() {
			project = null;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
		 */
		public Object[] getElements(Object parent) {
			List<Recipient> recipients = new ArrayList<Recipient>();
			if (project != null) {
				for (Iterator<?> iterator = project.eAllContents(); iterator.hasNext();) {
					EObject object = (EObject) iterator.next();
					if (object instanceof Recipient) {
						Recipient recipient = (Recipient) object;
						if (recipient.isUpdatedReadoutsAvailable()) {
							recipients.add(recipient);
						}
					}
				}
			}
			return recipients.toArray();
		}
		
	}
	
	/**
	 * The label provider for the table provider used by this view.
	 * @author vwegert
	 *
	 */
	class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {
	
		private SimpleDateFormat dateFormat;

		/**
		 * Default constructor.
		 */
		public ViewLabelProvider() {
			IPreferences preferences = EHZyEditorPlugin.INSTANCE.getPreferences();
			dateFormat = new SimpleDateFormat(preferences.getDateFormat());
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
		 */
		public String getColumnText(Object obj, int index) {
			if (obj instanceof Recipient) {
				Recipient recipient = (Recipient) obj;
			switch(index) {
			case 0: return recipient.getMeter().getLocation().getName();
			case 1: return recipient.getName();
			case 2: return recipient.getLastMessageDate() == null ? "---" : dateFormat.format(recipient.getLastMessageDate()); //$NON-NLS-1$
			case 3: return recipient.getMeter().getLastReadoutDate() == null ? "---" : dateFormat.format(recipient.getMeter().getLastReadoutDate()); //$NON-NLS-1$
			default: 
				return getText(obj);
			}
			}
			return getText(obj);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
		 */
		public Image getColumnImage(Object obj, int index) {
			return null;
		}
		
	}
	
	/**
	 * A listener to notify the view when another editor is selected.
	 * @author vwegert
	 */
	private class PartListener implements IPartListener2 {

		/* (non-Javadoc)
		 * @see org.eclipse.ui.IPartListener2#partActivated(org.eclipse.ui.IWorkbenchPartReference)
		 */
		@Override
		public void partActivated(IWorkbenchPartReference partRef) {
			IWorkbenchPart part = partRef.getPart(false);
			if (part instanceof IEditorPart) {
				if (part instanceof ModelEditor) {
					setActiveEditor((ModelEditor) part);
				} else {
					setActiveEditor(null);
				}
			}
		}

		/* (non-Javadoc)
		 * @see org.eclipse.ui.IPartListener2#partBroughtToTop(org.eclipse.ui.IWorkbenchPartReference)
		 */
		@Override
		public void partBroughtToTop(IWorkbenchPartReference partRef) {
			// not required			
		}

		/* (non-Javadoc)
		 * @see org.eclipse.ui.IPartListener2#partClosed(org.eclipse.ui.IWorkbenchPartReference)
		 */
		@Override
		public void partClosed(IWorkbenchPartReference partRef) {
			// not required
		}

		/* (non-Javadoc)
		 * @see org.eclipse.ui.IPartListener2#partDeactivated(org.eclipse.ui.IWorkbenchPartReference)
		 */
		@Override
		public void partDeactivated(IWorkbenchPartReference partRef) {
			// not required
		}

		/* (non-Javadoc)
		 * @see org.eclipse.ui.IPartListener2#partOpened(org.eclipse.ui.IWorkbenchPartReference)
		 */
		@Override
		public void partOpened(IWorkbenchPartReference partRef) {
			// not required
		}

		/* (non-Javadoc)
		 * @see org.eclipse.ui.IPartListener2#partHidden(org.eclipse.ui.IWorkbenchPartReference)
		 */
		@Override
		public void partHidden(IWorkbenchPartReference partRef) {
			// not required
		}

		/* (non-Javadoc)
		 * @see org.eclipse.ui.IPartListener2#partVisible(org.eclipse.ui.IWorkbenchPartReference)
		 */
		@Override
		public void partVisible(IWorkbenchPartReference partRef) {
			// not required
		}

		/* (non-Javadoc)
		 * @see org.eclipse.ui.IPartListener2#partInputChanged(org.eclipse.ui.IWorkbenchPartReference)
		 */
		@Override
		public void partInputChanged(IWorkbenchPartReference partRef) {
			// not required
		}

	}
	
	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "net.sf.ehzy.editor.PendingNotificationsView"; //$NON-NLS-1$

	private TableViewer viewer;
	private PartListener partListener;
	private ModelEditor activeEditor;
	private CommandStackListener modelChangeListener;

	/**
	 * Default constructor.
	 */
	public PendingNotificationsView() {
		partListener = new PartListener();
		modelChangeListener = new CommandStackListener() {
			@Override
			public void commandStackChanged(EventObject event) {
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// not important
						}
						viewer.refresh(true);
					}
				});
			}
		};
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.ViewPart#init(org.eclipse.ui.IViewSite)
	 */
	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		IPartService service = (IPartService) getSite().getService(IPartService.class);
		service.addPartListener(partListener);
	}

	/**
	 * Registers the appropriate listeners whenever another editor is selected.
	 * @param newEditor
	 */
	protected void setActiveEditor(ModelEditor newEditor) {
		if (newEditor != activeEditor) {
			if (activeEditor != null) {
				activeEditor.getEditingDomain().getCommandStack().removeCommandStackListener(modelChangeListener);
			}
			activeEditor = newEditor;
			if (activeEditor != null) {
				activeEditor.getEditingDomain().getCommandStack().addCommandStackListener(modelChangeListener);
				viewer.setInput(activeEditor.getProject());
			} else {
				viewer.setInput(null);
			}
		}
	}

	/**
	 * Create s the vtable viewer and initializes the view.
	 */
	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		Table table = viewer.getTable();
		TableColumn col = new TableColumn(table, SWT.LEFT);
		col.setText(Messages.PendingNotificationsView_LocationColumnLabel);
		col.setMoveable(false);
		col.setWidth(100);
		col = new TableColumn(table, SWT.LEFT);
		col.setText(Messages.PendingNotificationsView_RecipientColumnLabel);
		col.setMoveable(false);
		col.setWidth(150);
		col = new TableColumn(table, SWT.LEFT);
		col.setText(Messages.PendingNotificationsView_LastMessageColumnLabel);
		col.setMoveable(false);
		col.setWidth(100);
		col = new TableColumn(table, SWT.LEFT);
		col.setText(Messages.PendingNotificationsView_LastReadoutColumnLabel);
		col.setMoveable(false);
		col.setWidth(100);
		table.setHeaderVisible(true);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setInput(getViewSite());
		hookContextMenu();
		getSite().setSelectionProvider(viewer);
	}

	/**
	 * Initializes the context menu for the view.
	 */
	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu"); //$NON-NLS-1$
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}