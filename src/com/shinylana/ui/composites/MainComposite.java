/**
 * 
 */
package com.shinylana.ui.composites;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

/**
 * @author phillippohl
 * @version 0.1
 */
public class MainComposite extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private Panel panel_1;
	@AutoGenerated
	private VerticalLayout verticalLayout_4;
	@AutoGenerated
	private TabSheet tabSheet_1;
	@AutoGenerated
	private VerticalLayout verticalLayout_2;
	@AutoGenerated
	private MenuBar menuBar_1;
	private VerticalLayout tab_1;
	private VerticalLayout tab_2;
	private VerticalLayout tab_3;
	private VerticalLayout tab_4;
	private VerticalLayout tab_5;
	private MenuBar.MenuItem menuBarItemUser;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public MainComposite() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		setupMenuBar();
	}

	private void setupMenuBar() {
		MenuBar.Command menuBarCommand_1 = new MenuBar.Command() {
		    public void menuSelected(MenuItem selectedItem) {
		    	setupTabSheet(0);
		    }  
		};
		
		MenuBar.Command menuBarCommand_2 = new MenuBar.Command() {
		    public void menuSelected(MenuItem selectedItem) {
		    	setupTabSheet(1);
		    }  
		};
		
		MenuBar.Command menuBarCommand_3 = new MenuBar.Command() {
		    public void menuSelected(MenuItem selectedItem) {
		    	setupTabSheet(2);
		    }  
		};
		
		MenuBar.Command menuBarCommand_9 = new MenuBar.Command() {
		    public void menuSelected(MenuItem selectedItem) {
		    	setupTabSheet(8);
		    }  
		};
		
		MenuBar.MenuItem menuBarItemFinance = menuBar_1.addItem("Finance", null, menuBarCommand_1);	
		MenuBar.MenuItem menuBarItemLegal = menuBar_1.addItem("Legal", null, menuBarCommand_2);
		MenuBar.MenuItem menuBarItemMA = menuBar_1.addItem("M&A", null, menuBarCommand_3);
		MenuBar.MenuItem menuBarItemHR = menuBar_1.addItem("HR", null, null);
		MenuBar.MenuItem menuBarItemProcurement = menuBar_1.addItem("Procurement", null, null);
		MenuBar.MenuItem menuBarItemProduction = menuBar_1.addItem("Production", null, null);
		MenuBar.MenuItem menuBarItemRD = menuBar_1.addItem("R&D", null, null);
		MenuBar.MenuItem menuBarItemSales = menuBar_1.addItem("Sales", null, null);
		menuBarItemUser = menuBar_1.addItem("User", null, menuBarCommand_9);
	}
	
	public void setMenuBarItemUser(String menuBarItemUserName) {
		menuBarItemUser.setText("User: " + menuBarItemUserName);
	}
	
	private void setupTabSheet(int selection) {
		
		tabSheet_1.removeAllComponents();
		
		switch (selection) {
		case 0:
			tab_1 = new VerticalLayout();
			tabSheet_1.addTab(tab_1, "Balance");
			tab_2 = new VerticalLayout();
			tabSheet_1.addTab(tab_2, "Budgeting");
			tab_3 = new VerticalLayout();
			tabSheet_1.addTab(tab_3, "Receivables");
			tab_4 = new VerticalLayout();
			tabSheet_1.addTab(tab_4, "Stocks");
			break;
		case 1:
			tab_1 = new VerticalLayout();
			tabSheet_1.addTab(tab_1, "Budget");
			tab_2 = new VerticalLayout();
			tabSheet_1.addTab(tab_2, "Change company");
			tab_3 = new VerticalLayout();
			tabSheet_1.addTab(tab_3, "Law sues");
			tab_4 = new VerticalLayout();
			tabSheet_1.addTab(tab_4, "Receivables");
			break;
		case 2:
			tab_1 = new VerticalLayout();
			tabSheet_1.addTab(tab_1, "Budget");
			tab_2 = new VerticalLayout();
			tabSheet_1.addTab(tab_2, "Join Ventures");
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			tab_1 = new VerticalLayout();
			tabSheet_1.addTab(tab_1, "Account");
			tab_2 = new VerticalLayout();
			tabSheet_1.addTab(tab_2, "Settings");
			tab_3 = new VerticalLayout();
			tabSheet_1.addTab(tab_3, "Logout");
			break;
		case 9:
			break;
		default:
			
		}
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
		
		// menuBar_1
		menuBar_1 = new MenuBar();
		menuBar_1.setImmediate(false);
		menuBar_1.setWidth("100.0%");
		menuBar_1.setHeight("-1px");
		mainLayout.addComponent(menuBar_1);
		mainLayout.setComponentAlignment(menuBar_1, new Alignment(20));
		
		// tabSheet_1
		tabSheet_1 = buildTabSheet_1();
		mainLayout.addComponent(tabSheet_1);
		mainLayout.setExpandRatio(tabSheet_1, 1.0f);
		
		// panel_1
		panel_1 = buildPanel_1();
		mainLayout.addComponent(panel_1);
		
		return mainLayout;
	}

	@AutoGenerated
	private TabSheet buildTabSheet_1() {
		// common part: create layout
		tabSheet_1 = new TabSheet();
		tabSheet_1.setImmediate(true);
		tabSheet_1.setWidth("100.0%");
		tabSheet_1.setHeight("100.0%");
		
		return tabSheet_1;
	}

	@AutoGenerated
	private Panel buildPanel_1() {
		// common part: create layout
		panel_1 = new Panel();
		panel_1.setImmediate(false);
		panel_1.setWidth("100.0%");
		panel_1.setHeight("30px");
		
		// verticalLayout_4
		verticalLayout_4 = new VerticalLayout();
		verticalLayout_4.setImmediate(false);
		verticalLayout_4.setWidth("100.0%");
		verticalLayout_4.setHeight("100.0%");
		verticalLayout_4.setMargin(false);
		//verticalLayout_4.addComponent(new Footer());
		panel_1.setContent(verticalLayout_4);
		
		return panel_1;
	}
	
	public TabSheet getTabSheet() {
		return tabSheet_1;
	}
	
	public void setTabSheetContent(Component content) {
		tab_1.removeAllComponents();
		tab_1.addComponent(content);
	}
}