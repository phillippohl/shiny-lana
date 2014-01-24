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
public class MarketTable implements ShinyLanaTableSpec {

	public static final String PROPERTY_TABLE_NAME = "market";
    public static final String PROPERTY_TABLE_ID = PROPERTY_TABLE_NAME + "_id";
    public static final String PROPERTY_MARKET_NAME = PROPERTY_TABLE_NAME + "_name";
    public static final String PROPERTY_VOLUME = "volume";
    public static final String PROPERTY_VOLUME_CHANGE = PROPERTY_VOLUME + "_change";
    
	private JDBCConnectionPool connectionPool = null;
    private TableQuery tq_user = null;
    private SQLContainer userContainer = null;
    
	public MarketTable() {
		ShinyLanaDB db = new ShinyLanaDB();
		this.connectionPool = db.getConnectionPool();
	}
    
    public MarketTable(JDBCConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
		initContainer();
	}
    
	/* (non-Javadoc)
	 * @see com.shinylana.model.tables.ShinyLanaTableSpec#initContainer()
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
	 * @see com.shinylana.model.tables.ShinyLanaTableSpec#insert(java.util.List)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void insert(List<?> newRecord) {
		initContainer();
        if (!userContainer.isModified()) {
            Object id = userContainer.addItem();    
            userContainer.getContainerProperty(id, PROPERTY_TABLE_ID).setValue(userContainer.size());
            userContainer.getContainerProperty(id, PROPERTY_MARKET_NAME).setValue(newRecord.get(1));
            userContainer.getContainerProperty(id, PROPERTY_VOLUME).setValue(newRecord.get(2));
            userContainer.getContainerProperty(id, PROPERTY_VOLUME_CHANGE).setValue(newRecord.get(3));
            try {
            	userContainer.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
	/* (non-Javadoc)
	 * @see com.shinylana.model.tables.ShinyLanaTableSpec#select(java.lang.String, java.lang.String)
	 */
	@Override
	public List select(List<?> record) {
		List result = new ArrayList();
		initContainer();
        if (!userContainer.isModified()) {
        	// Find market via market_name
            userContainer.addContainerFilter(new Equal("username", record.get(1)));
            Object id = userContainer.firstItemId();
            	
            // Return row number (market_id)
            result.add(userContainer.getItem(id).getItemProperty("PROPERTY_TABLE_ID").getValue());
            
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
	 * @see com.shinylana.model.tables.ShinyLanaTableSpec#delete(int)
	 */
	@Override
	public void delete(int index) {
		// TODO Auto-generated method stub
		
	}
}