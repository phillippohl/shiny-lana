/**
 * 
 */
package com.shinylana.presenter;

import com.shinylana.ui.views.MainView;
import com.shinylana.ui.views.MainViewSpec.MainViewListener;

/**
 * @author phillippohl
 * @version 0.1
 */
public class MainViewPresenter implements MainViewListener {
	
	//LoginModel model
	MainView view;
	
	/**
	 * 
	 */
	public MainViewPresenter(/*LoginModel model, */MainView view) {
        //this.model = model;
        this.view  = view;
        view.addListener(this);
	}

	/* (non-Javadoc)
	 * @see com.shinylana.ui.views.MainViewSpec.MainViewListener#buttonClick(java.lang.String, java.lang.String)
	 */
	@Override
	public void buttonClick(String username, String password) {
		// TODO Auto-generated method stub
		
	}

}
