package com.metacube.collectionOne;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.metacube.model.Employee;

/**
 * Class performs the natural sorting (According to Employee Id)
 * @author Rahul Kumar
 *
 */
public class NaturalSorting {
	List<Employee> list = new ArrayList<>();
	
	/**
	 * Adds an Employee
	 * @param id
	 * @param name
	 * @param address
	 */
	public void addEmployee(int id, String name, String address) {
		Employee employee = new Employee(id,name,address);
		list.add(employee);
	}
	
	/**
	 * sorts the employees according to employee id
	 */
	public void sort() {
		Collections.sort(list);
	}
	
	/**
	 * returns the list iterator of Employee table
	 * @return
	 */
	public Iterator<Employee> getIterator() {
		return list.iterator();
	}
	
}
