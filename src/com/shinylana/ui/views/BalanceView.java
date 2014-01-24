/**
 * 
 */
package com.shinylana.ui.views;

import java.util.ArrayList;
import java.util.List;

import com.shinylana.ui.composites.BalanceComposite;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

/**
 * @author phillippohl
 * @version 0.1
 */
@SuppressWarnings("serial")
public class BalanceView extends VerticalLayout implements ValueChangeListener, BalanceViewSpec {
	
    public static final String NAME = "balance";
	private List<BalanceViewListener> listeners = new ArrayList<BalanceViewListener>();
    private BalanceComposite balance;
	
	/**
	 * 
	 */
	public BalanceView() {
        setSizeFull();
        
        balance = new BalanceComposite();
        balance.getTable().addValueChangeListener(this);
    	addComponent(balance);
    	setComponentAlignment(balance, Alignment.MIDDLE_CENTER);
	}
	
	/* (non-Javadoc)
	 * @see com.vaadin.navigator.View#enter(com.vaadin.navigator.ViewChangeListener.ViewChangeEvent)
	 */
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.shinylana.ui.views.BalanceViewSpec#setDisplay(java.lang.String)
	 */
	@Override
	public void setDisplay(String output) {
		Notification.show(output);
	}

	/* (non-Javadoc)
	 * @see com.shinylana.ui.views.BalanceViewSpec#addBalanceViewListener(com.shinylana.ui.views.BalanceViewSpec.BalanceViewListener)
	 */
	@Override
	public void addBalanceViewListener(BalanceViewListener listener) {
		listeners.add(listener);
	}

	/* (non-Javadoc)
	 * @see com.vaadin.data.Property.ValueChangeListener#valueChange(com.vaadin.data.Property.ValueChangeEvent)
	 */
	@Override
	public void valueChange(ValueChangeEvent event) {
        for (BalanceViewListener listener: listeners) {
            listener.valueChange();
        }	
	}
	
	public void setTableOutput(List table_output) {
		balance.addAssetRow(table_output);
		balance.addLiabilitiesEquityRow(table_output);
	}
}