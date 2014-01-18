/**
 * 
 */
package com.shinylana.presenter;

import java.util.ArrayList;
import java.util.List;

import com.shinylana.model.ShinyLanaDB;
import com.shinylana.model.UserTable;
import com.shinylana.ui.Shiny_lanaUI;
import com.shinylana.ui.views.LoginViewSpec.LoginViewListener;
import com.shinylana.ui.views.LoginView;

/**
 * @author phillippohl
 * @version 0.1
 */
public class LoginPresenter implements LoginViewListener {
	//LoginModel model
	LoginView view;
	
	public LoginPresenter(/*LoginModel model, */LoginView view) {
        //this.model = model;
        this.view  = view;
        view.addListener(this);
	}

	@Override
	public void buttonClick() {
		// Retrieve user input	
		String username = view.getUsername();
		String password = view.getPassword();
		
    	if (username.trim().length() == 0 || password.trim().length() == 0) {
    		view.setDisplay("Wrong credentials.\nCheck username and password!");
    	}
    	else { 		
    		view.setDisplay("user: " + username + "\npassword: " + password);
    		Shiny_lanaUI.navigator.navigateTo(Shiny_lanaUI.MAIN_VIEW);
    	}
    	insertUser();
	}

	private void insertUser() {
    	ShinyLanaDB db = new ShinyLanaDB();
		//UserTable user = new UserTable(db.getConnectionPool());
		/*
		List list = new ArrayList();
		list.add(8);
		list.add("test_user_8");
		list.add("test_pass");
		list.add(null);
		list.add(null);
		user.insert(list);*/
	}
}