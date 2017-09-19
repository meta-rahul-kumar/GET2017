package com.metacube.main;

/**
 * Student Class
 * 
 * @author Rahul Kumar
 *
 */
public class Student implements Comparable<Student> {
	int rollNo;
	String name;

	/**
	 * default constrcutor
	 */
	public Student() {

	}

	/**
	 * parameterized constructor
	 * 
	 * @param rollNo
	 * @param name
	 */
	public Student(int rollNo, String name) {
		this.rollNo = rollNo;
		this.name = name;
	}

	/**
	 * sets the student roll no
	 * 
	 * @param rollNo
	 */
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	/**
	 * sets the student name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * returns the roll no
	 * 
	 * @return
	 */
	public int getRollNo() {
		return rollNo;
	}

	/**
	 * returns the names
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * override compareTo method
	 */
	@Override
	public int compareTo(Student o) {
		return rollNo - o.getRollNo();
	}
}
