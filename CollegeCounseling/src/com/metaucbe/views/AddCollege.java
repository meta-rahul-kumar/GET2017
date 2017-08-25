package com.metaucbe.views;
import java.util.Scanner;

import com.metacube.menu.Action;
/**
 * Adds new College 
 * @author Rahul Kumar
 *
 */
public class AddCollege implements Action {

	/**
	 * performAction method of Action Interface
	 */
	@SuppressWarnings("resource")
	@Override
	public void performAction() {
		Input input = new Input();
		Scanner sc = new Scanner(System.in);
		String collegeName;
		int collegeSeats;
		
		System.out.println("Enter College Name");
		collegeName = sc.nextLine();
		
		while (true) {
			try {
				System.out.println("Enter College Seats");
				collegeSeats = sc.nextInt();
				
				if (collegeSeats <= 0) {
					throw new Exception();
				}
				break;
				
			} catch(Exception e) {
				System.out.println("Please Enter a Valid no. of seats.");
				sc.nextLine();
			}
		}
		
		input.addCollege(collegeName,collegeSeats);
	}

}
