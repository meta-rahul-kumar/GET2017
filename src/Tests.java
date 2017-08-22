import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class Tests {
	ArrayList<Integer> list;
	
	@Before
	public void setUpObject() {
		list = new ArrayList<Integer>(10);
	}
	
	@Test
	public void addTest_True() {
		list.add(5);
		Object [] expected = new Object[10];
		expected[0] = 5; 
		Object [] result = list.show();
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void addTest_False() {
		list.add(5);
		Object [] expected = new Object[10];
		expected[0] = 3; 
		Object [] result = list.show();
		assertNotEquals(expected, result);
	}
	
	@Test
	public void addTest_With_Location_True() {
		list.add(0,5);
		Object [] expected = new Object[10];
		expected[0] = 5; 
		Object [] result = list.show();
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void addTest_With_Location_False() {
		list.add(0,5);
		Object [] expected = new Object[10];
		expected[1] = 5; 
		Object [] result = list.show();
		assertNotEquals(expected, result);
	}
	
	@Test
	public void clearTest_True() {
		list.add(0,5);
		list.add(1,6);
		list.clear();
		Object [] expected = new Object[10];
		Object [] result = list.show();
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void clearTest_False() {
		list.add(0,5);
		list.add(1,6);
		list.clear();
		Object [] expected = new Object[10];
		expected[0] = 7;
		Object [] result = list.show();
		assertNotEquals(expected, result);
	}
	
	@Test
	public void getTest_True() {
		list.add(0,5);
		list.add(1,6);
		Object expected = 5;
		Object result = list.get(0);
		assertEquals(expected, result);
	}
	
	@Test
	public void getTest_False() {
		list.add(0,5);
		list.add(1,6);
		Object expected = 6;
		Object result = list.get(0);
		assertNotEquals(expected, result);
	}
	
//	@Test
//	public void indexOfTest_True() {
//		list.add(0,9);
//		int expected = 0;
//		int result = list.indexOf(9);
//		assertEquals(expected, result);
//	}
	
	@Test
	public void removeTest_WithIndex_True() {
		list.add(0,5);
		list.add(1,6);
		int expected = 5;
		int result = list.remove(0);
		assertEquals(expected, result);
	}
	
	@Test
	public void removeTest_WithIndex_False() {
		list.add(0,5);
		list.add(1,6);
		int expected = 7;
		int result = list.remove(0);
		assertNotEquals(expected, result);
	}
	
	@Test
	public void removeTest_Element_True() {
		list.add(0,5);
		list.add(1,6);
		boolean expected = true;
		boolean result = list.remove((Object)5);
		assertEquals(expected, result);
	}
	
	@Test
	public void removeTest_Element_False() {
		list.add(0,5);
		list.add(1,6);
		boolean expected = false;
		boolean result = list.remove((Object)5);
		assertNotEquals(expected, result);
	}
	
//	@Test
//	public void reverseListTest_True() {
//		list.add(0,5);
//		list.add(1,7);
//		list.add(2,8);
//		list.reverseList();
//		Object[] expected = {8,7,5};
//		Object[] result = new Object[3];
//		result[0] = list.get(2);
//		result[1] = list.get(1);
//		result[2] = list.get(0);
//		assertArrayEquals(expected, result);
//	}
	
//	@Test
//	public void sortTest_True() {
//		list.list = new Object[10];
//		list.size = 0;
//		list.add(0,6);
//		list.add(1,5);
//		list.add(2,8);
//		
//		list.sort();
//		
//		Object[] expected = {5,6,8};
//		Object[] result = new Object[3];
//		result[0] = list.get(0);
//		result[1] = list.get(1);
//		result[2] = list.get(2);
//		
//		assertArrayEquals(expected, result);
//		
//	}
}
