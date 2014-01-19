/**
 * 
 */
package com.shinylana.ui.views;

import java.util.ArrayList;
import java.util.List;

import com.shinylana.ui.composites.RegisterComposite;
import com.shinylana.ui.views.RegisterViewSpec.RegisterButtonListener;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

/**
 * @author phillippohl
 * @version 0.1
 */
@SuppressWarnings("serial")
public class RegisterView extends VerticalLayout implements ClickListener, RegisterViewSpec {

    public static final String NAME = "register";
	private List<RegisterButtonListener> listeners = new ArrayList<RegisterButtonListener>();
    private RegisterComposite register;
	
	/**
	 * 
	 */
	public RegisterView() {
        setSizeFull();
        
        register = new RegisterComposite();  
        register.getRegisterButton().addClickListener(this);
    	addComponent(register);
        setComponentAlignment(register, Alignment.MIDDLE_CENTER);
	}
	

	/* (non-Javadoc)
	 * @see com.vaadin.navigator.View#enter(com.vaadin.navigator.ViewChangeListener.ViewChangeEvent)
	 */
	@Override
	public void enter(ViewChangeEvent event) {
		setDisplay("Please enter your desired login credentials");
	}
	
	/* (non-Javadoc)
	 * @see com.vaadin.ui.Button.ClickListener#buttonClick(com.vaadin.ui.Button.ClickEvent)
	 */
	@Override
	public void buttonClick(ClickEvent event) {
        for (RegisterButtonListener listener: listeners) {
            listener.buttonClick();
        }
	}

	/* (non-Javadoc)
	 * @see com.shinylana.ui.views.RegisterViewSpec#getRegisterButton()
	 */
	@Override
	public Button getRegisterButton() {
		return register.getRegisterButton();
	}

	/* (non-Javadoc)
	 * @see com.shinylana.ui.views.RegisterViewSpec#getUsername()
	 */
	@Override
	public String getUsername() {
		return register.getUsername().getValue();
	}

	/* (non-Javadoc)
	 * @see com.shinylana.ui.views.RegisterViewSpec#getPassword()
	 */
	@Override
	public String getPassword() {
		return register.getPassword().getValue();
	}

	/* (non-Javadoc)
	 * @see com.shinylana.ui.views.RegisterViewSpec#getPasswordRepeat()
	 */
	@Override
	public String getPasswordRepeat() {
		return register.getPasswordRepeat().getValue();
	}

	/* (non-Javadoc)
	 * @see com.shinylana.ui.views.RegisterViewSpec#setDisplay(java.lang.String)
	 */
	@Override
	public void setDisplay(String output) {
		Notification.show(output);
	}

	/* (non-Javadoc)
	 * @see com.shinylana.ui.views.RegisterViewSpec#addLoginButtonListener(com.shinylana.ui.views.RegisterViewSpec.RegisterButtonListener)
	 */
	@Override
	public void addRegisterButtonListener(RegisterButtonListener listener) {
		listeners.add(listener);			
	}
}