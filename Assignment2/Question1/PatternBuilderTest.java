package Question1;

/*
 * Class checks the patternBuilder method of PyramidMirror class for different cases
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class PatternBuilderTest {

	PyramidMirror PyramidMirrorTest = new PyramidMirror();
	String output;
   
	@Test
	public void testPatternBuilder() {	
		int row = 2;
		int n = 5;
		output = PyramidMirrorTest.patternBuilder(n, row);   
		String expected ="   121\n";
		assertEquals(expected, output);	//Positive test case
		output = PyramidMirrorTest.patternBuilder(n, row);
		expected = "12321\n";
		assertNotEquals(expected, output);  // Negative test case
	 }
}
