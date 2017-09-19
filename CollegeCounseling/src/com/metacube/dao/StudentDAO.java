package com.metacube.dao;
import java.util.HashMap;
import com.metacube.models.Student;

/**
 * StudentDAO performs the operation on Students
 * @author Rahul Kumar
 *
 */
public class StudentDAO implements BaseDAO<Student>{
	private static StudentDAO studentDAO;
	HashMap<Integer, Student> allStudents = new HashMap<>();
	
	/**
	 * returns the instance of StudentDAO
	 * @return
	 */
	public static StudentDAO getInstance() {
		if (studentDAO == null) {
			synchronized (StudentDAO.class) {
				if (studentDAO == null) {
					studentDAO = new StudentDAO();
				}
			}
		}
		return studentDAO;
	}
	
	/**
	 * returns all the students
	 * @return
	 */
	public HashMap<Integer, Student> getAllStudents() {
		return allStudents;
	}
	
	/**
	 * adds a student
	 * @param id
	 * @param name
	 * @param rank
	 */
	public void addStudent(int id, String name, int rank) {
		Student student = new Student(id,name,rank);
		allStudents.put(id, student);
	}
	
	/**
	 * return Student Object for a specified rank.
	 * @param rank
	 * @return
	 */
	public Student getStudentByRank(int rank) {
		Student student = null;
		for (int key : allStudents.keySet()) {
			if (allStudents.get(key).getStudentRank() == rank) {
				student = allStudents.get(key);
			}
		}
		
		return student;
	}
}
