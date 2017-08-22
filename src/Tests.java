import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class Tests {
	
	@Before
	public void setUpObject() {
		ArrayList.getInstance();
	}
	
	@Test
	public void addTest_True() {
		ArrayList.getInstance().add(5);
		Object [] expected = new Object[10];
		expected[0] = 5; 
		Object [] result = ArrayList.getInstance().show();
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void addTest_False() {
		ArrayList.getInstance().add(5);
		Object [] expected = new Object[10];
		expected[0] = 3; 
		Object [] result = ArrayList.getInstance().show();
		assertNotEquals(expected, result);
	}
	
	@Test
	public void addTest_With_Location_True() {
		ArrayList.getInstance().add(0,5);
		Object [] expected = new Object[10];
		expected[0] = 5; 
		Object [] result = ArrayList.getInstance().show();
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void addTest_With_Location_False() {
		ArrayList.getInstance().add(0,5);
		Object [] expected = new Object[10];
		expected[1] = 5; 
		Object [] result = ArrayList.getInstance().show();
		assertNotEquals(expected, result);
	}
	
	@Test
	public void clearTest_True() {
		ArrayList.getInstance().add(0,5);
		ArrayList.getInstance().add(1,6);
		ArrayList.getInstance().clear();
		Object [] expected = new Object[10];
		Object [] result = ArrayList.getInstance().show();
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void clearTest_False() {
		ArrayList.getInstance().add(0,5);
		ArrayList.getInstance().add(1,6);
		ArrayList.getInstance().clear();
		Object [] expected = new Object[10];
		expected[0] = 7;
		Object [] result = ArrayList.getInstance().show();
		assertNotEquals(expected, result);
	}
	
	@Test
	public void getTest_True() {
		ArrayList.getInstance().add(0,5);
		ArrayList.getInstance().add(1,6);
		Object expected = 5;
		Object result = ArrayList.getInstance().get(0);
		assertEquals(expected, result);
	}
	
	@Test
	public void getTest_False() {
		ArrayList.getInstance().add(0,5);
		ArrayList.getInstance().add(1,6);
		Object expected = 6;
		Object result = ArrayList.getInstance().get(0);
		assertNotEquals(expected, result);
	}
	
	@Test
	public void removeTest_WithIndex_True() {
		ArrayList.getInstance().add(0,5);
		ArrayList.getInstance().add(1,6);
		Object expected = 5;
		Object result = ArrayList.getInstance().remove(0);
		assertEquals(expected, result);
	}
	
	@Test
	public void removeTest_WithIndex_False() {
		ArrayList.getInstance().add(0,5);
		ArrayList.getInstance().add(1,6);
		Object expected = 7;
		Object result = ArrayList.getInstance().remove(0);
		assertNotEquals(expected, result);
	}
	
	@Test
	public void removeTest_Element_True() {
		ArrayList.getInstance().add(0,5);
		ArrayList.getInstance().add(1,6);
		boolean expected = true;
		boolean result = ArrayList.getInstance().remove((Object)5);
		assertEquals(expected, result);
	}
	
	@Test
	public void removeTest_Element_False() {
		ArrayList.getInstance().add(0,5);
		ArrayList.getInstance().add(1,6);
		boolean expected = false;
		boolean result = ArrayList.getInstance().remove((Object)5);
		assertNotEquals(expected, result);
	}
}
