package Question2;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class Checks the generatePermutations method of class PermutationMaker
 */
public class PermutationMakerTest {
	
	@Test
	public void permutationTest() {
		List<String> permutations = new ArrayList<String>();
		List<String> expectedPermuations = new ArrayList<String>();
		PermutationMaker obj = new PermutationMaker();
		String input = "AB";
		permutations = obj.generatePermutations(input);
		expectedPermuations.add("AB");
		expectedPermuations.add("BA");
		assertEquals(expectedPermuations, permutations); // True Case
		
		expectedPermuations.clear();
		permutations.clear();
		
		input = "AA";
		permutations = obj.generatePermutations(input);
		expectedPermuations.add("AA");
		assertEquals(expectedPermuations, permutations); // True Case
		
		expectedPermuations.clear();
		permutations.clear();
		
		input = "ABC";
		permutations = obj.generatePermutations(input);
		expectedPermuations.add("ABC");
		expectedPermuations.add("ACB");
		expectedPermuations.add("BAC");
		expectedPermuations.add("BCA");
		expectedPermuations.add("CBA");
		expectedPermuations.add("CAB");
		assertEquals(expectedPermuations, permutations); // True Case
	}
}
