package com.metacube.util;

import java.util.Scanner;

/**
 * Utility Class
 * 
 * @author Rahul Kumar
 *
 */
public class Util {
	public static Scanner sc = new Scanner(System.in);

	/**
	 * Takes a integer input
	 * 
	 * @return
	 */
	public static int getNumberOfStudents() {
		int number = 0;
		boolean flag = true;
		System.out.println("How many Students do you want to enter ?");

		while (flag) {

			while (!sc.hasNextInt()) {
				// runs while next Input is not Integer
				System.out.println("Please Enter a Valid Number");
				sc.nextLine();
			}
			number = Util.sc.nextInt();

			if (number <= 0) {
				System.out.println("Please Enter a Valid Number");
				sc.nextLine();
			} else {
				flag = false;
			}
		}
		return number;
	}

	/**
	 * Takes a Student Roll Number
	 * 
	 * @return
	 */
	public static int getRollNo() {
		int number = 0;
		boolean flag = true;
		System.out.println("Enter Student Roll No");

		while (flag) {

			while (!sc.hasNextInt()) {
				// runs while next Input is not Integer
				System.out.println("Please Enter a Valid Roll No");
				sc.nextLine();
			}
			number = Util.sc.nextInt();

			if (number <= 0) {
				System.out.println("Please Enter a Valid Roll No.");
				sc.nextLine();
			} else {
				flag = false;
			}
		}
		return number;
	}

	/**
	 * Takes the Name of Student
	 * 
	 * @return
	 */
	public static String getName() {
		String name;
		System.out.println("Enter Student Name");
		sc.nextLine();
		name = Util.sc.nextLine();
		return name;
	}
}
