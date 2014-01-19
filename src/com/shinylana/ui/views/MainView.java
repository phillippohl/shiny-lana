/**
 * 
 */
package com.shinylana.ui.views;

import java.util.ArrayList;
import java.util.List;

import com.shinylana.ui.Shiny_lanaUI;
import com.shinylana.ui.composites.LoginComposite;
import com.shinylana.ui.composites.MainComposite;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickListener;

/**
 * @author phillippohl
 * @version 0.1
 */
@SuppressWarnings("serial")
public class MainView extends VerticalLayout implements ClickListener, MainViewSpec {
	
    private List<MainViewListener> listeners = new ArrayList<MainViewListener>();
    private MainComposite main;
   
	
	/**
	 * 
	 */
	public MainView() {
        setSizeFull();
        
        /*Button button = new Button("Go to Main View", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
            	//Shiny_lanaUI.navigator.navigateTo(Shiny_lanaUI.MAINVIEW);

            }
        });*/
        
        main = new MainComposite();  
        /*login.getButton().addClickListener(new Button.ClickListener() {
    		public void buttonClick(ClickEvent event) {
    			setDisplay("User input entered!");
    		}
        });*/
    	addComponent(main);
    	setComponentAlignment(main, Alignment.MIDDLE_CENTER);
	}

	/* (non-Javadoc)
	 * @see com.vaadin.navigator.View#enter(com.vaadin.navigator.ViewChangeListener.ViewChangeEvent)
	 */
	@Override
	public void enter(ViewChangeEvent event) {
		((Shiny_lanaUI)UI.getCurrent()).getNavigator().addViewChangeListener(new ViewChangeListener() {
            @Override
            public boolean beforeViewChange(ViewChangeEvent event) {
                if (event.getNewView() instanceof MainView && ((Shiny_lanaUI)UI.getCurrent()).getLoggedInUser() == null) {
                    Notification.show("Permission denied", Type.ERROR_MESSAGE);
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public void afterViewChange(ViewChangeEvent event) {
            	System.out.println("After view change");
            }

        });
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
	 * @see com.shinylana.ui.views.MainViewSpec#addListener(com.shinylana.ui.views.MainViewSpec.MainViewListener)
	 */
	@Override
	public void addListener(MainViewListener listener) {
		listeners.add(listener);	
	}

	/* (non-Javadoc)
	 * @see com.vaadin.ui.Button.ClickListener#buttonClick(com.vaadin.ui.Button.ClickEvent)
	 */
	@Override
	public void buttonClick(ClickEvent event) {
        for (MainViewListener listener: listeners) {
            //listener.buttonClick(skeleton.getUsername().getValue(), skeleton.getPassword().getValue());
        }
	}
}