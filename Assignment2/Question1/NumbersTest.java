package Question1;
/*
 * Class checks the numbers method of PyramidMirror class for different cases
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class NumbersTest {

	PyramidMirror PyramidMirrorTest = new PyramidMirror();
	String output;
   
	@Test
	public void testNumbers() {	
		int row = 2;
		int n = 5;
		output = PyramidMirrorTest.numbers(row, n);   
		String expected = "121";
		assertEquals(expected, output);	//Positive test case
		output = PyramidMirrorTest.numbers(row, n);
		expected = "12321";
		assertNotEquals(expected, output);  // Negative test case
	 }
}