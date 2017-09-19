package com.metacube.model;
import java.util.Comparator;

/**
 * Employee Model Class
 * @author Rahul Kumar
 *
 */
public class Employee implements Comparable<Employee>{
	int id;
	String name;
	String address;
	
	/**
	 * Employee Constructor
	 */
	public Employee(){
		
	}
	
	/**
	 * Parameterized Employee Constructor
	 * @param id
	 * @param name
	 * @param address
	 */
	public Employee(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	/**
	 * Sets the employee id
	 * @param id
	 */
	public void setEmployeeId(int id) {
		this.id = id;
	}
	
	/**
	 * sets the employee name
	 * @param name
	 */
	public void setEmployeeName(String name) {
		this.name = name;
	}
	
	/**
	 * sets the employee address
	 * @param address
	 */
	public void setEmployeeAddress(String address) {
		this.address = address;
	}
	
	/**
	 * returns the employee id
	 * @return
	 */
	public int getEmployeeId() {
		return id;
	}
	
	/**
	 * returns the employee name
	 * @return
	 */
	public String getEmployeeName() {
		return name;
	}
	
	/**
	 * returns the employee address
	 * @return
	 */
	public String getEmployeeAddress() {
		return address;
	}

	/**
	 * overrided compareTo method
	 */
	@Override
	public int compareTo(Employee o) {
		return getEmployeeId() - o.getEmployeeId();
	}
	
	/**
	 * overrided toString method
	 */
	public String toString() {
		return getEmployeeId()+" "+ getEmployeeName() + " " +getEmployeeAddress();
	}
	
	/**
	 * Inner Class NameComparator
	 * @author Rahul Kumar
	 *
	 */
	public static class NameComparator implements Comparator<Employee> {

		/**
		 * overrided method compare
		 */
		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.getEmployeeName().compareTo(o2.getEmployeeName());
		}
	}
	
	/**
	 * returns the employee id as hashCode
	 */
	public int hashCode() {
		return id;
	}
	
	/**
	 * overrided equals method
	 */
	public boolean equals(Object employee) {
		if (employee == this) {
			return true;
		} else if (!(employee instanceof Employee)) {
			return false;
		}
		
		return id == ((Employee) employee).getEmployeeId();
	}
}
