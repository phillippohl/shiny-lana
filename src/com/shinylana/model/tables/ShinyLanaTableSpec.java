/**
 * 
 */
package com.shinylana.model.tables;

import java.util.List;

/**
 * @author phillippohl
 * @version 0.1
 */
public interface ShinyLanaTableSpec {
	void initContainer();
	String insert(List<?> newRecord);
	List select(String username, String password);
	void delete(int index);
}
