package com.metacube.test;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;

import com.metacube.model.Employee;
import com.metacube.views.NaturalSorting;

/**
 * Test class for NaturalSorting Class
 * @author Rahul Kumar
 *
 */
public class NaturalSortingTest {
	
	@Test
	public void getIteratorTest_True() {
		NaturalSorting naturalSorting = new NaturalSorting();
		naturalSorting.addEmployee(1, "Rahul", "Alwar");
		Iterator<Employee> iterator = naturalSorting.getIterator(); 
		while(iterator.hasNext()) {
			Employee e = iterator.next();
			assertEquals(1 , e.getEmployeeId());
			assertEquals("Rahul", e.getEmployeeName());
			assertEquals("Alwar", e.getEmployeeAddress());
		}
		
	}
	
	@Test
	public void getIteratorTest_False() {
		NaturalSorting naturalSorting = new NaturalSorting();
		naturalSorting.addEmployee(1, "Rahul", "Alwar");
		Iterator<Employee> iterator = naturalSorting.getIterator(); 
		while(iterator.hasNext()) {
			Employee e = iterator.next();
			assertEquals(1 , e.getEmployeeId());
			assertEquals("Rahul", e.getEmployeeName());
			assertNotEquals("Sikar", e.getEmployeeAddress());
		}
		
	}
}
