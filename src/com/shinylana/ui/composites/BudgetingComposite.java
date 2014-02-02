/**
 * 
 */
package com.shinylana.ui.composites;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * @author phillippohl
 * @version 0.1
 */
public class BudgetingComposite extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private Table table_1;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public BudgetingComposite() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		setupBalanceTable();
		table_1.setEditable(true);
	}
	
	private void setupBalanceTable() {
		table_1.addContainerProperty("Budget", String.class, "");
		table_1.addContainerProperty("Value", Double.class, 0);
		
		table_1.addItem(new Object[] {"Legal", TextField.class, null}, new Integer(1));
		table_1.addItem(new Object[] {"M&A", TextField.class, null}, new Integer(2));
		table_1.addItem(new Object[] {"HR", TextField.class, null}, new Integer(3));
		table_1.addItem(new Object[] {"Procurement", TextField.class, null}, new Integer(4));
		table_1.addItem(new Object[] {"Production", TextField.class, null}, new Integer(5));
		table_1.addItem(new Object[] {"R&D", TextField.class, null}, new Integer(6));
		table_1.addItem(new Object[] {"Sales", TextField.class, null}, new Integer(7));
		table_1.addItem(new Object[] {"Total", TextField.class, null}, new Integer(8));
	}

	public Table getTable() {
		return table_1;
	}

	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// table_1
		table_1 = new Table();
		table_1.setImmediate(false);
		table_1.setWidth("-1px");
		table_1.setHeight("-1px");
		mainLayout.addComponent(table_1);
		mainLayout.setComponentAlignment(table_1, new Alignment(48));
		
		return mainLayout;
	}
}