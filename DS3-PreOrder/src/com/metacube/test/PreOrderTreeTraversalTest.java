package com.metacube.test;
import org.junit.Test;

import com.metacube.resource.Node;
import com.metacube.resource.PreOrderTreeTraversal;

import static org.junit.Assert.*;
import org.junit.Before;
/**
 * Test Class For PreOrderTreeTraversal
 * @author User17
 *
 */
public class PreOrderTreeTraversalTest {
	PreOrderTreeTraversal preOrderTreeTraversal;
	
	@Before
	public void setObject() {
		preOrderTreeTraversal = new PreOrderTreeTraversal(5);
	}
	
	@Test
	public void addNodeTest_True() {
		int resultNode = preOrderTreeTraversal.addNode(5).getData();
		int expected = new Node(5).getData();
		assertEquals(expected, resultNode);
	}
	
	@Test
	public void addNodeTest_False() {
		int resultNode = preOrderTreeTraversal.addNode(5).getData();
		int expected = new Node(4).getData();
		assertNotEquals(expected, resultNode);
	}
	
	@Test
	public void preOrder_True() {
		int resultNode = preOrderTreeTraversal.addNode(5).getData();
		int expected = new Node(5).getData();
		assertEquals(expected, resultNode);
	}
}
