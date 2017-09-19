package com.metacube.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.metacube.resources.PriorityQueue;

public class PriorityQueueTest {
	
	@Test
	public void getParentTest_True() {
		PriorityQueue priorityQueue = new PriorityQueue(3);
		priorityQueue.addJob(1, 4);
		priorityQueue.addJob(2, 3);
		priorityQueue.addJob(3, 1);
		
		int expected = 0;
		assertEquals(expected, priorityQueue.getParent(1));
	}
	
	@Test
	public void getParentTest_False() {
		PriorityQueue priorityQueue = new PriorityQueue(3);
		priorityQueue.addJob(1, 4);
		priorityQueue.addJob(2, 3);
		priorityQueue.addJob(3, 1);
		
		int expected = 1;
		assertNotEquals(expected, priorityQueue.getParent(0));
	}
	
	@Test
	public void getLeftChildTest_True() {
		PriorityQueue priorityQueue = new PriorityQueue(3);
		priorityQueue.addJob(1, 4);
		priorityQueue.addJob(2, 3);
		priorityQueue.addJob(3, 1);
		
		int expected = 2;
		assertEquals(expected, priorityQueue.getLeftChild(1));
	}
	
	@Test
	public void getLeftChildTest_False() {
		PriorityQueue priorityQueue = new PriorityQueue(3);
		priorityQueue.addJob(1, 4);
		priorityQueue.addJob(2, 3);
		priorityQueue.addJob(3, 1);
		
		int expected = 3;
		assertNotEquals(expected, priorityQueue.getLeftChild(1));
	}
	
	@Test
	public void getRightChildTest_True() {
		PriorityQueue priorityQueue = new PriorityQueue(3);
		priorityQueue.addJob(1, 4);
		priorityQueue.addJob(2, 3);
		priorityQueue.addJob(3, 1);
		
		int expected = 3;
		assertEquals(expected, priorityQueue.getRightChild(1));
	}
	
	@Test
	public void getRightChildTest_False() {
		PriorityQueue priorityQueue = new PriorityQueue(3);
		priorityQueue.addJob(1, 4);
		priorityQueue.addJob(2, 3);
		priorityQueue.addJob(3, 1);
		
		int expected = 2;
		assertNotEquals(expected, priorityQueue.getRightChild(1));
	}
	
	@Test
	public void removeTest_True() {
		PriorityQueue priorityQueue = new PriorityQueue(3);
		priorityQueue.addJob(1, 4);
		priorityQueue.addJob(2, 3);
		priorityQueue.addJob(3, 1);
		
		int expected = 1;
		assertEquals(expected, priorityQueue.remove().getid());
	}
	
	@Test
	public void removeTest_False() {
		PriorityQueue priorityQueue = new PriorityQueue(3);
		priorityQueue.addJob(1, 4);
		priorityQueue.addJob(2, 3);
		priorityQueue.addJob(3, 1);
		
		int expected = 2;
		assertNotEquals(expected, priorityQueue.remove().getid());
	}
}
