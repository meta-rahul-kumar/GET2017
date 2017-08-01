import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * class reads the csv file
 * @version 1.0 July 25, 2017
 * @author Rahul Kumar
 *
 */
public class ReadCsv {
	String filepath;
	
	/**
	 * ReadCsv Class Constructor
	 */
	ReadCsv() {
		filepath = null;
	}
	
	/**
	 * read the CSV file and return the ArrayList
	 * @param filepath
	 * @return
	 */
	 ArrayList<String> ReadCsvFile(String filepath) {
		this.filepath = filepath;
		String csvFile = filepath;
        BufferedReader fileReader = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<String> productDetails = new ArrayList<>();
        
        try {

            fileReader = new BufferedReader(new FileReader(csvFile));
            while ((line = fileReader.readLine()) != null) {

                // use comma as separator
                String[] product = line.split(cvsSplitBy);

                productDetails.add(product[0] + "\t" + product[1] + "\t" + product[2] + "\t" + product[3]);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return productDetails;
	}
	
}
