/**
 * 
 */
package com.shinylana.model.tables;

import java.util.ArrayList;
import java.util.List;

import com.shinylana.model.ShinyLanaDB;
import com.shinylana.model.ShinyLanaModelSpec;

/**
 * @author phillippohl
 * @version 0.1
 */
public class LoginModel implements ShinyLanaModelSpec {

	private ShinyLanaDB db;
	private UserTable userTable;
	
	/**
	 * 
	 */
	public LoginModel() {
		db = new ShinyLanaDB();
		userTable = new UserTable(db.getConnectionPool());
	}

	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaModelSpec#insert()
	 */
	@Override
	public void insert(List input) {		
		List list = new ArrayList();
		list.add(9);
		list.add(input.get(0));
		list.add(input.get(1));
		list.add(null);
		list.add(null);
		userTable.insert(list);	
	}

	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaModelSpec#select()
	 */
	@Override
	public List select(String username, String password) {
		List result = new ArrayList();
		result = userTable.select(username, password);
		return result;
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
		// No need to implement		
	}
}