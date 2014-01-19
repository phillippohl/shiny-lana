/**
 * 
 */
package com.shinylana.model.tables;

import java.util.List;

/**
 * @author phillippohl
 * @version 0.1
 */
public class MarketTable implements ShinyLanaTableSpec {

	public static final String PROPERTY_TABLE_NAME = "market";
    public static final String PROPERTY_TABLE_ID = PROPERTY_TABLE_NAME + "id";
    public static final String PROPERTY_VOLUME = "volume";
    public static final String PROPERTY_VOLUME_CHANGE = "volume_change";
	
	/* (non-Javadoc)
	 * @see com.shinylana.model.ShinyLanaTableSpec#initContainer()
	 */
	@Override
	public void initContainer() {
		// TODO Auto-generated method stub
		
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
