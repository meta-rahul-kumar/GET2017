package com.metacube.util;
import java.util.Scanner;

/**
 * Utility Class
 * @author Rahul Kumar
 *
 */
public class Util {
	public static Scanner sc = new Scanner(System.in);

	/**
	 * Method takes input from user
	 * @return Integer
	 */
	public static int getNewInput() {
		int input = 0;
		
		while (true) {
			try {
				System.out.println("Enter number");
				input = sc.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Please enter a valid Number");
				sc.nextLine();
			}
		}
		
		return input;
	}
	
	
}
