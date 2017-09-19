import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class Tests {
	ArrayList<Integer> list;
	@Before
	public void setUpObject() {
		list = new ArrayList<>();
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
	
	@Test
	public void removeTest_WithIndex_True() {
		list.add(0,5);
		list.add(1,6);
		Object expected = 5;
		Object result = list.remove(0);
		assertEquals(expected, result);
	}
	
	@Test
	public void removeTest_WithIndex_False() {
		list.add(0,5);
		list.add(1,6);
		Object expected = 7;
		Object result = list.remove(0);
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
}
