/**
 * 
 */
package com.shinylana.ui.views;

import com.vaadin.ui.Button;
import com.vaadin.navigator.View;

/**
 * @author phillippohl
 * @version 0.1
 */
public interface LoginViewSpec extends View {
	// Retrieve input
	Button getButton();
	String getPassword();
	String getUsername();
	
	// Display data
	void setDisplay(String output);
	
	//  Receive user interaction
    interface LoginViewListener {
        void buttonClick();
    }
	void addListener(LoginViewListener listener);
}