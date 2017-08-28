package com.metaucbe.views;
import com.metacube.controller.CollegeController;
import com.metacube.controller.CounselingController;
import com.metacube.controller.StudentController;

/**
 * perform all the output taks
 * @author Rahul Kumar
 *
 */
public class Output {

	/**
	 * shows all colleges
	 */
	public void showColleges() {
		System.out.println("All Colleges : ");
		System.out.println("Code\tCollege Name\tSeat Available");
		System.out.println("----\t------------\t------------");
		CollegeController collegeController = new CollegeController();
		collegeController.getAllColleges();
	}

	/**
	 * shows all students
	 */
	public void showStudents() {
		System.out.println("All Students : ");
		System.out.println("ID\tStudent Name\t\tRank");
		System.out.println("--\t------------\t\t----");
		StudentController studentController = new StudentController();
		studentController.getAllStudents();
	}

	/**
	 * shows the allocated seats
	 */
	public void showAllocatedSeats() {
		System.out.println("All Allocated Seats : ");
		System.out.println("ID\tStudent Name\t\tCollege Name");
		System.out.println("--\t------------\t\t------------");
		CounselingController counselingController = new CounselingController();
		counselingController.showAllocatedSeats();
	}

	public int getTotalNoOfStudents() {
		StudentController studentController = new StudentController();
		return studentController.getTotalNoOfStudents();
	}
}
