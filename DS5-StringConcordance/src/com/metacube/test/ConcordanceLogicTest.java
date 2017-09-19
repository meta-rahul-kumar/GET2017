package com.metacube.test;
import static org.junit.Assert.*;
import org.junit.Test;
import com.metacube.main.ConcordanceLogic;

public class ConcordanceLogicTest {
	
	@Test
	public void makeConcordanceTest_True() {
		ConcordanceLogic concordanceLogic = new ConcordanceLogic();
		String[] input = {"Hello", "World"};
		String expected = "{r = [7] d = [9] e = [1] W = [5] H = [0] l = [2, 3, 8] o = [4, 6] }";
		assertEquals(expected, concordanceLogic.makeConcordance(input));
	}
	
	@Test
	public void makeConcordanceTest_False() {
		ConcordanceLogic concordanceLogic = new ConcordanceLogic();
		String[] input = {"Hello", "World"};
		String expected = "{r = [5] d = [9] e = [1] W = [5] H = [0] l = [2, 3, 8] o = [4, 6] }";
		assertNotEquals(expected, concordanceLogic.makeConcordance(input));
	}
}
