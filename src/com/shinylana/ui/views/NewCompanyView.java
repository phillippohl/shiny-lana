/**
 * 
 */
package com.shinylana.ui.views;

import java.util.ArrayList;
import java.util.List;

import com.shinylana.ui.composites.NewCompanyComposite;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickListener;

/**
 * @author phillippohl
 * @version 0.1
 */
@SuppressWarnings("serial")
public class NewCompanyView extends VerticalLayout implements View, ClickListener, NewCompanyViewSpec {
	
    private List<NewCompanyViewListener> listeners = new ArrayList<NewCompanyViewListener>();
    private NewCompanyComposite composite_1;
    
    public NewCompanyView() {
    	setSizeFull();
        
        composite_1 = new NewCompanyComposite();
        composite_1.getButton().addClickListener(this);
    	addComponent(composite_1);
        setComponentAlignment(composite_1, Alignment.MIDDLE_CENTER);   
    }
    

	/* (non-Javadoc)
	 * @see com.vaadin.navigator.View#enter(com.vaadin.navigator.ViewChangeListener.ViewChangeEvent)
	 */
	@Override
	public void enter(ViewChangeEvent event) {
    	setDisplay("Shapen your first company!");		
	}

	/* (non-Javadoc)
	 * @see com.vaadin.ui.Button.ClickListener#buttonClick(com.vaadin.ui.Button.ClickEvent)
	 */
	@Override
	public void buttonClick(ClickEvent event) {
        for (NewCompanyViewListener listener: listeners) {
            listener.buttonClick(composite_1.getInputs());
        }
	}
	
	/* (non-Javadoc)
	 * @see com.shinylana.ui.views.NewCompanyViewSpec#setDisplay(java.lang.String)
	 */
	@Override
	public void setDisplay(String output) {
		Notification.show(output);	
	}

	/* (non-Javadoc)
	 * @see com.shinylana.ui.views.NewCompanyViewSpec#addListener(com.shinylana.ui.views.NewCompanyViewSpec.NewCompanyViewListener)
	 */
	@Override
	public void addListener(NewCompanyViewListener listener) {
		listeners.add(listener);
	}
}