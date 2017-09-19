package com.metacube.facade;
import java.util.HashMap;
import com.metacube.dao.StudentDAO;
import com.metacube.models.Student;

public class StudentFacade {
	
	/**
	 * shows the all students
	 */
	public void getAllStudents() {
		HashMap<Integer,Student> students = StudentDAO.getInstance().getAllStudents();
		for (int key : students.keySet()) {
			System.out.println(students.get(key).getStudentID() + "\t" + students.get(key).getStudentName() + "\t\t" + students.get(key).getStudentRank());
		}
	}

	/**
	 * Adds a Student
	 */
	public void addStudent(int id, String name, int rank) {
		StudentDAO.getInstance().addStudent(id, name, rank);
	}

	/**
	 * Shows the allocated Seats
	 */
	public void showAllocatedSeats() {
		HashMap<Integer,Student> students = StudentDAO.getInstance().getAllStudents();
		CollegeFacade collegeFacade = new CollegeFacade();
		boolean counselingStatus = false;
		for (int key : students.keySet()) {
			if (students.get(key).getStudentAllotedCollegeID() != 0) {
				counselingStatus = true;
				System.out.println(students.get(key).getStudentID() + "\t" + students.get(key).getStudentName() + "\t\t" + collegeFacade.getCollegeNameById(students.get(key).getStudentAllotedCollegeID()));
			}
		}
		
		if (!counselingStatus) {
			System.out.println("Please First Do Counseling.");
		}
		
	}

	/**
	 * returns the highest Student ID
	 * @return
	 */
	public int getLastStudentID() {
		HashMap<Integer,Student> students = StudentDAO.getInstance().getAllStudents();
		int count = 0;
		
		for (@SuppressWarnings("unused") int key : students.keySet()) {
			count++;
		}
		
		return count;
	}

	public int getTotalNoOfStudents() {
		HashMap<Integer,Student> students = StudentDAO.getInstance().getAllStudents();
		int count = 0;
		
		for (@SuppressWarnings("unused") int key : students.keySet()) {
			count++;
		}
		
		return count;
	}
}
