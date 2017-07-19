/**
 * 
 * 
 * fact -If the legend were true, and if the priests were able to move disks at
 *  a rate of one per second, using the smallest number of moves, it would take
 *   them 264 − 1 seconds, or roughly 585 billion years to finish,[3] which is 
 *   about 42 times the current age of the Universe.
 * 
 * Class take a source , destination and Auxiliary pillar as String and an 
 * integer number of disk and returns the List of Strings that tells the moves 
 * to move all the disks from source to Destination pillar
 * 
 * @version 1.0 18 July 2017
 * @author Rahul Kumar
 */
package Question1;

import java.util.*;

public class TowerOfHanoi {
	int noOfDisk;
	List<String> towerOfHanoi(String source, String destination, String temp, int numOfDisk)
	{
		List<String> listWords = new ArrayList<String>();
		
//		if(numOfDisk == 1) {
//			listWords.add("Move Disk 1 from "+source+" to "+destination);
//			return listWords;
//		}
//		
//		listWords.addAll(towerOfHanoi(source, temp, destination, numOfDisk - 1));
//		listWords.add("Move Disk "+numOfDisk+" from "+source+" to "+destination);
//		listWords.addAll(towerOfHanoi(temp, destination, source, numOfDisk - 1));
		
		if(numOfDisk == 1) {
		listWords.add("Move Disk "+(noOfDisk+1-numOfDisk)+" from "+source+" to "+destination);
		return listWords;
		}
		
		listWords.addAll(towerOfHanoi(source, temp, destination, numOfDisk - 1));
		listWords.add("Move Disk "+(noOfDisk+1-numOfDisk)+" from "+source+" to "+destination);
		listWords.addAll(towerOfHanoi(temp, destination, source, numOfDisk - 1));
		
		return listWords;
	}
	List<String> utilTowerOfHanoi(String source, String destination, String temp, int numOfDisk)
	{
		noOfDisk=numOfDisk;
		return towerOfHanoi(source, destination, temp, numOfDisk);
	}
	
	
	public static void main(String args[]) {
		TowerOfHanoi obj = new TowerOfHanoi();
		List<String> listWords = new ArrayList<String>();
		String source = "A";
		String destination = "B";
		String temp = "C";
		int numOfDisk = 3;
		listWords = obj.utilTowerOfHanoi(source, destination, temp, numOfDisk);
				for (int i = 0; i < listWords.size(); i++) {
			System.out.println(listWords.get(i));
		}
		
	}
}
