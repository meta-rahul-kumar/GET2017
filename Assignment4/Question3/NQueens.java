package Question3;

/**
 * class takes board as 2D array , starting row, no of columns and dimenstion
 * of board and returns the boolean true or false if queen can be arrange or
 * if not
 * 
 * @version 1.0 18 July 2017
 * @author Rahul Kumar
 */
public class NQueens {
	
	boolean boxSafe(int[][] board, int row, int col, int dimesionMatrix) {
		 
        /* Check this row on left side */
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;
 
        /* Check upper diagonal on left side */
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;
 
        /* Check lower diagonal on left side */
        for (int i=row, j=col; j>=0 && i<dimesionMatrix; i++, j--)
            if (board[i][j] == 1)
                return false;
 
        return true;
	}
	
	boolean  nQueen(int[][] board, int startRow, int dimensionOfMatrix) {
		if (startRow >= dimensionOfMatrix) {
			return true;
		}
		for (int boardLoop = 0; boardLoop < dimensionOfMatrix; boardLoop++ ) {
			if(boxSafe(board, boardLoop , startRow, dimensionOfMatrix) == true) {
				 board[boardLoop][startRow] = 1;
				 
	                /* recur to place rest of the queens */
	                if (nQueen(board, startRow + 1, dimensionOfMatrix) == true)
	                    return true;
	 
	                /* If placing queen in board[i][col]
	                   doesn't lead to a solution then
	                   remove queen from board[i][col] */
	                board[boardLoop][startRow] = 0; // BACKTRACK
			}
		}
		return false;
	}
	
	
	public static void main(String args[]) {
		NQueens obj = new NQueens();
		int dimenstion = 4;
		int [][] board = new int [][] {
            { 0,  0,  0,  0},
             { 0,  0,  0,  0},
             { 0,  0,  0,  0},
             { 0,  0,  0,  0} };
        obj.nQueen(board , 0, dimenstion);
        for(int i=0;i<dimenstion;i++) {
        	for (int j = 0; j < dimenstion; j++) {
        		System.out.print(board[i][j]);
        	}
        	System.out.println("");
        }
       
	}
}
