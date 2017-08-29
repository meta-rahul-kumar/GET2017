package com.metacube.utils;
import java.util.Scanner;
import com.metacube.views.Output;

/**
 * Utility Class
 * @author Rahul Kumar
 *
 */
public class Util {
	public static Scanner sc = new Scanner(System.in);
	
	/**
	 * Checks a number is prime or not
	 * @param number
	 * @return
	 */
	public static boolean isPrime(int number) {
		boolean prime = true;
		
		if (number == 1) {
			prime = false;
		} else {
			for (int i = 2 ; i < number ; i++) {
				if (number % i == 0) {
					prime = false;
					break;
				}
			}
		}
		
		return prime;
	}
	
	/**
	 * takes the number of rooms input from user
	 * @return
	 */
	public static int getRooms() {
		int rooms;
		
		while (true)  {
			try {
				System.out.println("Enter How Many Rooms are available in Hotel [Must be prime number");
				rooms = Util.sc.nextInt();
				
				if (!Util.isPrime(rooms)) {
					throw new Exception("Total number of rooms must be a prime number.");
				}
				
				if (rooms <= 0 ) {
					throw new Exception("Total number of rooms must be greater than 0");
				}
				
				if (rooms < Util.totalNumberOfGuests()) {
					throw new Exception("Room must be greater or equal than total number of users");
				}
				
				break;
				
			} catch (Exception e) {
				if (e.getMessage() == null) {
					System.out.println("Please enter a valid number");
					Util.sc.nextLine();
				} else {
					System.out.println(e.getMessage());
				}
			}
		}
	
		return rooms;
	}
	
	/**
	 * returns total Number of Guests
	 * @return
	 */
	private static int totalNumberOfGuests() {
		Output output = new Output();
		return output.getTotalNumberOfGuests();
	}
	
	/**
	 * method takes user id input from user
	 * @return
	 */
	public static int getID() {
		int id;
		
		while (true)  {
			try {
				System.out.println("Enter Guest ID");
				id = Util.sc.nextInt();
				
				if (id <= 0 ) {
					throw new Exception("Please enter a valid number");
				}
				
				if (Util.isIdAlreadyExists(id)) {
					throw new Exception("ID already Exists. Please Enter a Different ID");
				}
				
				break;
				
			} catch (Exception e) {
				
				if (e.getMessage() == null) {
					System.out.println("Please enter a valid number");
				} else {
					System.out.println(e.getMessage());
				}
				sc.nextLine();
			}
		}
		
		return id;
	}
	
	/**
	 * method checks that user already exists with same id.
	 * @param id
	 * @return
	 */
	private static boolean isIdAlreadyExists(int id) {
		Output output = new Output();
		return output.isIdAlreadyExists(id);
	}
	
	/**
	 * method takes Guest name as input
	 * @return
	 */
	public static String getName() {
		String name;
		System.out.println("Enter Guest Name");
		sc.nextLine();
		name = sc.nextLine();
		return name;
	}
	
	/**
	 * method  takes Guest age Input from user
	 * @return
	 */
	public static int getAge() {
		int age;
		
		while (true)  {
			try {
				System.out.println("Enter Guest Age");
				age = Util.sc.nextInt();
				
				if (age <= 0 ) {
					throw new Exception();
				}
				
				break;
				
			} catch (Exception e) {
				System.out.println("Please enter a valid number");
				sc.nextLine();

			}
		}
		
		return age;
	}
}
