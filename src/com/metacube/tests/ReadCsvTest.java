package com.metacube.tests;
import static org.junit.Assert.*;

import org.junit.Test;

import com.metacube.utils.ReadFromFile;

public class ReadCsvTest {
	ReadFromFile readFile = new ReadFromFile();
	@Test
	public void readCsvFile() {
		String filepath = "src\\Products.csv";
		String expected = "1002	Reebok T-Shirt (Black)	479.00, 4011	Reebok Shirt (Blue)	1649.00, 4010	Numero Uno T-Shirt	1290.00]";
		assertNotEquals(expected,readFile.ReadCsvFile(filepath)); // False Case
	}
}