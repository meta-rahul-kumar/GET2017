package Question2;

/**
 * Class perform basic operation like multiply , transpose on matrices
 * 
 * @version 1.0 19 July 2017
 * @author User17
 *
 */
public class Matrix {
	int[][] matrix;
	
	/**
	 * Class Matrix Constractor
	 * @param row
	 * @param col
	 */
	Matrix(int row, int col){
		matrix = new int[row][col];
	}
	
	/**
	 * Method - addElement
	 * 
	 * add an Element in Matrix
	 * @param row
	 * @param col
	 * @param value
	 * @return
	 */
	int addElement(int row, int col, int value) {
		matrix[row][col] = value;
		
		return matrix[row][col];
	}
	
	/**
	 * Show matrix
	 * 
	 * @param matrix
	 * @return
	 */
	int[][] show(int[][] matrix){
		return matrix;
	}
	
	/**
	 * Transpose the Matrix
	 * 
	 * @param matrix
	 * @param rowsInMatrix
	 * @param colsInMatrix
	 * @return
	 */
	int[][] transposeMatrix(int matrix[][], int rowsInMatrix, int colsInMatrix){
		int[][] tempMatrix = new int[colsInMatrix][rowsInMatrix];
//		
//		for (int row = 0; row < rowsInMatrix ; row++) {
//			for (int col = 0; col < rowsInMatrix; col++) {
//				int temp = matrix[row][col];
//				matrix[row][col] = matrix[col][row];
//				matrix[col][row] = temp;
//			}
//		}
		
		for (int row = 0; row < colsInMatrix; row++) {
			for (int col = 0; col < rowsInMatrix; col++) {
				tempMatrix[row][col] = matrix[col][row];
			}
		}
		
		return tempMatrix;
	}
	
	/**
	 * Multiply two matrix
	 * 
	 * @param firstMatrix
	 * @param secondMatrix
	 * @return
	 */
	int[][] multiplyMatrix(int[][] firstMatrix, int[][] secondMatrix) {
		int[][] resultMatrix = new int[firstMatrix.length][secondMatrix[0].length];
		
		try {
			
			if(firstMatrix[0].length != secondMatrix.length) {
				throw new Exception("first Matrix rows no must bes equal to second Matrix columns ");
			}
			
			for (int row = 0; row < firstMatrix.length; row++) {
				for (int col = 0; col < secondMatrix[0].length ; col++) {
					int sum = 0;
					
					for (int k = 0; k < secondMatrix.length ; k++) {
						sum += firstMatrix[row][k]*secondMatrix[k][col];
					}
					
					resultMatrix[row][col] = sum;
				}
			}
			
		}catch (Exception notEqualError) {
			System.out.println(notEqualError.getMessage());
		}
			
		return resultMatrix;
	}
}
