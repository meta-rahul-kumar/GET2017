package Question1;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class TowerOfHanoiTest {

	@Test
	public void TohTesting() {
		TowerOfHanoi obj = new TowerOfHanoi();
		List<String> listWords = new ArrayList<String>();
		List<String> expected = new ArrayList<String>();
		
		String source = "A";
		String destination = "C";
		String temp = "B";
		int numOfDisk = 1;
		listWords = obj.towerOfHanoi(source, destination, temp, numOfDisk);
		expected.add("Move Disk 1 from A to C");
		assertEquals(expected, listWords); // True Case
		
		listWords.clear();
		expected.clear();
		
		numOfDisk = 2;
		listWords = obj.towerOfHanoi(source, destination, temp, numOfDisk);
		expected.add("Move Disk 1 from A to B");
		expected.add("Move Disk 2 from A to C");
		expected.add("Move Disk 1 from B to C");
		assertEquals(expected, listWords); // True Case
		
		listWords.clear();
		expected.clear();
		
		numOfDisk = 3;
		listWords = obj.towerOfHanoi(source, destination, temp, numOfDisk);
		expected.add("Move Disk 1 from A to C");
		expected.add("Move Disk 2 from A to B");
		expected.add("Move Disk 1 from C to B");
		expected.add("Move Disk 3 from A to C");
		expected.add("Move Disk 1 from B to A");
		expected.add("Move Disk 2 from B to C");
		expected.add("Move Disk 1 from A to C");
		assertEquals(expected, listWords); // True Case
		
		listWords.clear();
		expected.clear();
		
		source = "A";
		destination = "C";
		temp = "B";
		numOfDisk = 1;
		listWords = obj.towerOfHanoi(source, destination, temp, numOfDisk);
		expected.add("Move Disk 1 from A to B");
		assertNotEquals(expected, listWords); // True Case
		
		listWords.clear();
		expected.clear();
		
		numOfDisk = 2;
		listWords = obj.towerOfHanoi(source, destination, temp, numOfDisk);
		expected.add("Move Disk 1 from A to B");
		expected.add("Move Disk 2 from A to C");
		expected.add("Move Disk 1 from A to C");
		assertNotEquals(expected, listWords); // True Case
		
		listWords.clear();
		expected.clear();
		
		numOfDisk = 3;
		listWords = obj.towerOfHanoi(source, destination, temp, numOfDisk);
		expected.add("Move Disk 1 from A to C");
		expected.add("Move Disk 2 from A to B");
		expected.add("Move Disk 1 from C to B");
		expected.add("Move Disk 3 from A to B");
		expected.add("Move Disk 1 from B to A");
		expected.add("Move Disk 2 from B to C");
		expected.add("Move Disk 1 from A to C");
		assertNotEquals(expected, listWords); // True Case
		
		
	}
}
