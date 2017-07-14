import org.junit.*;
import static org.junit.Assert.*;

public class TestConvertBinaryToOctal {
	
	/**
	 * Checks convertBinaryToDecimal function 
	 * Given Binary Value : 110101
	 * Expected Output : 65
	 * Test Status : Pass
	 */
	@Test
	public void checkOctalPass() { 
		ConvertBinaryToOctal binary=new ConvertBinaryToOctal();  					// Creates Object of ConvertBinaryToOctal Class
		int resultpass1=binary.convertBinaryToDecimal(Integer.parseInt("110101"));  // Calls convertBinaryToDecimal function
		assertEquals(65, resultpass1);
	}
	
	/**
	 * Checks convertBinaryToDecimal function 
	 * Given Binary Value : 110101
	 * Expected Output : 65
	 * Test Status : Pass
	 */
	@Test
	public void checkOctalFail() {
		ConvertBinaryToOctal binary = new ConvertBinaryToOctal();				  	   // Creates Object of ConvertBinaryToOctal Class
		int resultfail = binary.convertBinaryToDecimal(Integer.parseInt("011"));	   // Calls convertBinaryToDecimal function
		assertEquals(4, resultfail);
	}

	/**
	 * Checks convertDecimalToOctal function 
	 * Given Binary Value : 9
	 * Expected Output : 11
	 * Test Status : Fail
	 */
	@Test
	public void checkResultFail() {
		ConvertBinaryToOctal binary = new ConvertBinaryToOctal();				      // Creates Object of ConvertBinaryToOctal Class
		int resultfail = binary.convertDecimalToOctal(Integer.parseInt("9"));       // Calls convertDecimalToOctal function
		assertEquals(10, resultfail);
	}

	/**
	 * Checks convertDecimalToOctal function 
	 * Given Binary Value : 20
	 * Expected Output : 24
	 * Test Status : Pass
	 */
	@Test
	public void checkResultPass() {
		ConvertBinaryToOctal binary = new ConvertBinaryToOctal(); 				 // Creates Object of ConvertBinaryToOctal Class
		int resultpass = binary.convertDecimalToOctal(Integer.parseInt("20"));	 // Calls convertDecimalToOctal function
		assertEquals(24, resultpass); 											
	}
	
}
