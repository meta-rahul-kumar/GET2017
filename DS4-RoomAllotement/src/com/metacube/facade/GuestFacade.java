package com.metacube.facade;
import java.util.HashMap;
import com.metacube.dao.GuestDAO;
import com.metacube.model.Guest;

/**
 * GuestFacade Class Performs the operations on Guest Entity
 * @author Rahul Kumar
 *
 */
public class GuestFacade {

	/**
	 * Adds a Guest 
	 * @param id
	 * @param name
	 * @param age
	 */
	public void addGuest(int id, String name, int age) {
		Guest guest = new Guest();
		guest.setId(id);
		guest.setName(name);
		guest.setAge(age);
		GuestDAO.getInstance().addGuest(id,guest);
		
	}

	/**
	 * returns all guests
	 * @return
	 */
	public HashMap<Integer, Guest> getAllGuests() {
		return GuestDAO.getInstance().getAllGuests();
	}
	
	/**
	 * views all guests
	 */
	public void viewGuests() {
		HashMap<Integer, Guest> allGuests = GuestDAO.getInstance().getAllGuests();
		
		System.out.println("All Guests : ");
		for (int key : allGuests.keySet()) {
			System.out.println(allGuests.get(key).getId() + "\t" + allGuests.get(key).getName() + "\t" + allGuests.get(key).getAge());
		}
	}

	/**
	 * show alloted rooms for all Guests
	 */
	public void showAllotedRooms() {
		HashMap<Integer, Guest> allGuests = GuestDAO.getInstance().getAllGuests();
		
		System.out.println("Guest ID \t Guest Name \t Guest Age \t Alloted Room No. ");
		for (int key : allGuests.keySet()) {
			System.out.println(allGuests.get(key).getId() + " \t\t " + allGuests.get(key).getName() + " \t\t " + allGuests.get(key).getAge() + " \t\t " + allGuests.get(key).getAllotedRoom());
		}
	}

	/**
	 * checks that a ID already exists or not
	 * @param id
	 * @return
	 */
	public boolean isIdAlreadyExists(int id) {
		HashMap<Integer, Guest> allGuests = GuestDAO.getInstance().getAllGuests();
		boolean isExists = false;
		
		if (allGuests.containsKey(id)) {
			isExists = true;
		}
		
		return isExists;
	}

	/**
	 * returns the total number of guests
	 * @return
	 */
	public int getTotalNumberOfGuests() {
		HashMap<Integer, Guest> allGuests = GuestDAO.getInstance().getAllGuests();
		return allGuests.size();
	}
	
}
