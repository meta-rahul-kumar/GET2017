package com.metacube.controller;
import com.metacube.facade.CounselingFacade;

/**
 * Controller class for counseling
 * @author Rahul Kumar
 *
 */
public class CounselingController {

	/**
	 * Stores the Student ranks in Queue
	 */
	public void addStudentRanksInQueue() {
		CounselingFacade counselingFacade = new CounselingFacade();
		counselingFacade.addStudentsRanksInQueue();
	}

	/**
	 * Sort the Rank Queue
	 */
	public void sortRanksInAscendingOrder() {
		CounselingFacade counselingFacade = new CounselingFacade();
		counselingFacade.sortRanksInAscendingOrder();
	}

	/**
	 * allot the colleges to the students
	 */
	public void allocateCollegeToStudents() {
		CounselingFacade counselingFacade = new CounselingFacade();
		counselingFacade.allocateCollegeToStudents();
	}

	/**
	 * shows the alloated colleges to students
	 */
	public void showAllocatedSeats() {
		CounselingFacade counselingFacade = new CounselingFacade();
		counselingFacade.showAllocatedSeats();
	}
}
