package com.metacube.collectionThree;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import com.metacube.model.Employee;

/**
 * Class have Unique Employee, removes duplicate users
 * @author Rahul Kumar
 *
 */
public class UniqueEmployees {
	Set<Employee> set = new HashSet<>();
	
	/**
	 * Adds an employee
	 * @param id
	 * @param name
	 * @param address
	 * @return
	 */
	public Employee addEmployee(int id, String name, String address) {
		Employee employee = new Employee(id,name,address);
		set.add(employee);
		return employee;
	}
	
	/**
	 * returns the list iterator of Employee table
	 * @return
	 */
	public Iterator<Employee> getIterator() {
		return set.iterator();
	}
}
