/**
 * 
 */
package com.shinylana.presenter;

import java.util.ArrayList;
import java.util.List;

import com.shinylana.model.tables.LoginModel;
import com.shinylana.ui.Shiny_lanaUI;
import com.shinylana.ui.views.MainView;
import com.shinylana.ui.views.RegisterView;
import com.shinylana.ui.views.RegisterViewSpec.RegisterButtonListener;
import com.vaadin.ui.UI;

/**
 * @author phillippohl
 * @version 0.1
 */
public class RegisterPresenter implements RegisterButtonListener {

	LoginModel model;
	RegisterView view;
	List result;
	
	/**
	 * 
	 */
	public RegisterPresenter(LoginModel model, RegisterView view) {
		this.model = model;
        this.view  = view;
        view.addRegisterButtonListener(this);
	}

	/* (non-Javadoc)
	 * @see com.shinylana.ui.views.RegisterViewSpec.RegisterButtonListener#buttonClick()
	 */
	@Override
	public void buttonClick() {
		// Retrieve user input	
		String username = view.getUsername();
		String password = view.getPassword();
		String passwordRepeat = view.getPasswordRepeat();
		
    	if (username.trim().length() == 0 || password.trim().length() == 0) {
    		view.setDisplay("Please enter username and password!");
    	}
    	else if(passwordRepeat.trim().length() == 0) {
    		view.setDisplay("Please repeat your password!");
    	}
    	else if (!password.trim().equals(passwordRepeat.trim())) {
    		view.setDisplay("Password and repeted password are not equal!");
    	}
    	else { 		 		  		
    		try {
    			result = model.checkUserName(username); 
    			view.setDisplay("Username already exists!");
        	} catch (NullPointerException npe) {  			 
    			List<String> newUser = new ArrayList<String>();
    			newUser.add(username);
    			newUser.add(password);  			
        		model.insert(newUser);    
        		((Shiny_lanaUI)UI.getCurrent()).getNavigator().navigateTo(MainView.NAME);
        	}
    	}
	}
}