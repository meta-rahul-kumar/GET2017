package com.metacube.main;

/**
 * Main Class
 * @author Rahul Kumar
 *
 */
public class Main {
	public static void main(String[] args) {
		UniqueCharacters uniqueWords = new UniqueCharacters();
		System.out.println(uniqueWords.getUniqueCharacters("aaaaabbbb"));
		System.out.println(uniqueWords.getUniqueCharacters("aaaaa"));
	}
}
