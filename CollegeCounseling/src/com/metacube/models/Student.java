package com.metacube.models;

/**
 * Student Model Class
 * @author Rahul Kumar
 *
 */
public class Student extends BaseEntity{
	int studentID;
	String studentName;
	int studentRank;
	int allotedCollegeID;
	
	/**
	 * Student Constructor
	 */
	public Student() {
		
	}
	
	/**
	 * Student Parameterized Constructor
	 * @param id
	 * @param name
	 * @param rank
	 */
	public Student(int id, String name, int rank) {
		studentID = id;
		studentName = name;
		studentRank = rank;
		allotedCollegeID = 0;
	}
	
	/**
	 * sets the college id
	 * @param id
	 */
	public void setStudentID(int id) {
		studentID = id;
	}
	
	/**
	 * sets the student name
	 * @param name
	 */
	public void setStudentName(String name) {
		studentName = name;
	}
	
	/**
	 * sets the student rank
	 * @param rank
	 */
	public void setStudentRank(int rank) {
		studentRank = rank;
	}
	
	/**
	 * sets the Allocated College id for Student
	 * @param id
	 */
	public void setStudentAllotedCollegeID(int id) {
		allotedCollegeID = id;
	}
	
	/**
	 * returns the student id
	 * @return
	 */
	public int getStudentID() {
		return studentID;
	}
	
	/**
	 * returns the student name
	 * @return
	 */
	public String getStudentName() {
		return studentName;
	}
	
	/**
	 * returns the student rank
	 * @return
	 */
	public int getStudentRank() {
		return studentRank;
	}
	
	/**
	 * retruns the allocated college id of student
	 * @return
	 */
	public int getStudentAllotedCollegeID() {
		return allotedCollegeID;
	}
}
