package com.metacube.util;
import java.util.Scanner;

/**
 * Util Class
 * @author Rahul Kumar
 *
 */
public class Util {
	public static Scanner sc = new Scanner(System.in);
	
	/**
	 * take choice from user
	 * @return
	 */
	public static int getChoice() {
			int input = 0;
			while (true) {
				try {
					System.out.println("Enter Choice");
					input = sc.nextInt();
					
					if (input <= 0 || input > 2) {
						throw new Exception();
					}
					
					break;
				} catch (Exception e) {
					System.out.println("Please enter a valid Choice");
					sc.nextLine();
				}
			}
			return input;
		}

	/**
	 * takes Employee id from user
	 * @return
	 */
	public static int getId() {
		int input = 0;
		while (true) {
			try {
				System.out.println("Enter ID");
				input = sc.nextInt();
				
				if (input <= 0) {
					throw new Exception();
				}
				
				break;
			} catch (Exception e) {
				System.out.println("Please enter a valid ID");
				sc.nextLine();
			}
		}
		return input;
	}

	/**
	 * takes Employee name from user
	 * @return
	 */
	public static String getName() {
		String input = "";
		while (true) {
			try {
				System.out.println("Enter Name");
				sc.nextLine();
				input = sc.nextLine();
				
				break;
			} catch (Exception e) {
				System.out.println("Please enter a valid Name");
				sc.nextLine();
			}
		}
		
		return input;
	}

	/**
	 * takes Employee Address from user
	 * @return
	 */
	public static String getAddress() {
		String input = "";
		while (true) {
			try {
				System.out.println("Enter Address");
				input = sc.nextLine();
				
				break;
			} catch (Exception e) {
				System.out.println("Please enter a valid Address");
				sc.nextLine();
			}
		}
		
		return input;
	}

}
