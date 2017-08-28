package com.metacube.facade;
import java.util.HashMap;
import com.metacube.dao.CollegeDAO;
import com.metacube.models.College;

/**
 * CollegeFacade performs all the bussiness logics on College Entity
 * @author Rahul Kumar
 *
 */
public class CollegeFacade {

	/**
	 * Shows all the Colleges
	 */
	public void getAllColleges() {
		HashMap<Integer,College> colleges = CollegeDAO.getInstance().getAllColleges();
		for (int key : colleges.keySet()) {
			System.out.println(colleges.get(key).getCollegeID() + "\t" + colleges.get(key).getCollegeName() + "\t\t" + colleges.get(key).getNoOfSeatsInCollege());
		}
	}

	/**
	 * adds a college
	 * @param id
	 * @param name
	 * @param seats
	 */
	public void addCollege(int id, String name, int seats) {
		CollegeDAO.getInstance().addCollege(id, name, seats);
	}

	/**
	 * Check that a college have empty empty or not
	 * @return true if college have empty seat(s)
	 * @return false if college not have empty seat(s)
	 */
	public boolean checkCollegeForEmptySeat(int requiredCollegeId) {
		boolean status = false;
		
		HashMap<Integer,College> colleges = CollegeDAO.getInstance().getAllColleges();
		if (colleges.get(requiredCollegeId).getNoOfSeatsInCollege() != 0) {
			status = true;
		}
		
		return status;
	}
	
	/**
	 * method decrement the seat of a college
	 * @param collegeId
	 */
	public void decrementSeatsAfterSeatAllocation(int collegeId) {
		HashMap<Integer,College> colleges = CollegeDAO.getInstance().getAllColleges();
		colleges.get(collegeId).setNoOfSeatsInCollege(colleges.get(collegeId).getNoOfSeatsInCollege() - 1);
	}

	/**
	 * returns the total seats in counseling
	 */
	public int getTotalSeats() {
		HashMap<Integer,College> colleges = CollegeDAO.getInstance().getAllColleges();
		int totalSeats = 0;
		
		for (int key : colleges.keySet()) {
			totalSeats += colleges.get(key).getNoOfSeatsInCollege();
		}
		
		return totalSeats;
	}

	/**
	 * returns the College name for a specified College ID
	 * @param studentAllotedCollegeID
	 * @return College Name(String)
	 */
	public String getCollegeNameById(int studentAllotedCollegeID) {
		HashMap<Integer,College> colleges = CollegeDAO.getInstance().getAllColleges();
		
		return colleges.get(studentAllotedCollegeID).getCollegeName();
	}

	/**
	 * returns the highest College ID
	 * @return integer
	 */
	public int getLastCollegeID() {
		HashMap<Integer,College> colleges = CollegeDAO.getInstance().getAllColleges();
		int count = 0;
		
		for (@SuppressWarnings("unused") int key : colleges.keySet()) {
			count++;
		}
		
		return count;
	}
}
