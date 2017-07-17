package Question2;

/**
 * Class Prints the pryamid of size n.
 * for ex: n=5
 * 12345
 *  1234
 *   123
 *    12
 *     1
 * 
 * @version 1.0 15 July 2017
 * @author Rahul Kumar
 */


public class Pyramid {
	
	/*
	 * Method - pyramid
	 * 
	 * input - size of pyramid integer n
	 * output - pattern as String object
	 */
	public String pyramid(int n){
		StringBuilder pyramid = new StringBuilder(); // Stores the whole pyramid
		try {
			if (n < 1) {
				throw(new Exception());
			}
			
			for(int loopCounter = n;loopCounter >= 1; loopCounter--){
				pyramid.append(patternBuilder(n, loopCounter));
			}
		} catch (Exception invalidArgumentException) {
			return "Please Enter valid integer pyramid size";
		}
		return pyramid.toString();
	}
	
	/*
	 * Method - patternBuilder
	 * 
	 * input - size of pyramid integer n, loopCounter Values
	 * output - pattern as String object
	 */
	public String patternBuilder(int n, int loopCounter) {
		StringBuilder result = new StringBuilder();
		result.append(spaces(loopCounter, n));
		result.append(numbers(loopCounter, n)).append("\n");
		return result.toString();
	}
	
	/*
	 * Method - spaces
	 * 
	 * input - row no as integer and size of pyramid integer n
	 * output - Spaces as String object
	 */
	public String spaces(int row, int n){
		if(row <= n) {
			StringBuilder space = new StringBuilder();
		
			for(int spacesCounter = 0; spacesCounter < (n - row); spacesCounter++){
				space.append(" ");
			}
		
			return space.toString();
		} else {
			return "row must be less than pyramid size";
		}
	}
	
	/*
	 * Method - numbers
	 * 
	 * input - row no as integer and size of pyramid integer n
	 * output - numbers as String object for ex: 12321
	 */
	public String numbers(int row, int n){
		if(row <= n) {
			StringBuilder number = new StringBuilder();
			
			for(int numberCounter = 1; numberCounter <= row; numberCounter++){
					number.append(numberCounter);
				}
			
			return number.toString();
		} else {
			return "row must be less than pyramid size";
		}
	}
}

