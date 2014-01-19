package com.shinylana.ui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.shinylana.ui.views.LoginView;
import com.shinylana.ui.views.MainView;
import com.shinylana.ui.views.NewCompanyView;
import com.shinylana.ui.views.RegisterView;
import com.shinylana.model.tables.LoginModel;
import com.shinylana.presenter.LoginPresenter;
import com.shinylana.presenter.MainViewPresenter;
import com.shinylana.presenter.NewCompanyPresenter;
import com.shinylana.presenter.RegisterPresenter;

@PreserveOnRefresh
@SuppressWarnings("serial")
@Theme("shiny-lanatheme")
public class Shiny_lanaUI extends UI {
	
	private Navigator navigator;
	private String loggedInUser;
    public static final String LOGIN_VIEW = "login";
    public static final String REGISTER_VIEW = "register";
    public static final String NEWCOMPANY_VIEW = "newCompany";
    public static final String MAIN_VIEW = "main";
	
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Shiny_lanaUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
        getPage().setTitle("Shiny Lana");
        
        // Create a navigator to control the views
        navigator = new Navigator(this, this);
        
        // Create and register the views
        LoginView loginView = new LoginView();
        navigator.addView("", loginView);
        LoginPresenter loginPresenter = new LoginPresenter(new LoginModel(), loginView);
        
        RegisterView registerView = new RegisterView();
        navigator.addView(REGISTER_VIEW, registerView);
        RegisterPresenter registerPresenter = new RegisterPresenter(new LoginModel(), registerView);
        
        NewCompanyView newCompanyView = new NewCompanyView();
        navigator.addView(NEWCOMPANY_VIEW,newCompanyView);
        NewCompanyPresenter newCompanyPresenter = new NewCompanyPresenter(newCompanyView);
        
        MainView skeleton = new MainView();
        navigator.addView(MAIN_VIEW,skeleton);
        MainViewPresenter mainViewPresenter = new MainViewPresenter(skeleton);
	}
	
	public void setLoggedInUser(String user) {
        loggedInUser = user;
    }
   
    public String getLoggedInUser() {
    	return loggedInUser;
    }
}