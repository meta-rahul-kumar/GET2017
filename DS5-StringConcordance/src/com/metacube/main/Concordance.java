package com.metacube.main;

/**
 * Concordance class tells the position of every character in a input string
 * 
 * Note : - Program will run on command line arguments
 * @author Rahul Kumar
 *
 */
public class Concordance {
	
	public static void main(String args[]) {
		ConcordanceLogic concordanceLogic = new ConcordanceLogic();
		System.out.println(concordanceLogic.makeConcordance(args));
	}
}
