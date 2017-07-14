package Question4;
/**
 * Class creates a 2D array of Job Scheduling.
 * 
 * @version 1.0 13 July 2017
 * @author Rahul Kumar
 */

public class FCFSTask {
	/**
	 * Method - FCFS
	 * Method takes two parameter an integer array arrival_time and
	 * second integer array job_size
	 * 
	 * return a 2D array of of scheduling constraints
	 */
	int [][] FCFS( int[] arrival_time, int[] job_size ) {
		int[][] resultArray = new int[arrival_time.length][5]; 
		for (int i = 0; i < arrival_time.length; i++) {
			resultArray[i][0] = i + 1;
			resultArray[i][1] = arrival_time[i];
			if (i == 0) {
				resultArray[i][2] = 0;
			}else if (i != 0 && resultArray[i - 1][4] > arrival_time[i] ) {
				resultArray[i][2] = resultArray[i - 1][4] - arrival_time[i] + 1;
			}else {
				resultArray[i][2] = 0;
			}
			if (i == 0) {
				resultArray[i][3] = arrival_time[i];
			}else if (i != 0 && resultArray[i - 1][4] > arrival_time[i] ){
				resultArray[i][3]=resultArray[i - 1][4] + 1;
			}else {
				resultArray[i][3] = arrival_time[i];
			}
			
			if (i == 0) {
				resultArray[i][4] = resultArray[i][3] + job_size[i] - 1;
			}else {
				resultArray[i][4] = resultArray[i][3] + job_size[i] - 1;
			}
		}
		
		return resultArray;
	}
}
