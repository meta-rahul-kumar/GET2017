package com.metacube.test;
import static org.junit.Assert.*;
import org.junit.Test;
import com.metacube.main.UniqueCharacters;

/**
 * Test Case Class for UniqueWords Class Methods
 * @author Rahul Kumar
 *
 */
public class UniqueWordsTest {
	
	@Test
	public void getUniqueCharactersTest_True() {
		UniqueCharacters uniqueWords = new UniqueCharacters();
		String inputString = "hello world";
		int expected = 7;
		assertEquals(expected, uniqueWords.getUniqueCharacters(inputString));
	}
	
	@Test
	public void getUniqueCharactersTest_False() {
		UniqueCharacters uniqueWords = new UniqueCharacters();
		String inputString = "hello world";
		int expected = 8;
		assertNotEquals(expected, uniqueWords.getUniqueCharacters(inputString));
	}
}
