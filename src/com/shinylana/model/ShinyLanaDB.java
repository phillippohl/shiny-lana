/**
 * 
 */
package com.shinylana.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.query.TableQuery;

/**
 * @author phillippohl
 * @version 0.1
 */
public class ShinyLanaDB {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/shinylana";
	private static final String DB_driver = "com.mysql.jdbc.Driver";
	private JDBCConnectionPool connectionPool;
	
	public ShinyLanaDB() {
		// connect to SQL database
		connect();
	}
	
	private synchronized void connect() {
		if (connectionPool == null) {
			try {	
				connectionPool = new SimpleJDBCConnectionPool(DB_driver, DB_URL, "admin", "Fibo!!112358", 2, 100);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Connectionpool already initiated...");
		}
	}
    
    public JDBCConnectionPool getConnectionPool() {
    	return connectionPool;
    }
	
	public static void main(String[] args) {
		ShinyLanaDB db = new ShinyLanaDB();
		UserTable user = new UserTable(db.getConnectionPool());
		
		List list = new ArrayList();
		list.add(7);
		list.add("test_user7");
		list.add("test_pass");
		list.add(null);
		list.add(null);
		user.insert(list);
	}
}