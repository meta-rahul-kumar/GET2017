package com.metacube.util;
import java.util.Scanner;
import com.metacube.resources.PriorityQueue;

public class Util {
	public static Scanner sc = new Scanner(System.in);
	
	public static int getJobId(PriorityQueue queue , int number) {
		return queue.size() + 1;
	}

	public static int getJobPriority(int number) {
	int priority;
		
		while (true)  {
			try {
				System.out.println("Enter Designation "+ number);
				System.out.println("1. Department Chair");
				System.out.println("2. Professors");
				System.out.println("3. Graduate Students");
				System.out.println("4. Undergraduates");
				priority = Util.sc.nextInt();
				
				if (priority <= 0  || priority > 4) {
					throw new Exception();
				}
				
				break;
				
			} catch (Exception e) {
				System.out.println("Please enter a valid number");
				sc.nextLine();

			}
		}
		
		switch(priority) {
		case 1: priority = 4; break;
		case 2: priority = 3; break;
		case 3: priority = 2; break;
		case 4: priority = 1;
		}
		return priority;
	}
	
	public static int getTotalJobs() {
	int totalJobs;
		
		while (true)  {
			try {
				System.out.println("Enter Total Number of Jobs");
				totalJobs = Util.sc.nextInt();
				
				if (totalJobs <= 0 ) {
					throw new Exception();
				}
				
				break;
				
			} catch (Exception e) {
				System.out.println("Please enter a valid number");
				sc.nextLine();

			}
		}
		
		return totalJobs;
	}
}
