/**
 * Class provides remainder of certain inpur.
 * 
 * @version 1.0 17 July 2017
 * @author Rahul Kumar
 */
package Question1;

public class Remainder {
	/**
	 * @param x
	 * @param y
	 * @return
	 * 
	 * Method - rem
	 * input integer x, integer y
	 * output integer
	 */
	public int rem(int x, int y) {
		try {
			if(y == 0) {
				x=x/y; // to throws an exception when y is equal to 0
			}
			if (x > 0 && y > 0) {
				/* Case when x is greater than 0 and y is also greater than 0*/
				if (x >= y) {
					x = x - y;
					return rem(x, y);
				}
			} else if (x < 0 && y > 0) {
				/* Case when x is less than 0 and y is also greater than 0*/
				if(Math.abs(x) >= y) {
					x = x + y;
					return rem(x, y);
				} 
			} else if (x < 0 && y < 0) {
				/* Case when x is greater than 0 and y is also greater than 0*/
				if(Math.abs(x) >= Math.abs(y)) {
					x = x + Math.abs(y);
					return rem(x, y);
				} 
			} else if (x > 0 && y < 0) {
				if(x >= Math.abs(y)) {
					x = x + y;
					return rem(x, y);
				} 
			}
		} catch (Exception invalidArgument) {
			return -1;
		}
		return x;
	}
}