package com.metacube.test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.metacube.main.Student;
import com.metacube.main.TreeSort;

/**
 * Test Class For TreeSort methods
 * 
 * @author Rahul Kumar
 *
 */
public class TreeSortTest {

	@Test
	public void insertTest_True() {
		TreeSort treeSort = new TreeSort();
		Student student = new Student(5, "Rahul");
		int expected = 5;
		assertEquals(expected, treeSort.insert(student).getData().getRollNo());
	}

	@Test
	public void insertTest_False() {
		TreeSort treeSort = new TreeSort();
		Student student = new Student(5, "Rahul");
		int expected = 4;
		assertNotEquals(expected, treeSort.insert(student).getData().getRollNo());
	}
}
