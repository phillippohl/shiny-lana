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
	List select(List<?> record);
	void update();
	void delete(int index);
}