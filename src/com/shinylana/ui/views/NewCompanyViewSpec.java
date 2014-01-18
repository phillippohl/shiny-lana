/**
 * 
 */
package com.shinylana.ui.views;

import java.util.List;

/**
 * @author phillippohl
 * @version 0.1
 */
public interface NewCompanyViewSpec {
	// Display data
	public void setDisplay(String output);
	
	//  Receive user interaction
    interface NewCompanyViewListener {
        void buttonClick(List<String> newCompanyInput);
    }
	public void addListener(NewCompanyViewListener listener);
}