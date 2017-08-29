package com.metacube.collectionOne;
import java.util.Iterator;

import com.metacube.model.Employee;
import com.metacube.util.Util;

/**
 * Main Class
 * @author Rahul Kumar
 *
 */
public class NaturalSortingMainClass {
	public static void main(String[] args) {
		NaturalSorting naturalSorting = new NaturalSorting();

		while(true) {
			System.out.println("Choose One");
			System.out.println("1. Add Employee");
			System.out.println("2. Sort Employee[According to IDs]");
			int choice = Util.getChoice();
			
			switch(choice) {
			case 1:
					int id = Util.getId();
					String name = Util.getName();
					String address = Util.getAddress();
					naturalSorting.addEmployee(id, name, address);
					break;
			case 2:
				naturalSorting.sort();
				Iterator<Employee> allEmployees = naturalSorting.getIterator();
				
				System.out.println("ID Name Address");
				System.out.println("----------------");
				while(allEmployees.hasNext()) {
					System.out.println(allEmployees.next());
				}
				System.out.println("----------------");
			}
		}
	}
}
