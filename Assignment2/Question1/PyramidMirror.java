package Question1;
/**
 * Class Prints the pryamid of size n.
 * for ex: n=5
 *     1
 *    121
 *   12321
 *  1234321
 * 123454321
 *  1234321
 *   12321
 *    121
 *     1
 * 
 * @version 1.0 15 July 2017
 * @author Rahul Kumar
 */


public class PyramidMirror {
	
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
			for (int loopCounter = 1; loopCounter <= n; loopCounter++){
				pyramid.append(patternBuilder(n,loopCounter));
			}
			
			for (int loopCounter = n - 1; loopCounter >= 1; loopCounter--){
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
		try{
			if(row <= n) {
				StringBuilder space = new StringBuilder();
				
				for (int spaceCounter = 0; spaceCounter < (n - row); spaceCounter++){
					space.append(" ");
				}
				
				return space.toString();
			} else {
				return "row must be less than pyramid size";
			}
		}catch (Exception invalidArgumentException) {
			return "Please Enter valid integer pyramid size";
		}
	}
	
	/*
	 * Method - numbers
	 * 
	 * input - row no as integer and size of pyramid integer n
	 * output - numbers as String object for ex: 12321
	 */
	public String numbers(int row, int n){
		try{ 
			if(row <= n) {
				StringBuilder numbers = new StringBuilder();
				
				for (int numberCounter = 1; numberCounter <= row; numberCounter++){
					numbers.append(numberCounter);
				}
				
				for (int numberCounter = row - 1; numberCounter >= 1; numberCounter--){
					numbers.append(numberCounter);
				}
			
				return numbers.toString();
			} else {
				return "row must be less than pyramid size";
			}
		}catch(Exception invalidArgumentException) {
			return "Please Enter valid integer pyramid size";
		}
	}
}
