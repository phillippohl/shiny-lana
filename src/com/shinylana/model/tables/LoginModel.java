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
	public void insert(List newUser) {	
		List newUserRecord = new ArrayList();
		newUserRecord.add(10);
		newUserRecord.add(newUser.get(0));
		newUserRecord.add(newUser.get(1));
		newUserRecord.add(null);
		newUserRecord.add(null);
		userTable.insert(newUserRecord);	
	}

	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaModelSpec#select()
	 */
	@Override
	public List select(List<?> record) {
		List result = new ArrayList();
		result = userTable.select(record);
		return result;
	}
	
	public List checkUserName(String username) {
		List result = new ArrayList();
		result = userTable.checkUserName(username);
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