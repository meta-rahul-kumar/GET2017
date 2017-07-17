/*
 * Class checks the pyramid function of Pyramid class for different cases
 */

package Question2;

import org.junit.Test;
import static org.junit.Assert.*;

public class PyramidTest {
	Pyramid PyramidTest = new Pyramid();
	String output = "";
   
	@Test
	public void testPyramidTrue() {	
		int n = 3;
		output = PyramidTest.pyramid(n);   
		String expected = "123\n"
				+ " 12\n"
				+ "  1\n";
		assertEquals(expected, output);     // True Case
		n = 2;
		output = PyramidTest.pyramid(n);   
		expected = "12\n"
				+ "1\n";
		assertNotEquals(expected, output);  // False case
	 }
}
