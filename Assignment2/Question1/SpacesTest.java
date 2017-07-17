package Question1;
/*
 * Junit Test Class for spaces method of PyramidMirror Class
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class SpacesTest {

	PyramidMirror PyramidMirrorTest = new PyramidMirror();
	String output;
   
   @Test
   public void testSpaces() {	
	   int row = 2;
	   int n = 5;
	   output = PyramidMirrorTest.spaces(row, n);   
	   String expected = "   ";
	   assertEquals(expected, output);  // True Case
	   row = 2;
	   n = 5;
	   output = PyramidMirrorTest.spaces(row, n);  // False Case
	   expected = "    ";
	   assertNotEquals(expected, output);   
   }
}