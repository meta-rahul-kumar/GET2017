package com.metacube.dao;
import java.util.HashMap;

import com.metacube.models.College;

/**
 * CollegeDAO performs all the operations on College. it is a singleton Class
 * @author Rahul Kumar
 *
 */
public class CollegeDAO implements BaseDAO<College>{
	private static CollegeDAO collegeDAO;
	HashMap<Integer, College> allColleges = new HashMap<>();
	
	/**
	 * Private CollegeDAO Constructor
	 */
	private CollegeDAO() {
		
	}
	
	/**
	 * Returns the CollegeDAO Instance
	 * @return
	 */
	public static CollegeDAO getInstance() {
		if (collegeDAO == null) {
			synchronized (CollegeDAO.class) {
				if (collegeDAO == null) {
					collegeDAO = new CollegeDAO();
				}
			}
		}
		
		return collegeDAO;
	}
	
	
	/**
	 * returns the all colleges
	 * @return
	 */
	public HashMap<Integer, College> getAllColleges() {
		return allColleges;
	}
	
	/**
	 * adds new college
	 * @param id
	 * @param name
	 * @param seats
	 */
	public void addCollege(int id, String name, int seats) {
		College college = new College(id,name,seats);
		allColleges.put(id, college);
	}
	
}
