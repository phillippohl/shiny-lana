/**
 * 
 */
package com.shinylana.model;

import java.sql.SQLException;
import java.util.List;

import com.shinylana.model.tables.BalanceTable;
import com.shinylana.model.tables.UserTable;

/**
 * @author phillippohl
 * @version 0.1
 */
public class BalanceModel implements ShinyLanaModelSpec {
	
	private ShinyLanaDB db;
	private BalanceTable balance_table;
	
	/**
	 * 
	 */
	public BalanceModel() {
		db = new ShinyLanaDB();
		balance_table = new BalanceTable(db.getConnectionPool());
	}

	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaModelSpec#insert(java.util.List)
	 */
	@Override
	public void insert(List input) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaModelSpec#select(java.util.List)
	 */
	@Override
	public List select(List<?> record) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaModelSpec#update()
	 */
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaModelSpec#delete()
	 */
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	
	public List getBalance(int period) {
		return balance_table.getBalance(period);
	}
	
	public Object[] getAll() {
		return balance_table.getAll();
	}
}