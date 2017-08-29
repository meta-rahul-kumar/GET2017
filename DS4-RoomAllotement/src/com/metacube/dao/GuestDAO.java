package com.metacube.dao;
import java.util.HashMap;
import com.metacube.model.Guest;

/**
 * GuestDAO perform the manipulation, accessing methods for Guest
 * @author Rahul Kumar
 *
 */
public class GuestDAO{
	public static GuestDAO guestDAO;
	HashMap<Integer, Guest> allGuest = new HashMap<>();
	
	/**
	 * Single Global Access Method
	 * @return
	 */
	public static GuestDAO getInstance() {
		if (guestDAO == null) {
			synchronized (GuestDAO.class) {
				if (guestDAO == null) {
					guestDAO = new GuestDAO();
				}
			}
		}
		
		return guestDAO;
	}
	
	/**
	 * returns all the guest
	 * @return
	 */
	public HashMap<Integer, Guest> getAllGuests() {
		return allGuest;
	}

	/**
	 * Adds a Guest
	 * @param id
	 * @param guest
	 */
	public void addGuest(int id, Guest guest) {
		allGuest.put(id, guest);
	}
	
	
}
