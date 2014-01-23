/**
 * 
 */
package com.shinylana.model.tables;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shinylana.model.ShinyLanaDB;
import com.vaadin.data.util.filter.Compare.Equal;
import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.query.TableQuery;

/**
 * @author phillippohl
 * @version 0.1
 */
public class UserTable implements ShinyLanaTableSpec {
	
    public static final String PROPERTY_TABLE_NAME = "user";
    public static final String PROPERTY_TABLE_ID = PROPERTY_TABLE_NAME + "id";
    public static final String PROPERTY_USERNAME = "username";
    public static final String PROPERTY_PASSWORD = "password";
    public static final String PROPERTY_EMAIL = "email";
    public static final String PROPERTY_CREATE_TIME = "create_time";
    
	private JDBCConnectionPool connectionPool = null;
    private TableQuery tq_user = null;
    private SQLContainer userContainer = null;

	public UserTable() {
		ShinyLanaDB db = new ShinyLanaDB();
		this.connectionPool = db.getConnectionPool();
	}
    
    public UserTable(JDBCConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
		initContainer();
	}
	
	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaTableSpec#initContainer()
	 */
	@Override
	public void initContainer() {
        try {            
            tq_user = new TableQuery(PROPERTY_TABLE_NAME, connectionPool);
            tq_user.setVersionColumn("OPTLOCK");
            userContainer = new SQLContainer(tq_user);
          } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaTableSpec#insert(java.util.List)
	 */
	@Override
	public void insert(List<?> newUserRecord) {
		initContainer();
        if (!userContainer.isModified()) {
            Object id = userContainer.addItem();    
            userContainer.getContainerProperty(id, "user_id").setValue(userContainer.size());
            userContainer.getContainerProperty(id, "username").setValue(newUserRecord.get(1));
            userContainer.getContainerProperty(id, "password").setValue(newUserRecord.get(2));
            userContainer.getContainerProperty(id, "email").setValue(newUserRecord.get(3));
            userContainer.getContainerProperty(id, "create_time").setValue(newUserRecord.get(4));
            try {
            	userContainer.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
	
	/* (non-Javadoc)
	 * @see com.shinylana.model.tables.ShinyLanaTableSpec#select()
	 */
	@Override
	public List select(String username, String password) throws NullPointerException {
		List result = new ArrayList();
		initContainer();
        if (!userContainer.isModified()) {
            userContainer.addContainerFilter(new Equal("username", username));
            userContainer.addContainerFilter(new Equal("password", password));
            Object id = userContainer.firstItemId();
            	
            // Return row number (user_id)
            result.add(userContainer.getItem(id).getItemProperty("user_id").getValue());
            
            try {
            	userContainer.commit();
            	userContainer.removeAllContainerFilters();
            	userContainer.refresh();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return result;
	}
	
	/* (non-Javadoc)
	 * @see com.shinylana.model.tables.ShinyLanaTableSpec#update()
	 */
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaTableSpec#delete(int)
	 */
	@Override
	public void delete(int index) {
		// TODO Auto-generated method stub
		
	}
	
	public List checkUserName(String username) throws NullPointerException {
		List result = new ArrayList();
		initContainer();
        if (!userContainer.isModified()) {
            userContainer.addContainerFilter(new Equal("username", username));
            Object id = userContainer.firstItemId();
            	
            // Return row number (user_id)
            result.add(userContainer.getItem(id).getItemProperty("user_id").getValue());
            
            try {
            	userContainer.commit();
            	userContainer.removeAllContainerFilters();
            	userContainer.refresh();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return result;
	}
}