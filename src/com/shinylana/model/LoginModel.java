/**
 * 
 */
package com.shinylana.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shinylana.model.tables.UserTable;
import com.vaadin.data.util.filter.Compare.Equal;
import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.query.TableQuery;

/**
 * @author phillippohl
 * @version 0.1
 */
public class LoginModel implements ShinyLanaModelSpec {

	private ShinyLanaDB db;
	private JDBCConnectionPool connectionPool = null;
    private TableQuery tq_user = null;
    private SQLContainer userContainer = null;
    private java.util.Date javaDate;
	
	/**
	 * 
	 */
	public LoginModel() {
		db = new ShinyLanaDB();
		this.connectionPool = db.getConnectionPool();
		initContainer();
	}
	
	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaModelSpec#initContainer()
	 */
	@Override
	public void initContainer() {
		javaDate = new java.util.Date();
		try {            
            tq_user = new TableQuery(UserTable.PROPERTY_TABLE_NAME, connectionPool);
            tq_user.setVersionColumn("OPTLOCK");
            userContainer = new SQLContainer(tq_user);
          } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaModelSpec#insert()
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void insert(List newRecord) {		
		initContainer();
		
        if (!userContainer.isModified()) {
            Object id = userContainer.addItem();    
            userContainer.getContainerProperty(id, UserTable.PROPERTY_TABLE_ID).setValue(userContainer.size());
            userContainer.getContainerProperty(id, UserTable.PROPERTY_USERNAME).setValue(newRecord.get(0));
            userContainer.getContainerProperty(id, UserTable.PROPERTY_PASSWORD).setValue(newRecord.get(1));
            userContainer.getContainerProperty(id, UserTable.PROPERTY_EMAIL).setValue(newRecord.get(2));
            userContainer.getContainerProperty(id, UserTable.PROPERTY_CREATE_TIME).setValue(new java.sql.Date(javaDate.getTime()));
            try {
            	userContainer.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}

	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaModelSpec#select()
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	@Override
	public List select(List<?> record) throws NullPointerException {		
		List result = new ArrayList();
		initContainer();
		
        if (!userContainer.isModified()) {
        	// username
            userContainer.addContainerFilter(new Equal(UserTable.PROPERTY_USERNAME, record.get(0)));
            // password
            userContainer.addContainerFilter(new Equal(UserTable.PROPERTY_PASSWORD, record.get(1)));
            Object id = userContainer.firstItemId();
            	
            // Return row number (user_id)
            result.add(userContainer.getItem(id).getItemProperty(UserTable.PROPERTY_TABLE_ID).getValue());
            
            try {
            	userContainer.commit();
            	userContainer.removeAllContainerFilters();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return result;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	public List checkUserName(String username) throws NullPointerException {	
		List result = new ArrayList();
		initContainer();
        if (!userContainer.isModified()) {
            userContainer.addContainerFilter(new Equal(UserTable.PROPERTY_USERNAME, username));
            Object id = userContainer.firstItemId();
            	
            // Return row number (user_id)
            result.add(userContainer.getItem(id).getItemProperty(UserTable.PROPERTY_TABLE_ID).getValue());
            
            try {
            	userContainer.commit();
            	userContainer.removeAllContainerFilters();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return result;
	}

	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaModelSpec#update()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void update(List<?> record) {
		initContainer();
        if (!userContainer.isModified()) { 
        	// username
            userContainer.addContainerFilter(new Equal(UserTable.PROPERTY_TABLE_ID, record.get(0)));
        	Object id = userContainer.firstItemId();
            userContainer.getContainerProperty(id, UserTable.PROPERTY_USERNAME).setValue(record.get(1));
            userContainer.getContainerProperty(id, UserTable.PROPERTY_PASSWORD).setValue(record.get(2));
            userContainer.getContainerProperty(id, UserTable.PROPERTY_EMAIL).setValue(record.get(3));
            userContainer.getContainerProperty(id, UserTable.PROPERTY_CREATE_TIME).setValue(new java.sql.Date(javaDate.getTime()));
            try {
            	userContainer.commit();
            	userContainer.removeAllContainerFilters();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}

	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaModelSpec#delete()
	 */
	@Override
	public void delete(int recordIndex) {
		initContainer();
        if (!userContainer.isModified()) { 
        	Object id = userContainer.getIdByIndex(recordIndex);
            System.out.println(userContainer.size());
            userContainer.removeItem(id);
            System.out.println(userContainer.size());
            try {
            	userContainer.commit();
            	userContainer.removeAllContainerFilters();
            	userContainer.refresh();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
}