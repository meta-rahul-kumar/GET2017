import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @version 1.0 July 25, 2017
 * @author Rahul Kumar
 *
 */
public class ReceiptGenerator {
	
	void generateRecipt(String input) {
		try {
	         BufferedWriter receiptWriter = new BufferedWriter(new FileWriter("src\\receipt.txt",true));
	         receiptWriter.write(input);
	         receiptWriter.close();
	      }
	      catch (IOException e) {
	         System.out.println("exception occoured"+ e);
	      }
	}
	
}