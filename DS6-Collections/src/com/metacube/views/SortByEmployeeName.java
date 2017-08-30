package com.metacube.views;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import com.metacube.model.Employee;
import com.metacube.model.Employee.NameComparator;

/**
 * Class Sorts the Employees According to Names of Employees
 * @author Rahul Kumar
 *
 */
public class SortByEmployeeName {
	List<Employee> list = new ArrayList<>();
	
	/**
	 * Adds an employee
	 * @param id
	 * @param name
	 * @param address
	 */
	public void addEmployee(int id, String name, String address) {
		Employee employee = new Employee(id,name,address);
		list.add(employee);
	}
	
	/**
	 * sorts the employee according to their names
	 */
	public void sort() {
		Collections.sort(list,new NameComparator());
	}
	
	/**
	 * returns the list iterator of Employee table
	 * @return
	 */
	public Iterator<Employee> getIterator() {
		return list.iterator();
	}
}
