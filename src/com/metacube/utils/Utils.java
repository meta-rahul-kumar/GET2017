package com.metacube.utils;

import java.util.HashMap;

import com.metacube.models.Product;

public class Utils {
	
	/**
	 * take String input and convert it into double 
	 * @param valuedString
	 * @return
	 */
	public static double changeToDouble(String valuedString) {
		double doubleNumber;
		doubleNumber = Double.parseDouble(valuedString);
		
		return doubleNumber;
	}
	
	/**
	 * takes String input and convert it into integer
	 * @param valuedString
	 * @return
	 */
	public static int changeToInteger(String valuedString) {
		int integerNumber;
		integerNumber = Integer.parseInt(valuedString);
		
		return integerNumber;
	}
	
	public static double roundNumber(double Number) {
		String formattedString = String.format("%.02f", Number);
		return Double.parseDouble(formattedString);
	}
	
	public static boolean validateProduct(HashMap<String,Product> productIterator, int productCode) {
		return productIterator.containsKey(productCode+"");
	}
}