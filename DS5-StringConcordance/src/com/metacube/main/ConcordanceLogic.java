package com.metacube.main;

import java.util.Arrays;
import java.util.HashMap;

public class ConcordanceLogic {
	
	public String makeConcordance(String [] args) {
		HashMap<Character, String> concordance = new HashMap<>();
		String arg = "";
		int position = 0;
		
		for (int i = 0; i < args.length; i++) {
			arg = args[i];
			
			for (int j = 0 ;j < arg.length(); j++) {
				
				if (concordance.get(arg.charAt(j)) != null) {
					concordance.put(arg.charAt(j), concordance.get(arg.charAt(j)) + position);
				} else {
					concordance.put(arg.charAt(j), position + "");
				}
				
				position++;
			}
		}
		
		String concordanceList = "";
		concordanceList += "{";
		
		for (char key : concordance.keySet()) {
			concordanceList += key + " = " + Arrays.toString(concordance.get(key).toCharArray()) + " ";
		}
		
		concordanceList += "}";
		
		return concordanceList;
	}
}
