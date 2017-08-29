package com.metacube.facade;
import java.util.HashMap;
import com.metacube.dao.RoomDAO;
import com.metacube.model.Guest;
import com.metacube.resources.Hashing;

/**
 * RoomFacade performs all the operation for rooms
 * @author Rahul Kumar
 *
 */
public class RoomsFacade {

	/**
	 * Adds Number of rooms
	 * @param noOfRooms
	 */
	public void addRooms(int noOfRooms) {
		RoomDAO.getInstance().setNumberOfRoom(noOfRooms);
	}
	
	/**
	 * returns total number of rooms
	 * @return
	 */
	public int getNoOfRooms() {
		return RoomDAO.getInstance().getNumberOfRoom();
	}

	/**
	 * allote the rooms for every Guest
	 */
	@SuppressWarnings("static-access")
	public void allotRooms() {
		GuestFacade guestFacade = new GuestFacade();
		HashMap<Integer, Guest> allGuests = guestFacade.getAllGuests();
		for (int key : allGuests.keySet()) {
			allGuests.get(key).setAllotedRoom(Hashing.getInstance().getHashResult(allGuests.get(key).getAge()) + 1);
		}
		
	}
}
