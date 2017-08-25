package com.metacube.controller;
import com.metacube.facade.CollegeFacade;

/**
 * Controller Class for College
 * @author Rahul Kumar
 *
 */
public class CollegeController {
	
	/**
	 * shows the all colleges
	 */
	public void getAllColleges() {
		CollegeFacade collegeFacade = new CollegeFacade();
		collegeFacade.getAllColleges();
	}

	/**
	 * adds a college
	 * @param id
	 * @param name
	 * @param seats
	 */
	public void addCollege(int id, String name, int seats) {
		CollegeFacade collegeFacade = new CollegeFacade();
		collegeFacade.addCollege(id,name,seats);
	}

	/**
	 * returns the highest college id
	 * @return
	 */
	public int getLastCollegeID() {
		CollegeFacade collegeFacade = new CollegeFacade();
		return collegeFacade.getLastCollegeID();
	}
}
