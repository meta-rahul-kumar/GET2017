/**
 * Class provides greatest common divisor of two numbers.
 * 
 * @version 1.0 17 July 2017
 * @author Rahul Kumar
 */
package Question1;

public class Gcd {
	
	/*
	 *  Method - gdc
	 *  input - takes two integer arguments x(First Number) and y(Second Number) 
	 *  output - return Greatest Common Divisor of given two input numbers
	 */
	 int gcd(int x, int y) {
		 if (Math.abs(x) < Math.abs(y)) {
			 x = Math.abs(x) + Math.abs(y);
			 y = Math.abs(x) - Math.abs(y);
			 x = Math.abs(x) - Math.abs(y);
		 }
		 if (Math.abs(x) % Math.abs(y) == 0) {
			 return Math.abs(y);
		 }
		 return gcd(Math.abs(y), Math.abs(x / y));
	 }
}
