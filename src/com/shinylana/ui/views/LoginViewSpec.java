/**
 * 
 */
package com.shinylana.ui.views;

import com.vaadin.ui.Button;
import com.vaadin.ui.Link;
import com.vaadin.navigator.View;

/**
 * @author phillippohl
 * @version 0.1
 */
public interface LoginViewSpec extends View {
	// Retrieve input
	Button getLoginButton();
	Link getRegisterLink();
	String getPassword();
	String getUsername();
	
	// Display data
	void setDisplay(String output);
	
	//  Receive user interaction
    interface LoginButtonListener {
        void buttonClick();
    }
	void addLoginButtonListener(LoginButtonListener listener);
}