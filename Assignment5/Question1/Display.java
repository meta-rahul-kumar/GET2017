package Question1;

/**
 * class display the result of operation and display the calculator interface
 * 
 * @version 1.0 19 July 2017
 * @author User17
 *
 */
public class Display {
	
	/**
	 * method - displayResult
	 * 
	 * display the operation result
	 * 
	 * @param currentResult
	 * @return
	 */
	public double displayResult(double currentResult) {
		double result = currentResult;
		
		return result;
	}
	
	/**
	 * method - displayCalculator
	 * 
	 * display calculator interface
	 * 
	 * @return
	 */
	public String displayCalculator() {
		String calculator = new String();
		
		calculator = "1 2 3 +\n"
				   + "4 5 6 -\n"
				   + "7 8 9 /\n"
				   + "0 % N * ";
		
		return calculator;
	}
}
