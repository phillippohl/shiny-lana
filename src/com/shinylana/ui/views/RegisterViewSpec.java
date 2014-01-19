/**
 * 
 */
package com.shinylana.ui.views;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;

/**
 * @author phillippohl
 * @version 0.1
 */
public interface RegisterViewSpec extends View {
	// Retrieve input
	Button getRegisterButton();
	String getUsername();
	String getPassword();
	String getPasswordRepeat();
	
	// Display data
	void setDisplay(String output);
	
	//  Receive user interaction
    interface RegisterButtonListener {
        void buttonClick();
    }
	void addRegisterButtonListener(RegisterButtonListener listener);
}