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
	public static int getNumber() {
		int number = 0;
		boolean flag = true;
		System.out.println("How many Elements do you want to enter ?");

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
	 * 
	 * @param inputArray
	 * @return
	 */
	public static int digitsInMaximumNumber(int[] inputArray) {
		int max = inputArray[0];
		int digits = 0;
		for (int i = 1; i < inputArray.length; i++) {
			// finds the maximum number
			if (max < inputArray[i]) {
				max = inputArray[i];
			}
		}

		/**
		 * counts the digits of maximum number
		 */
		while (max != 0) {
			digits++;
			max /= 10;
		}
		return digits;
	}

	/**
	 * takes the array Elements from user
	 * 
	 * @param inputArray
	 * @return
	 */
	public static int[] getArrayInputs(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			System.out.println("Enter Element " + i);
			boolean flag = true;
			while (flag) {
				while (!sc.hasNextInt()) {
					System.out.println("Please Enter a Valid Number");
					sc.nextLine();
				}

				inputArray[i] = Util.sc.nextInt();

				if (inputArray[i] < 0) {
					System.out.println("Please Enter a Positive Number.");
				} else {
					flag = false;
				}
			}
		}

		return inputArray;
	}
}
