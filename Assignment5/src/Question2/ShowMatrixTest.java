package Question2;

import org.junit.*;
import static org.junit.Assert.assertNotEquals;

import static org.junit.Assert.assertArrayEquals;

/**
 * Class checks the showMatric Method of class Matrix
 * 
 * @version 1.0 19 July 2017
 * @author User17
 *
 */

public class ShowMatrixTest {
	
	@Test
	public void showMatrixTest() {
		int xDimension = 3;
		int yDimension = 3;
		Matrix operations = new Matrix(xDimension, yDimension);
		int[][] matrix = {{1, 2, 3},
				  		  {4, 5, 6},
				          {7, 8, 9}
		};
		int[][] expected = {{1, 2, 3},
						    {4, 5, 6},
						    {7, 8, 9}
		};
		assertArrayEquals(expected, operations.show(matrix)); // True case
		
		xDimension = 3;
		yDimension = 2;
		operations = new Matrix(xDimension, yDimension);
		matrix = new int[][]{{1, 2},
				  		     {4, 5}
		};
		expected = new int[][]{{1, 2},
							   {5, 5}
		};
		assertNotEquals(expected, operations.show(matrix)); // True case
		
	}
}
