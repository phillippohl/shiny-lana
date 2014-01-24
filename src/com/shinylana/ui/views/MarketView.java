/**
 * 
 */
package com.shinylana.ui.views;

import java.util.ArrayList;
import java.util.List;

import com.shinylana.ui.composites.MarketComposite;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

/**
 * @author phillippohl
 * @version 0.1
 */
public class MarketView extends VerticalLayout implements View {
	
    public static final String NAME = "market";
    private MarketComposite market;
	
	/**
	 * 
	 */
	public MarketView() {
        setSizeFull();
        
        market = new MarketComposite();
    	addComponent(market);
    	setComponentAlignment(market, Alignment.MIDDLE_CENTER);
	}

	/* (non-Javadoc)
	 * @see com.vaadin.navigator.View#enter(com.vaadin.navigator.ViewChangeListener.ViewChangeEvent)
	 */
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	public void setDisplay(String output) {
		Notification.show(output);
	}
	
	@SuppressWarnings("rawtypes")
	public void setTableOutput(List table_output) {
		market.addTableRow(table_output);
	}
}