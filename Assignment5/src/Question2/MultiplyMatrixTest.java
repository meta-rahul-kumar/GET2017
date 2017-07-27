package Question2;

import org.junit.*;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Class checks the multiplyMatrix method of class Matrix
 * 
 * @version 1.0 19 July 2017
 * @author User17
 *
 */

public class MultiplyMatrixTest {

	@Test
	public void matrixMultiplicationTest() {
		int xDimension = 2;
		int yDimension = 2;
		Matrix operations = new Matrix(xDimension, yDimension);
		int[][] matrix = {{1, 2},
						  {3, 4}
		};
		int[][] secondMatrix = {{4, 3},
				  				{2, 1}
		};
		int[][] expectedOutput = {{8, 5},
								  {20, 13}
		};
		assertArrayEquals(expectedOutput, operations.multiplyMatrix(matrix,
					secondMatrix)); // True Case
		
		xDimension = 1;
		yDimension = 1;
		operations = new Matrix(xDimension, yDimension);
		matrix = new int[][]{{1}
		};
		secondMatrix = new int[][]{{4}
		};
		expectedOutput = new int[][]{{6}
		};
		assertNotEquals(expectedOutput, operations.multiplyMatrix(matrix,
					secondMatrix)); // False Case
		


		matrix = new int[][]{{1},{2},{3}
		};
		secondMatrix = new int[][]{{4,3,1}
		};
		expectedOutput = new int[][]{{4, 3, 1},{8, 6, 2},{12, 9, 3}
		};
		assertArrayEquals(expectedOutput, operations.multiplyMatrix(matrix,
					secondMatrix)); // False Case
	}
}
