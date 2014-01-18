/**
 * 
 */
package com.shinylana.model;

import java.sql.SQLException;
import java.util.List;

import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.query.TableQuery;

/**
 * @author phillippohl
 * @version 0.1
 */
public class CompanyTable implements ShinyLanaTableSpec {

    public static final String PROPERTY_TABLE_NAME = "company";
    public static final String PROPERTY_TABLE_ID = PROPERTY_TABLE_NAME + "id";
    public static final String PROPERTY_TITLE = "title";
    public static final String PROPERTY_FOUNDATION_DATE = "foundation_date";
    public static final String PROPERTY_OWNER = "owner";
    public static final String PROPERTY_COMPANY_TYPE = "company_type";
    public static final String PROPERTY_HEADQUARTER_COUNTRY = "headquarter_country";
    public static final String PROPERTY_DEPARTMENT = "department";
    public static final String PROPERTY_BALANCE = "balance";
    
    private JDBCConnectionPool connectionPool = null;
    private SQLContainer companyContainer = null;
	private TableQuery tq_company = null;
	
	public CompanyTable() {
		ShinyLanaDB db = new ShinyLanaDB();
		this.connectionPool = db.getConnectionPool();
		initContainer();
	}
    
    public CompanyTable(JDBCConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
		initContainer();
	}
	
	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaTableSpec#initContainer()
	 */
	@Override
	public void initContainer() {
        try {            
        	tq_company = new TableQuery(PROPERTY_TABLE_NAME, connectionPool);
        	tq_company.setVersionColumn("OPTLOCK");
        	companyContainer = new SQLContainer(tq_company);
          } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaTableSpec#insert(java.util.List)
	 */
	@Override
	public String insert(List<?> newRecord) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaTableSpec#delete(int)
	 */
	@Override
	public void delete(int index) {
		// TODO Auto-generated method stub
		
	}

}