package Question2;

/*
 * Class checks the patternBuilder method of Pyramid class for different cases
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class PatternBuilderTest {

	Pyramid PyramidMirrorTest = new Pyramid();
	String output;
   
	@Test
	public void testPatternBuilder() {	
		int row = 2;
		int n = 5;
		output = PyramidMirrorTest.patternBuilder(n, row);   
		String expected = "   12\n";
		assertEquals(expected, output);	//Positive test case
		output = PyramidMirrorTest.numbers(n, row);
		expected = "12321\n";
		assertNotEquals(expected, output);  // Negative test case
	 }
}