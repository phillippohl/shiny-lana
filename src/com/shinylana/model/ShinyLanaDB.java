/**
 * 
 */
package com.shinylana.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;

/**
 * @author phillippohl
 * @version 0.1
 */
public class ShinyLanaDB {
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/shinylana";
	static final String DB_driver = "com.mysql.jdbc.Driver";
	SimpleJDBCConnectionPool connectionPool;
	
	public ShinyLanaDB() {
		// connect to SQL database
		connect();
	}
	
	private synchronized void connect() {
		if (connectionPool == null) {
			try {	
				connectionPool = new SimpleJDBCConnectionPool("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/shinylana", "admin", "Fibo!!112358", 2, 5);
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