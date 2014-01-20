/**
 * 
 */
package com.shinylana.ui.views;

import com.vaadin.navigator.View;

/**
 * @author phillippohl
 * @version 0.1
 */
public interface MainViewSpec extends View {
	// Retrieve input
	
	// Display data
	void setDisplay(String output);
	
	//  Receive user interaction
    interface MainViewListener {
        void SelectedTabChange();
    }
	void addMainViewListener(MainViewListener listener);
}