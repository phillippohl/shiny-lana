/**
 * 
 */
package com.shinylana.presenter;

import java.util.List;

import com.shinylana.model.tables.LoginModel;
import com.shinylana.ui.views.LoginViewSpec.LoginViewListener;
import com.shinylana.ui.views.LoginView;

/**
 * @author phillippohl
 * @version 0.1
 */
public class LoginPresenter implements LoginViewListener {
	LoginModel model;
	LoginView view;
	List result;
	
	public LoginPresenter(LoginModel model, LoginView view) {
        this.model = model;
        this.view  = view;
        view.addListener(this);
	}

	@Override
	public void buttonClick() {
		// Retrieve user input	
		String username = view.getUsername();
		String password = view.getPassword();
		
    	if (username.trim().length() == 0 || password.trim().length() == 0) {
    		view.setDisplay("Please enter username and password!");
    	}
    	else { 		 		  		
    		try {
    			result = model.select(username, password);  
    			int rowIndex = (Integer) result.get(0);   
    			view.setDisplay("" + rowIndex);
        	} catch (NullPointerException npe) {
        		npe.printStackTrace();
        		view.setDisplay("Login credentials are incorrect!\nCheck username and password!");
        	}
    		//Shiny_lanaUI.navigator.navigateTo(Shiny_lanaUI.MAIN_VIEW);
    	}
	}
}