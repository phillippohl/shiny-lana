/**
 * 
 */
package com.shinylana.model.tables;

import java.util.List;

/**
 * @author phillippohl
 * @version 0.1
 */
public class EventTable implements ShinyLanaTableSpec {

    public static final String PROPERTY_TABLE_NAME = "event";
    public static final String PROPERTY_TABLE_ID = PROPERTY_TABLE_NAME + "id";
    public static final String PROPERTY_TITLE = "title";
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