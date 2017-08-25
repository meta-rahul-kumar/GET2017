package com.metaucbe.views;
import java.util.Scanner;
import com.metacube.menu.Action;

/**
 * Adds a Student
 * @author Rahul Kumar
 *
 */
public class AddStudent implements Action {

	/**
	 * performAction method of Action Interface
	 */
	@SuppressWarnings("resource")
	@Override
	public void performAction() {
		Input input = new Input();
		Scanner sc = new Scanner(System.in);
		String studentName;
		int studentRank;
		System.out.println("Enter Student Name");
		studentName = sc.nextLine();
		while (true) {
			try {
				System.out.println("Enter Student Rank");
				studentRank = sc.nextInt();
				if (studentRank <= 0) {
					throw new Exception();
				}
				break;
			} catch(Exception e) {
				System.out.println("Please Enter a Valid Rank");
				sc.nextLine();
			}
		}
		input.addStudent(studentName,studentRank);
		
	}

}
