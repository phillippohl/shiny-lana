/**
 * 
 */
package com.shinylana.model;

import java.util.ArrayList;
import java.util.List;

import com.shinylana.model.tables.MarketTable;
import com.shinylana.ui.Shiny_lanaUI;
import com.vaadin.ui.UI;

/**
 * @author phillippohl
 * @version 0.1
 */
public class MarketModel implements ShinyLanaModelSpec {
	
	private ShinyLanaDB db;
	private MarketTable market_table;
	
	/**
	 * 
	 */
	public MarketModel() {
		db = new ShinyLanaDB();
		market_table = new MarketTable(db.getConnectionPool());
	}

	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaModelSpec#insert(java.util.List)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void insert(List input) {
		List newRecord = new ArrayList();
		// market_name
		newRecord.add(input.get(0));
		// volume
		newRecord.add(input.get(1));
		// volume_change
		newRecord.add(input.get(2));
		market_table.insert(newRecord);		
	}

	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaModelSpec#select(java.util.List)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List select(List<?> record) {
		return market_table.select(record);
	}

	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaModelSpec#update()
	 */
	@Override
	public void update(List input) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaModelSpec#delete()
	 */
	@Override
	public void delete(int recordIndex) {
		// TODO Auto-generated method stub
		
	}
}