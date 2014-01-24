/**
 * 
 */
package com.shinylana.presenter;

import java.util.ArrayList;
import java.util.List;

import com.shinylana.model.LoginModel;
import com.shinylana.ui.Shiny_lanaUI;
import com.shinylana.ui.views.LoginViewSpec.LoginButtonListener;
import com.shinylana.ui.views.LoginView;
import com.shinylana.ui.views.MainView;
import com.vaadin.ui.UI;

/**
 * @author phillippohl
 * @version 0.1
 */
public class LoginPresenter implements LoginButtonListener {
	LoginModel model;
	LoginView view;
	List result;
	
	public LoginPresenter(LoginModel model, LoginView view) {
        this.model = model;
        this.view  = view;
        view.addLoginButtonListener(this);
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
    			List record = new ArrayList();
    			record.add(username);
    			record.add(password);
    			result = model.select(record);  
    			int rowIndex = (Integer) result.get(0);   
    			view.setDisplay("" + rowIndex);
    			
                // Log user in
                ((Shiny_lanaUI)UI.getCurrent()).setLoggedInUser(username);
                
    			((Shiny_lanaUI)UI.getCurrent()).getNavigator().navigateTo(MainView.NAME);
        	} catch (NullPointerException npe) {
        		view.setDisplay("Login credentials are incorrect!\nCheck username and password!");
        	}
    	}
	}
}