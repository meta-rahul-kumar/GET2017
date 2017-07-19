package Question3;

import org.junit.Test;
import static org.junit.Assert.*;

public class NQueensTest {

	@Test
	public void NQueensTesting() {
		NQueens obj = new NQueens();
		int dimenstion = 4;
		int [][] board = new int [][] {
            { 0,  0,  0,  0},
             { 0,  0,  0,  0},
             { 0,  0,  0,  0},
             { 0,  0,  0,  0} };
        boolean result = obj.nQueen(board , 0, 4);
        boolean expected = true;
        for(int i=0;i<dimenstion;i++) {
	    	for (int j = 0; j < dimenstion; j++) {
	    		System.out.print(board[i][j]);
	    	}
	    	System.out.println("");
        }
        System.out.println();
        assertEquals(expected, result); // True Case
        
        dimenstion = 8;
        board = new int [][] {
            { 0,  0,  0,  0, 0, 0, 0, 0},
            { 0,  0,  0,  0, 0, 0, 0, 0},
            { 0,  0,  0,  0, 0, 0, 0, 0},
            { 0,  0,  0,  0, 0, 0, 0, 0},
            { 0,  0,  0,  0, 0, 0, 0, 0},
            { 0,  0,  0,  0, 0, 0, 0, 0},
            { 0,  0,  0,  0, 0, 0, 0, 0},
            { 0,  0,  0,  0, 0, 0, 0, 0}};
        result = obj.nQueen(board , 0, dimenstion);
        expected = true;
        for(int i=0;i<dimenstion;i++) {
	    	for (int j = 0; j < dimenstion; j++) {
	    		System.out.print(board[i][j]);
	    	}
	    	System.out.println("");
        }
        System.out.println();
        assertEquals(expected, result); // True Case
        
        dimenstion = 3;
        board = new int [][] {
            { 0,  0,  0},
            { 0,  0,  0},
            { 0,  0,  0}};
        result = obj.nQueen(board , 0, 3);
        expected = true;
        for(int i=0;i<dimenstion;i++) {
	    	for (int j = 0; j < dimenstion; j++) {
	    		System.out.print(board[i][j]);
	    	}
	    	System.out.println("");
        }
        System.out.println();
        assertNotEquals(expected, result); // False Case
        
        dimenstion = 2;
        board = new int [][] {
            { 0,  0},
            { 0,  0}};
        result = obj.nQueen(board , 0, 2);
        expected = true;
        for(int i=0;i<dimenstion;i++) {
	    	for (int j = 0; j < dimenstion; j++) {
	    		System.out.print(board[i][j]);
	    	}
	    	System.out.println("");
        }
        System.out.println();
        assertNotEquals(expected, result); // False Case
	}
}
