/**
 * 
 */
package com.shinylana.model.tables;

import java.util.List;

/**
 * @author phillippohl
 * @version 0.1
 */
public class DepartmentTable implements ShinyLanaTableSpec {

    public static final String PROPERTY_TABLE_NAME = "department";
    public static final String PROPERTY_TABLE_ID = PROPERTY_TABLE_NAME + "id";
    public static final String PROPERTY_TITLE = "title";
    public static final String PROPERTY_BUDGET = "budget";
    public static final String PROPERTY_HEADCOUNT_STAFF = "headcount_staff";
    public static final String PROPERTY_RATE_STAFF = "rate_staff";
    
	/* (non-Javadoc)
	 * @see com.shinylana.model.tables.ShinyLanaTableSpec#initContainer()
	 */
	@Override
	public void initContainer() {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see com.shinylana.model.tables.ShinyLanaTableSpec#insert(java.util.List)
	 */
	@Override
	public void insert(List<?> newRecord) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see com.shinylana.model.tables.ShinyLanaTableSpec#select(java.lang.String, java.lang.String)
	 */
	@Override
	public List select(String username, String password) {
		// TODO Auto-generated method stub
		return null;
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