package Question2;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Class checks the addElement method of class Matrix
 * 
 * @version 1.0 19 July 2017
 * @author User17
 *
 */

public class AddElementTest {
	
	@Test
	public void addElementTest() {
		int xDimension = 3;
		int yDimension = 3;
		Matrix maker = new Matrix(xDimension, yDimension);
		int value = 5;
		int givenValue = maker.addElement(0, 0, value);
		int expectedOutput = 5;
		assertEquals(expectedOutput, givenValue); // True Case
		
		value = 6;
		maker = new Matrix(xDimension, yDimension);
		givenValue = maker.addElement(0, 1, value);
		expectedOutput = 5;
		assertNotEquals(expectedOutput, givenValue); // False Case
		
	}
}
