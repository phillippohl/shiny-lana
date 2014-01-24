/**
 * 
 */
package com.shinylana.presenter;

import java.util.List;

import com.shinylana.model.BalanceModel;
import com.shinylana.ui.views.BalanceView;
import com.shinylana.ui.views.BalanceViewSpec.BalanceViewListener;

/**
 * @author phillippohl
 * @version 0.1
 */
public class BalanceViewPresenter implements BalanceViewListener {
	
	BalanceModel model;
	BalanceView view;
	
	/**
	 * 
	 */
	public BalanceViewPresenter(BalanceView view) {
        this.model = new BalanceModel();
        this.view  = view;
        view.addBalanceViewListener(this);
        setTableOutput();
	}

	/* (non-Javadoc)
	 * @see com.shinylana.ui.views.BalanceViewSpec.BalanceViewListener#valueChange()
	 */
	@Override
	public void valueChange() {
		// TODO Auto-generated method stub
		
	}
	
	public void setTableOutput() {
		view.setTableOutput(getBalance(1));
	}
	
	public List getBalance(int period) {
		return model.getBalance(period);
	}
	
	public Object[] getTableInput() {
		return model.getAll();
	}
}