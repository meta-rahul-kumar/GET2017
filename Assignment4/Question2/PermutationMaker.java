package Question2;
import java.util.ArrayList;
import java.util.List;

/**
 * class take an input string and return the all possible permutation 
 * that can be made using the string characters.
 * 
 * @version 1.0 18 July 2017
 * @author Rahul Kumar
 * 
 */
public class PermutationMaker {

	List<String> possiblePermutations = new ArrayList<String>();

	/**
	 * Method - swap
	 * 
	 * Method take a input String , starting index of input array and second index
	 * @param inputString
	 * @param firstIndex
	 * @param secondIndex
	 * @return String after swapping
	 */
	public String swap(String inputString, int firstIndex, int secondIndex) {
		char[] characterArray = inputString.toCharArray();
		char temp = characterArray[firstIndex];
		characterArray[firstIndex] = characterArray[secondIndex];
		characterArray[secondIndex] = temp;
		
		return String.valueOf(characterArray);
	}


	/**
	 * Method - generatePermutations
	 * 
	 * Method Generates all possible permutation of input String
	 * @param inputString
	 * @param lowIndex
	 * @param highIndex
	 * @return ArrayList<String>
	 */

	List<String> generatePermutations(String inputString, int lowIndex,
			int highIndex) {

		if (lowIndex == highIndex) {
			if (!possiblePermutations.contains(inputString)) {
				possiblePermutations.add(inputString);
			}
		} else {
			for (int iterateIndex = lowIndex; iterateIndex <= highIndex; iterateIndex++) {
				inputString = swap(inputString, iterateIndex, lowIndex);
				generatePermutations(inputString, lowIndex + 1, highIndex);
				inputString = swap(inputString, iterateIndex, lowIndex);
			}
		}
		return possiblePermutations;
	}
	
	List<String> generatePermutations(String inputString) {
		int lowIndex = 0;
		int highIndex = inputString.length() - 1;
		return generatePermutations(inputString, lowIndex, highIndex);
	}
	public static void main(String args[]) {
		List<String> permutations = new ArrayList<String>();
		PermutationMaker obj = new PermutationMaker();
		String input = "AAB";
		permutations = obj.generatePermutations(input);
		for (int i = 0; i < permutations.size(); i++) {
			System.out.println(permutations.get(i));
		}
		
	}
}

