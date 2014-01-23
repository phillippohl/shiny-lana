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
	void insert(List<?> newRecord);
	List select(String username, String password);
	void update();
	void delete(int index);
}