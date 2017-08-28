package com.metacube.main;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Concordance class tells the position of every character in a input string
 * 
 * Note : - Program will run on command line arguments
 * @author Rahul Kumar
 *
 */
public class Concordance {
	
	public static void main(String args[]) {
		HashMap<Character, String> concordance = new HashMap<>();
		String oneByOneArgs = "";
		int position = 0;
		
		System.out.println(Arrays.toString(args));
		
		for (int i = 0; i < args.length; i++) {
			oneByOneArgs = args[i];
			
			for (int j = 0 ;j < oneByOneArgs.length(); j++) {
				
				if (concordance.get(oneByOneArgs.charAt(j)) != null) {
					concordance.put(oneByOneArgs.charAt(j), concordance.get(oneByOneArgs.charAt(j)) + position);
				} else {
					concordance.put(oneByOneArgs.charAt(j), position + "");
				}
				
				position++;
			}
		}
		
		System.out.print("{");
		
		for (char key : concordance.keySet()) {
			System.out.print(key + " = " + Arrays.toString(concordance.get(key).toCharArray()) + " ");
		}
		
		System.out.print("}");
	}
}
