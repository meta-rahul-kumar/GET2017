package com.metaucbe.views;
import com.metacube.controller.CollegeController;
import com.metacube.controller.CounselingController;
import com.metacube.controller.StudentController;

/**
 * Performs the input operations
 * @author Rahul Kumar
 *
 */
public class Input {

	/**
	 * adds a college
	 * @param name
	 * @param seats
	 */
	public void addCollege(String name, int seats) {
		CollegeController collegeController = new CollegeController();
		collegeController.addCollege(collegeController.getLastCollegeID() + 1,name,seats);
	}

	/**
	 * adds a student
	 * @param name
	 * @param rank
	 */
	public void addStudent(String name, int rank) {
		StudentController studentController = new StudentController();
		studentController.addStudent(studentController.getLastStudentID() + 1,name,rank);
	}

	/**
	 * allocate the seats to students
	 */
	public void allocateCollegeToStudents() {
		CounselingController counselingController = new CounselingController();
		counselingController.allocateCollegeToStudents();
	}

	/**
	 * adds the student ranks to queue
	 */
	public void addRanksToQueue() {
		CounselingController counselingController = new CounselingController();
		counselingController.addStudentRanksInQueue();
	}

	/**
	 * sort the rank queue
	 */
	public void sortRanksInAscendingOrder() {
		CounselingController counselingController = new CounselingController();
		counselingController.sortRanksInAscendingOrder();	
	}
}
