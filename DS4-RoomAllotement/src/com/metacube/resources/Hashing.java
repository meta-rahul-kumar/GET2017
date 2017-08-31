package com.metacube.resources;
import java.util.ArrayList;
import com.metacube.facade.RoomsFacade;

/**
 * Class perform Hashing using Guest Age to Allot Rooms
 * @author Rahul Kumar
 *
 */
public class Hashing {
	private static Hashing hashing;
	private static ArrayList<Integer> keys = new ArrayList<>();
	
	/**
	 * Singleton Global access methods
	 * @return
	 */
	public static Hashing getInstance() {
		if (hashing == null) {
			synchronized (Hashing.class) {
				if (hashing == null) {
					hashing = new Hashing();
				}
			}
		}
		
		return hashing;
	}
	
	/**
	 * method returns the HashKey according to age
	 * @param age
	 * @return
	 */
	public static int getHashResult(int age) {
		RoomsFacade roomFacade = new RoomsFacade();
		int hashKey = age % roomFacade.getNoOfRooms();
		
		if (!keys.contains(hashKey)) {
			keys.add(hashKey);
			return hashKey;
		} else {
			return getHashResult(age + 1);
		}
	}

	public void flushValues() {
		keys.clear();
	}
}
