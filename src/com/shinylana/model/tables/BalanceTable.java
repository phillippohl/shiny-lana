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
public class BalanceTable implements ShinyLanaTableSpec {
	
    public static final String PROPERTY_TABLE_NAME = "balance";
    public static final String PROPERTY_TABLE_ID = PROPERTY_TABLE_NAME + "_id";
    public static final String PROPERTY_EQUITY = "equity_capital";
    public static final String PROPERTY_LIABILITIES = "debt_capital";
    public static final String PROPERTY_RECEIVABLES = "receivables";
    public static final String PROPERTY_CURRENT_STOCK_PRICE = "current_stock_price";
    
	private JDBCConnectionPool connectionPool = null;
    private TableQuery tq_user = null;
    private SQLContainer userContainer = null;
	
	/**
	 * 
	 */
	public BalanceTable() {
		ShinyLanaDB db = new ShinyLanaDB();
		this.connectionPool = db.getConnectionPool();
	}
	
    public BalanceTable(JDBCConnectionPool connectionPool) {
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
            userContainer.getContainerProperty(id, PROPERTY_EQUITY).setValue(newRecord.get(1));
            userContainer.getContainerProperty(id, PROPERTY_LIABILITIES).setValue(newRecord.get(2));
            userContainer.getContainerProperty(id, PROPERTY_RECEIVABLES).setValue(newRecord.get(3));
            userContainer.getContainerProperty(id, PROPERTY_CURRENT_STOCK_PRICE).setValue(newRecord.get(4));
            try {
            	userContainer.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }	
	}

	/* (non-Javadoc)
	 * @see com.shinylana.model.tables.ShinyLanaTableSpec#select(java.util.List)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List select(List<?> record) {
		List result = new ArrayList();
		initContainer();
        if (!userContainer.isModified()) {
        	// username
            userContainer.addContainerFilter(new Equal(PROPERTY_TABLE_ID, record.get(0)));
            Object id = userContainer.firstItemId();
            	
            // Return row number (user_id)
            result.add(userContainer.getItem(id).getItemProperty(PROPERTY_TABLE_ID).getValue());
            
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getBalance(int period) {
		List result = new ArrayList();
		
		initContainer();
        if (!userContainer.isModified()) {    		
        	userContainer.addContainerFilter(new Equal(PROPERTY_TABLE_ID, period));
            Object id = userContainer.firstItemId();
            result.add(userContainer.getContainerProperty(id, PROPERTY_TABLE_ID).getValue());
            result.add(userContainer.getContainerProperty(id, PROPERTY_EQUITY).getValue());
            result.add(userContainer.getContainerProperty(id, PROPERTY_LIABILITIES).getValue());
            result.add(userContainer.getContainerProperty(id, PROPERTY_RECEIVABLES).getValue());
            result.add(userContainer.getContainerProperty(id, PROPERTY_CURRENT_STOCK_PRICE).getValue());
        }
            
        try {
        	userContainer.commit();
            userContainer.removeAllContainerFilters();
            userContainer.refresh();
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