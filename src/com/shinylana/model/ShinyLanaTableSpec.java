/**
 * 
 */
package com.shinylana.model;

import java.util.List;

/**
 * @author phillippohl
 * @version 0.1
 */
public interface ShinyLanaTableSpec {
	void initContainer();
	String insert(List<?> newRecord);
	void delete(int index);
}
