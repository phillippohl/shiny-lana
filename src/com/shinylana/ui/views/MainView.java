/**
 * 
 */
package com.shinylana.ui.views;

import java.util.ArrayList;
import java.util.List;

import com.shinylana.ui.Shiny_lanaUI;
import com.shinylana.ui.composites.MainComposite;
import com.shinylana.ui.views.LoginViewSpec.LoginButtonListener;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.TabSheet.SelectedTabChangeListener;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickListener;

/**
 * @author phillippohl
 * @version 0.1
 */
@SuppressWarnings("serial")
public class MainView extends VerticalLayout implements SelectedTabChangeListener, MainViewSpec {
	
    public static final String NAME = "main";
	private List<MainViewListener> listeners = new ArrayList<MainViewListener>();
    private MainComposite main;
   	
	/**
	 * 
	 */
	public MainView() {
        setSizeFull();
        
        main = new MainComposite();
        main.getTabSheet().addSelectedTabChangeListener(this);
    	addComponent(main);
    	setComponentAlignment(main, Alignment.MIDDLE_CENTER);
	}

	/* (non-Javadoc)
	 * @see com.vaadin.navigator.View#enter(com.vaadin.navigator.ViewChangeListener.ViewChangeEvent)
	 */
	@Override
	public void enter(ViewChangeEvent event) {
		main.setMenuBarItemUser(((Shiny_lanaUI)UI.getCurrent()).getLoggedInUser());
		setDisplay("Welcome to Shiny Lana!");
	}

	/* (non-Javadoc)
	 * @see com.shinylana.ui.views.MainViewSpec#setDisplay(java.lang.String)
	 */
	@Override
	public void setDisplay(String output) {
		Notification.show(output);
	}
	
	/* (non-Javadoc)
	 * @see com.shinylana.ui.views.MainViewSpec#addMainViewListener(com.shinylana.ui.views.MainViewSpec.MainViewListener)
	 */
	@Override
	public void addMainViewListener(MainViewListener listener) {
		listeners.add(listener);	
	}

	/* (non-Javadoc)
	 * @see com.vaadin.ui.TabSheet.SelectedTabChangeListener#selectedTabChange(com.vaadin.ui.TabSheet.SelectedTabChangeEvent)
	 */
	@Override
	public void selectedTabChange(SelectedTabChangeEvent event) {
        for (MainViewListener listener: listeners) {
            listener.SelectedTabChange();
        }	
	}
	
	public Tab getCurrentTab() {
		return main.getTabSheet().getTab(main.getTabSheet().getSelectedTab());
	}
}