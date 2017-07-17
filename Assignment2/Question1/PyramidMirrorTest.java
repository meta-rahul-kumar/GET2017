package Question1;
/*
 * Class checks the pyramid function of PyramidMirror class for different cases
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class PyramidMirrorTest {
	PyramidMirror PyramidMirrorTest = new PyramidMirror();
	String output[];
   
	@Test
	public void testPyramid() {	
		int n = 3;
		output = PyramidMirrorTest.pyramid(n);   
		String expected = "  1\n"
				+ " 121\n"
				+ "12321\n"
				+ " 121\n"
				+ "  1\n";
		String[] test  = expected.split("\n");
		assertArrayEquals(test, output);    // Positive Case
		n = 2;
		output = PyramidMirrorTest.pyramid(n);   
		expected = " 1\n"
				+ "121\n"
				+ "1\n";
		test  = expected.split("\n");
		assertNotEquals(expected, output);  // Negative Case
	 }
}
