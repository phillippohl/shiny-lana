/**
 * 
 */
package com.shinylana.model;

import java.util.List;

/**
 * @author phillippohl
 * @version 0.1
 */
public interface ShinyLanaModelSpec {
	// Insert data into DB
	void insert(List<?> input);
	
	// Retrieve data from DB
	@SuppressWarnings("rawtypes")
	List select(List<?> record);
	
	// Update data in DB
	void update(List<?> record);
	
	// Delete data from DB
	void delete(int recordIndex); 
}
