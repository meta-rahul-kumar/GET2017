
public class Utils {
	
	/**
	 * take String input and convert it into double 
	 * @param valuedString
	 * @return
	 */
	double changeToDouble(String valuedString) {
		double doubleNumber;
		doubleNumber = Double.parseDouble(valuedString);
		
		return doubleNumber;
	}
	
	/**
	 * takes String input and convert it into integer
	 * @param valuedString
	 * @return
	 */
	int changeToInteger(String valuedString) {
		int integerNumber;
		integerNumber = Integer.parseInt(valuedString);
		
		return integerNumber;
	}
	
	double roundNumber(double Number) {
		String formattedString = String.format("%.02f", Number);
		return Double.parseDouble(formattedString);
	}
}
