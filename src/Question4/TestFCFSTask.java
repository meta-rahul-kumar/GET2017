/**
 * Wrong JUnit Testing No Working
 */
package Question4;

import org.junit.*;
import static org.junit.Assert.*;

public class TestFCFSTask {
	@Test
	public void testFcfsPass() {
		FCFSTask obj = new FCFSTask();
		int[] arrival_time = {1, 5, 9, 25};
		int[] job_size = {12, 7, 2, 5};
		int[][] output =new int[arrival_time.length][5];
		output = obj.FCFS(arrival_time, job_size);
		int[][] expected = {{1, 1, 0, 1, 12}, {2, 5, 8, 13, 19},
				{3, 9, 11, 20, 21}, {4, 25, 0, 25, 29}};
		assertEquals(true, isArrayEqual(expected, output));
		
	}
	
	@Test
	public void testFcfsFail() {
		FCFSTask obj = new FCFSTask();
		int[] arrival_time = {1, 5, 9, 25};
		int[] job_size = {12, 7, 2, 5};
		int[][] output =new int[arrival_time.length][5];
		output = obj.FCFS(arrival_time, job_size);
		int[][] expected = {{1, 1, 0, 1, 12}, {2, 5, 8, 13, 19},
				{19, 9, 11, 20, 21}, {4, 25, 0, 25, 29}};
		assertEquals(true, isArrayEqual(expected, output));
		
	}
	
	boolean isArrayEqual(int[][] expected,int[][] output) {
		int flag = 0;
		for(int i = 0; i < expected.length; i++) {
			for(int j = 0;j < expected[i].length; j++) {
				if(expected[i][j] != output[i][j]) {
					flag = 1;
					break;
				}
			}
		}
		
		if(flag == 0) {
			return true;
		}
		
		return false;
		
	}
	
	
}