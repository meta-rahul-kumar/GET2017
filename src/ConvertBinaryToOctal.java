/**
 * Class Converts the Binary Number to Octal Form.Logic is that First Convert Binary to Decimal and Then Decimal to Binary.
 * 
 * @version 1.0 13 July 2017
 * @author Rahul Kumar
 */
public class ConvertBinaryToOctal {
	/**
	 * Method - convertBinaryToDecimal
	 * Method take Binary Number as Integer and Converts it to Decimal and then pass it to convertDecimalToOctal Method
	 * and after getting Octal Value from ConvertDecimalToOctal Method return it to Main Method
	 */
	int convertBinaryToDecimal(int n) {
		int remainder = 0; 							    // Take remainder when number is divided from 10 
		int decimalAnswer = 0; 						    // Stores converted decimal result
		int multiplier = 1; 						    // Multiplier which increase by 2 every time to make it possible to convert in Decimal
			
		while (n != 0) {
			remainder = n % 10;  						// stores remainder which is taken by dividing number by 10
			decimalAnswer += remainder * multiplier; 	// Adding the reminder and multiplier product to decimalAnswer 
			multiplier *= 2; 						    // multiplies multiplier value by 2
			n = n / 10; 								// dividing number by 10
		}
			
		return convertDecimalToOctal(decimalAnswer);	    // return result which obtained from convertDecimalToOctal Method to Main Method
	}
	/**
	 * Method - convertDecimalToOctal
	 * Method take Decimal Number as Integer and Converts it to Octal and then pass it to convertBinaryToDecimal Method
	 * and after getting Octal Value from ConvertDecimalToOctal Method return it to ConvertBinaryToDecimal Method
	 */
	int convertDecimalToOctal(int n) {
		int decimalRemainder = 0; 										   // Take remainder when number is divided from 8
		int octalAnswer = 0; 											   // Stores converted octal result
		int octalIncreaser = 0; 										   // Increaser which increase by 1 every time to make it possible to convert in octal
		
		while (n != 0) {
			decimalRemainder = n % 8; 									   // Stores remainder when number is divided from 8 in decimalReminder
			octalAnswer += decimalRemainder * Math.pow(10 , octalIncreaser); // Adding the reminder and 10 power octalMultiplier product to octalAnswer
			octalIncreaser++; 											   // increase octalMultiplier value by 1
			n = n / 8; 													   // dividing number by 8
		}
		
		return octalAnswer;												   // return result which obtained from convertDecimalToOctal Method to convertBinaryToDecimal Method
	}
}
