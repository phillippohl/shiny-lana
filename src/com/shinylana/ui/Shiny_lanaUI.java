package com.shinylana.ui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Notification.Type;
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

    public static final String NEWCOMPANY_VIEW = "newCompany";
	
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Shiny_lanaUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
        getPage().setTitle("Shiny Lana");
        
        // Create a navigator to control the views
        navigator = new Navigator(this, this);
        
        // Create and register the startup view
        //LoginView onStartupView = new LoginView();
        //navigator.addView("", onStartupView);
        //LoginPresenter onStartupPresenter = new LoginPresenter(new LoginModel(), onStartupView);
        
        LoginView loginView = new LoginView();
        navigator.addView(LoginView.NAME, loginView);
        LoginPresenter loginPresenter = new LoginPresenter(new LoginModel(), loginView);
        
        RegisterView registerView = new RegisterView();
        navigator.addView(RegisterView.NAME, registerView);
        RegisterPresenter registerPresenter = new RegisterPresenter(new LoginModel(), registerView);
        
        NewCompanyView newCompanyView = new NewCompanyView();
        navigator.addView(NEWCOMPANY_VIEW, newCompanyView);
        NewCompanyPresenter newCompanyPresenter = new NewCompanyPresenter(newCompanyView);
        
        MainView main = new MainView();
        navigator.addView(MainView.NAME, main);
        MainViewPresenter mainViewPresenter = new MainViewPresenter(main);
        
        ((Shiny_lanaUI)UI.getCurrent()).getNavigator().navigateTo(LoginView.NAME);
        
		navigator.addViewChangeListener(new ViewChangeListener() {
            @Override
            public boolean beforeViewChange(ViewChangeEvent event) {
                if (event.getNewView() instanceof MainView && getLoggedInUser() == null) {
                    Notification.show("Permission denied!\nYou have to sign yourself in!", Type.ERROR_MESSAGE);
                    navigator.navigateTo(LoginView.NAME);
                    return false;
                }
                else {
                    return true;
                }
            }

            @Override
            public void afterViewChange(ViewChangeEvent event) {

            }
        });
	}
	
	public void setLoggedInUser(String user) {
        loggedInUser = user;
    }
   
    public String getLoggedInUser() {
    	return loggedInUser;
    }
    
    public void logout() {
        // Close the VaadinServiceSession
        getUI().getSession().close();

        // Redirect to avoid keeping the removed UI open in the browser
        navigator.navigateTo(LoginView.NAME);
    }
}