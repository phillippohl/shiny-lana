/**
 * 
 */
package com.shinylana.presenter;

import java.util.List;

import com.shinylana.model.MarketModel;
import com.shinylana.ui.views.MarketView;

/**
 * @author phillippohl
 * @version 0.1
 */
public class MarketViewPresenter {
	
	MarketModel model;
	MarketView view;
	
	/**
	 * 
	 */
	public MarketViewPresenter(MarketView view) {
        this.model = new MarketModel();
        this.view  = view;
        setTableOutput();
	}
	
	public void setTableOutput() {
		view.setTableOutput(getMarket(1));
	}
	
	@SuppressWarnings("rawtypes")
	public List getMarket(int market_id) {
		return model.getMarket(market_id);
	}
}