/**
 * 
 */
package com.shinylana.ui.views;

import java.util.ArrayList;
import java.util.List;

import com.shinylana.ui.composites.LoginComposite;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Link;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

/**
 * @author phillippohl
 * @version 0.1
 */
@SuppressWarnings("serial")
public class LoginView extends VerticalLayout implements ClickListener, LoginViewSpec {
	
    private List<LoginButtonListener> listeners = new ArrayList<LoginButtonListener>();
    private LoginComposite login;
	
	public LoginView() {
        setSizeFull();
        
    	login = new LoginComposite();  
    	login.getLoginButton().addClickListener(this);
    	addComponent(login);
        setComponentAlignment(login, Alignment.MIDDLE_CENTER);
    }
	 
    @Override
    public void enter(ViewChangeEvent event) {
    	setDisplay("Please enter your login credentials");
    }

	@Override
	public void setDisplay(String output) {
		Notification.show(output);
	}
	
	@Override
	public void addLoginButtonListener(LoginButtonListener listener) {	
		listeners.add(listener);		
	}

    /** Relay button clicks to the presenter with an
     *  implementation-independent event */
	@Override
	public void buttonClick(ClickEvent event) {
        for (LoginButtonListener listener: listeners) {
            listener.buttonClick();
        }
	}
	
	/* (non-Javadoc)
	 * @see com.shinylana.ui.views.LoginViewSpec#getLoginButton()
	 */
	@Override
	public Button getLoginButton() {
		return login.getLoginButton();
	}

	/* (non-Javadoc)
	 * @see com.shinylana.ui.views.LoginViewSpec#getRegisterLink()
	 */
	@Override
	public Link getRegisterLink() {
		return login.getRegisterLink();
	}

	/* (non-Javadoc)
	 * @see com.shinylana.ui.views.LoginViewSpec#getPassword()
	 */
	@Override
	public String getPassword() {
		return login.getPassword().getValue();
	}

	/* (non-Javadoc)
	 * @see com.shinylana.ui.views.LoginViewSpec#getUsername()
	 */
	@Override
	public String getUsername() {
		return login.getUsername().getValue();
	}
}