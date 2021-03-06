/**
 * 
 */
package com.shinylana.presenter;

import com.shinylana.ui.Shiny_lanaUI;
import com.shinylana.ui.views.MainView;
import com.shinylana.ui.views.MainViewSpec.MainViewListener;
import com.vaadin.ui.UI;

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
        view.addMainViewListener(this);
	}

	/* (non-Javadoc)
	 * @see com.shinylana.ui.views.MainViewSpec.MainViewListener#SelectedTabChange()
	 */
	@Override
	public void SelectedTabChange() {
		view.setDisplay("Tab change");
		System.out.println(view.getCurrentTab().getCaption());
		if (view.getCurrentTab().getCaption().equals("Logout")) {
			((Shiny_lanaUI)UI.getCurrent()).logout();
		}
	}
}