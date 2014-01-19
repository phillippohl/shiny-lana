/**
 * 
 */
package com.shinylana.model;

import java.sql.SQLException;

import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;

/**
 * @author phillippohl
 * @version 0.1
 */
public class ShinyLanaDB {
	
	private static final String DB_driver = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/shinylana";
	private static final String ADMIN_NAME = "admin";
	private static final String ADMIN_PASSWORD = "Fibo!!112358";
	private SimpleJDBCConnectionPool connectionPool;
	
	public ShinyLanaDB() {
		// connect to SQL database
		connect();
	}
	
	private synchronized void connect() {
		if (connectionPool == null) {
			try {	
				connectionPool = new SimpleJDBCConnectionPool(DB_driver, DB_URL, ADMIN_NAME, ADMIN_PASSWORD, 2, 5);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Connectionpool already initiated...");
		}
	}
    
    public SimpleJDBCConnectionPool getConnectionPool() {
    	return connectionPool;
    }
}