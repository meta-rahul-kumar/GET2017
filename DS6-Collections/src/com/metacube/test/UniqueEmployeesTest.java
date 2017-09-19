package com.metacube.test;
import static org.junit.Assert.*;
import org.junit.Test;
import com.metacube.views.UniqueEmployees;
import com.metacube.model.Employee;

/**
 * Test Cases for UniqueEmployees Class
 * @author Rahul Kumar
 *
 */
public class UniqueEmployeesTest {

	@Test
	public void addEmployeeTest_True() {
		UniqueEmployees uniqueEmployees = new UniqueEmployees();
		Employee expected = uniqueEmployees.addEmployee(1, "Rahul", "Alwar");
		assertEquals(expected, uniqueEmployees.addEmployee(1, "Rahul", "Alwar"));
	}
	
	@Test
	public void addEmployeeTest_False() {
		UniqueEmployees uniqueEmployees = new UniqueEmployees();
		Employee expected = uniqueEmployees.addEmployee(3, "Vikash", "siker");
		assertNotEquals(expected, uniqueEmployees.addEmployee(2, "Rahul", "Alwar"));
	}
}
