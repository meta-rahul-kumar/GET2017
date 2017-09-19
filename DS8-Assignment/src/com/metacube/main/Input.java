package com.metacube.main;

import java.util.Scanner;

import com.metacube.util.Util;

/**
 * Utility Class
 * 
 * @author Rahul Kumar
 *
 */
public class Input {

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

			while (!Util.sc.hasNextInt()) {
				// runs while next Input is not Integer
				System.out.println("Please Enter a Valid Number");
				Util.sc.nextLine();
			}
			number = Util.sc.nextInt();

			if (number <= 0) {
				System.out.println("Please Enter a Valid Number");
				Util.sc.nextLine();
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
	public static int getArrayElement(int index) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int number = 0;
		boolean flag = true;
		System.out.println("Enter Array Element " + index);

		while (flag) {

			while (!sc.hasNextInt()) {
				// runs while next Input is not Integer
				System.out.println("Please Enter a Valid Number");
				sc.nextLine();
			}
			number = sc.nextInt();

			if (number <= 0) {
				System.out.println("Please Enter a Positive Number.");
				sc.nextLine();
			} else {
				flag = false;
			}
		}
		return number;
	}
}
