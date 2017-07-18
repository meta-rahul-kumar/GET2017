/**
 * Class provides largest digit of a number.
 * 
 * @version 1.0 17 July 2017
 * @author Rahul Kumar
 */
package Question1;

public class LargestDigit {
	 int largestDigit(int x) {
		 if (Math.abs(x) == 0) {
			 return 0;
		 }
		 int max = Math.abs(x) % 10;  //  take last digit as maximum digit
		 int checking = largestDigit(Math.abs(x) / 10);
		 if (max < checking) {
			 max = checking;
		 }
		 return max;
		 
	 }
}
