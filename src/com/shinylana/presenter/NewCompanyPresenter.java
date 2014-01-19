/**
 * 
 */
package com.shinylana.presenter;

import java.util.List;

import com.shinylana.ui.Shiny_lanaUI;
import com.shinylana.ui.views.NewCompanyView;
import com.shinylana.ui.views.NewCompanyViewSpec.NewCompanyViewListener;
import com.vaadin.ui.UI;

/**
 * @author phillippohl
 * @version 0.1
 */
public class NewCompanyPresenter implements NewCompanyViewListener {
	//NewCompanyModel model
	NewCompanyView view;
	
	/**
	 * 
	 */
	public NewCompanyPresenter(/*NewCompanyModel model, */NewCompanyView view) {
        //this.model = model;
        this.view  = view;
        view.addListener(this);
	}

	/* (non-Javadoc)
	 * @see com.shinylana.ui.views.NewCompanyViewSpec.NewCompanyViewListener#buttonClick(java.util.List)
	 */
	@Override
	public void buttonClick(List<String> newCompanyInput) {
		// Retrieve user input	
    	view.setDisplay(newCompanyInput.get(0));
    	//insertUser();
	}
}