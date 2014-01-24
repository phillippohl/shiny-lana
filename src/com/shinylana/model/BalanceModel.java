/**
 * 
 */
package com.shinylana.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shinylana.model.tables.BalanceTable;
import com.vaadin.data.util.filter.Compare.Equal;
import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.query.TableQuery;

/**
 * @author phillippohl
 * @version 0.1
 */
public class BalanceModel implements ShinyLanaModelSpec {
	
	private ShinyLanaDB db;
	private JDBCConnectionPool connectionPool = null;
    private TableQuery tq_user = null;
    private SQLContainer userContainer = null;
	
	/**
	 * 
	 */
	public BalanceModel() {
		db = new ShinyLanaDB();
		this.connectionPool = db.getConnectionPool();
	}

	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaModelSpec#initContainer()
	 */
	@Override
	public void initContainer() {
		try {            
            tq_user = new TableQuery(BalanceTable.PROPERTY_TABLE_NAME, connectionPool);
            tq_user.setVersionColumn("OPTLOCK");
            userContainer = new SQLContainer(tq_user);
          } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaModelSpec#insert(java.util.List)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void insert(List<?> newRecord) {
		initContainer();
        if (!userContainer.isModified()) {
            Object id = userContainer.addItem();    
            userContainer.getContainerProperty(id, BalanceTable.PROPERTY_TABLE_ID).setValue(userContainer.size());
            userContainer.getContainerProperty(id, BalanceTable.PROPERTY_EQUITY).setValue(newRecord.get(1));
            userContainer.getContainerProperty(id, BalanceTable.PROPERTY_LIABILITIES).setValue(newRecord.get(2));
            userContainer.getContainerProperty(id, BalanceTable.PROPERTY_RECEIVABLES).setValue(newRecord.get(3));
            userContainer.getContainerProperty(id, BalanceTable.PROPERTY_CURRENT_STOCK_PRICE).setValue(newRecord.get(4));
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List select(List<?> record) {
		List result = new ArrayList();
		initContainer();
        if (!userContainer.isModified()) {
        	// username
            userContainer.addContainerFilter(new Equal(BalanceTable.PROPERTY_TABLE_ID, record.get(0)));
            Object id = userContainer.firstItemId();
            	
            // Return row number (user_id)
            result.add(userContainer.getItem(id).getItemProperty(BalanceTable.PROPERTY_TABLE_ID).getValue());
            
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
            userContainer.addContainerFilter(new Equal(BalanceTable.PROPERTY_TABLE_ID, record.get(0)));
        	Object id = userContainer.firstItemId();
            userContainer.getContainerProperty(id, BalanceTable.PROPERTY_EQUITY).setValue(record.get(1));
            userContainer.getContainerProperty(id, BalanceTable.PROPERTY_LIABILITIES).setValue(record.get(2));
            userContainer.getContainerProperty(id, BalanceTable.PROPERTY_RECEIVABLES).setValue(record.get(3));
            userContainer.getContainerProperty(id, BalanceTable.PROPERTY_CURRENT_STOCK_PRICE).setValue(record.get(4));
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
	
	public void nextPeriod() {
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getBalance(int period) {
		List result = new ArrayList();
		initContainer();
        if (!userContainer.isModified()) {    	
            userContainer.addContainerFilter(new Equal(BalanceTable.PROPERTY_TABLE_ID, period));
            Object id = userContainer.firstItemId();
            System.out.println(userContainer);
            result.add(userContainer.getContainerProperty(id, BalanceTable.PROPERTY_TABLE_ID).getValue());
            result.add(userContainer.getContainerProperty(id, BalanceTable.PROPERTY_EQUITY).getValue());
            result.add(userContainer.getContainerProperty(id, BalanceTable.PROPERTY_LIABILITIES).getValue());
            result.add(userContainer.getContainerProperty(id, BalanceTable.PROPERTY_RECEIVABLES).getValue());
            result.add(userContainer.getContainerProperty(id, BalanceTable.PROPERTY_CURRENT_STOCK_PRICE).getValue());
        }
            
        try {
        	userContainer.commit();
            userContainer.removeAllContainerFilters();
        } catch (SQLException e) {
        	e.printStackTrace();
        }		
		return result;
	}
	
	public Object[] getAll() {
		Object[] result = new Object[100];
		int counter = 0;
		
		initContainer();
        if (!userContainer.isModified()) {         

        	for (Object id : userContainer.getItemIds()) {     		
        		result[counter] = userContainer.getItem(id);
        		//result[counter] = userContainer.getItem(id).getItemProperty(PROPERTY_TABLE_ID).getValue();
        		System.out.println(result[counter]);
        		counter++;
        	}           
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