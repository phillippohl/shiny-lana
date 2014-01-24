/**
 * 
 */
package com.shinylana.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shinylana.model.tables.BalanceTable;
import com.shinylana.model.tables.MarketTable;
import com.vaadin.data.util.filter.Compare.Equal;
import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.query.TableQuery;

/**
 * @author phillippohl
 * @version 0.1
 */
public class MarketModel implements ShinyLanaModelSpec {
	
	private ShinyLanaDB db;
	private JDBCConnectionPool connectionPool = null;
    private TableQuery tq_user = null;
    private SQLContainer userContainer = null;
	
	/**
	 * 
	 */
	public MarketModel() {
		db = new ShinyLanaDB();
		this.connectionPool = db.getConnectionPool();
		initContainer();
	}
	
	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaModelSpec#initContainer()
	 */
	@Override
	public void initContainer() {
        try {            
            tq_user = new TableQuery(MarketTable.PROPERTY_TABLE_NAME, connectionPool);
            tq_user.setVersionColumn("OPTLOCK");
            userContainer = new SQLContainer(tq_user);
          } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaModelSpec#insert(java.util.List)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void insert(List newRecord) {		
		initContainer();
        if (!userContainer.isModified()) {
            Object id = userContainer.addItem();    
            userContainer.getContainerProperty(id, MarketTable.PROPERTY_TABLE_ID).setValue(userContainer.size());
            userContainer.getContainerProperty(id, MarketTable.PROPERTY_MARKET_NAME).setValue(newRecord.get(1));
            userContainer.getContainerProperty(id, MarketTable.PROPERTY_VOLUME).setValue(newRecord.get(2));
            userContainer.getContainerProperty(id, MarketTable.PROPERTY_VOLUME_CHANGE).setValue(newRecord.get(3));
            try {
            	userContainer.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}

	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaModelSpec#select(java.util.List)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List select(List<?> record) {
		List result = new ArrayList();
		initContainer();
		
        if (!userContainer.isModified()) {
        	// market_id
            userContainer.addContainerFilter(new Equal(MarketTable.PROPERTY_TABLE_ID, record.get(0)));
            Object id = userContainer.firstItemId();
            	
            // Return row number (market_id)
            result.add(userContainer.getItem(id).getItemProperty(MarketTable.PROPERTY_TABLE_ID).getValue());
            
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
	 * @see com.shinylana.model.ShinyLanaModelSpec#update()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void update(List<?> record) {
		initContainer();
        if (!userContainer.isModified()) { 
            userContainer.addContainerFilter(new Equal(MarketTable.PROPERTY_TABLE_ID, record.get(0)));
        	Object id = userContainer.firstItemId();
            userContainer.getContainerProperty(id, MarketTable.PROPERTY_MARKET_NAME).setValue(record.get(1));
            userContainer.getContainerProperty(id, MarketTable.PROPERTY_VOLUME).setValue(record.get(2));
            userContainer.getContainerProperty(id, MarketTable.PROPERTY_VOLUME_CHANGE).setValue(record.get(3));
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
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getMarket(int market_id) {
		List result = new ArrayList();
		initContainer();
        if (!userContainer.isModified()) {    	
            userContainer.addContainerFilter(new Equal(MarketTable.PROPERTY_TABLE_ID, market_id));
            Object id = userContainer.firstItemId();
            System.out.println(userContainer);
            result.add(userContainer.getContainerProperty(id, MarketTable.PROPERTY_TABLE_ID).getValue());
            result.add(userContainer.getContainerProperty(id, MarketTable.PROPERTY_MARKET_NAME).getValue());
            result.add(userContainer.getContainerProperty(id, MarketTable.PROPERTY_VOLUME).getValue());
            result.add(userContainer.getContainerProperty(id, MarketTable.PROPERTY_VOLUME_CHANGE).getValue());
        }
            
        try {
        	userContainer.commit();
            userContainer.removeAllContainerFilters();
        } catch (SQLException e) {
        	e.printStackTrace();
        }		
		return result;
	}
}