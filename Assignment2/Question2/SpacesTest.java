/*
 * Junit Test Class for spaces method of PyramidMirror Class
 */

package Question2;

import org.junit.Test;
import static org.junit.Assert.*;

public class SpacesTest {

	Pyramid PyramidTest = new Pyramid();
	String output;
   
   @Test
   public void testSpacesTrue() {	
	   int row = 2;
	   int n = 5;
	   output = PyramidTest.spaces(row, n);   
	   String expected = "   ";
	   assertEquals(expected, output);    // True Case
	   row = 2;
	   n = 5;
	   output = PyramidTest.spaces(row, n);   
	   expected = "    ";
	   assertNotEquals(expected, output);     // False Case
   }
}
