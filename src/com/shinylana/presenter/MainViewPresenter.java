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
        view.addMainViewListener(this);
	}

	/* (non-Javadoc)
	 * @see com.shinylana.ui.views.MainViewSpec.MainViewListener#SelectedTabChange()
	 */
	@Override
	public void SelectedTabChange() {
		view.setDisplay("Tab change");
		view.getCurrentTab().setCaption("dfdfdf");
	}
}