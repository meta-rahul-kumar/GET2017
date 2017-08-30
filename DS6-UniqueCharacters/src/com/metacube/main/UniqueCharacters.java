package com.metacube.main;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * UniqueWords class have method getUniqueCharacters which returns the unique words in a string.
 * @author Rahul Kumar
 *
 */
public class UniqueCharacters {
	Map<String, Integer> savedStrings = new HashMap<>();
	
	/**
	 * method takes a string and returns the number of unique words in input String.
	 * @param inputString
	 * @return
	 */
	public int getUniqueCharacters(String inputString) {
		if (savedStrings.containsKey(inputString)) {
			return savedStrings.get(inputString);
		} else {
			Set<Character> uniqueCharacters = new HashSet<>();
			
			for (int i = 0; i < inputString.length(); i++) {
				if (inputString.charAt(i) != ' ') {
					uniqueCharacters.add(inputString.charAt(i));
				}
			}
			
			savedStrings.put(inputString, uniqueCharacters.size());
			return uniqueCharacters.size();
		}
	}
}
