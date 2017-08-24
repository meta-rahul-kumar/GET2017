package com.metacube.tests;
import org.junit.Test;
import com.metacube.resource.Stack;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Test Class for the Stack Class
 * @author User17
 *
 */
public class StackTest {
	Stack<Character> stack;
	
	/**
	 * creating Stack Class object. 
	 */
	@Before
	public void setObject() {
		stack = new Stack<>();
	}
	
	/**
	 * True Test Case for isEmpty Method
	 */
	@Test
	public void isEmptyTest_True() {
		stack.push('A');
		stack.pop();
		
		boolean expected = true;
		assertEquals(expected, stack.isEmpty());
	}
	
	/**
	 * False Test Case for isEmpty Method
	 */
	@Test
	public void isEmptyTest_False() {
		stack.push('B');
		boolean expected = true;
		assertNotEquals(expected, stack.isEmpty());
	}
	
	/**
	 * True Test Case for getPrecedence Method
	 */
	@Test
	public void getPrecedenceTest_True() {
		int expected = 2;
		assertEquals(expected, stack.getPrecedence('*'));
	}
	
	/**
	 * False Test Case for getPrecedence Method
	 */
	@Test
	public void getPrecedenceTest_False() {
		int expected = 1;
		assertNotEquals(expected, stack.getPrecedence('*'));
	}
	
	/**
	 * True Test Case for isOperator Method
	 */
	@Test
	public void isOperatorTest_True() {
		boolean expected = true;
		assertEquals(expected, stack.isOperator('*'));
	}
	
	/**
	 * False Test Case for isOperator Method
	 */
	@Test
	public void isOperatorTest_False() {
		boolean expected = true;
		assertNotEquals(expected, stack.isOperator('A'));
	}
}
