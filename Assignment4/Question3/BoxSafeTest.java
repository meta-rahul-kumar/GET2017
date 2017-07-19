package Question3;

import org.junit.Test;
import static org.junit.Assert.*;

public class BoxSafeTest {

	@Test
	public void BoxSafeTesting() {
		NQueens obj = new NQueens();
		int [][] board = new int [][] {
            { 0,  0,  0,  0},
             { 0,  0,  0,  0},
             { 0,  0,  0,  0},
             { 0,  0,  0,  0} };
        boolean result = obj.boxSafe(board , 1, 0, 4);
        boolean expected = true;
        assertEquals(expected, result); // True Case
        
        board = new int [][] {
            { 0,  0,  0,  0, 0, 0, 0, 0},
            { 0,  0,  0,  0, 0, 0, 0, 0},
            { 0,  0,  0,  0, 0, 0, 0, 0},
            { 0,  0,  0,  0, 0, 0, 0, 0},
            { 0,  0,  0,  0, 0, 0, 0, 0},
            { 0,  0,  0,  0, 0, 0, 0, 0},
            { 0,  0,  0,  0, 0, 0, 0, 0},
            { 0,  0,  0,  0, 0, 0, 0, 0}};
        result = obj.boxSafe(board , 1, 0, 4);
        expected = true;
        assertEquals(expected, result); // True Case
        
        board = new int [][] {
            { 1,  0,  0},
            { 0,  0,  0},
            { 0,  0,  0}};
         result = obj.boxSafe(board , 0, 0, 3);
         expected = true;
        assertNotEquals(expected, result); // False Case
        
        board = new int [][] {
            { 0,  0},
            { 1,  0}};
        result = obj.boxSafe(board , 1, 0, 2);
        expected = true;
        assertNotEquals(expected, result); // False Case
	}
}
