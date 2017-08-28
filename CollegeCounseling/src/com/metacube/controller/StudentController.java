package com.metacube.controller;
import com.metacube.facade.StudentFacade;

/**
 * Controller class for Student
 * @author Rahul Kumar
 *
 */
public class StudentController {

	/**
	 * shows the all students
	 */
	public void getAllStudents() {
		StudentFacade collegeFacade = new StudentFacade();
		collegeFacade.getAllStudents();
	}

	/**
	 * adds a student
	 * @param id
	 * @param name
	 * @param rank
	 */
	public void addStudent(int id, String name, int rank) {
		StudentFacade studentFacade = new StudentFacade();
		studentFacade.addStudent(id,name,rank);
	}

	/**
	 * get the highest User id 
	 * @return
	 */
	public int getLastStudentID() {
		StudentFacade studentFacade = new StudentFacade();
		return studentFacade.getLastStudentID();
	}

	public int getTotalNoOfStudents() {
		StudentFacade studentFacade = new StudentFacade();
		return studentFacade.getTotalNoOfStudents();
	}
}
