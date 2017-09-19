package com.metacube.queue;
import java.util.Arrays;

/**
 * Queue Class For Counseling
 * @author Rahul Kumar
 *
 */
public class Queue implements QueueInteface{
	int rankQueue[];
	int front = 0;
	int rear = 0;
	int size = 0;
	
	/**
	 * Queue Class Constructor
	 */
	public Queue() {
		this(15); // class the parameterized Constructor
	}
	
	/**
	 * Queue Class Parameterized Constructor
	 * @param queueSize
	 */
	public Queue(int queueSize) {
		rankQueue = new int[queueSize];
	}
	
	/**
	 * insert an item in queue
	 */
	@Override
	public void enqueue(int item) {
		if (rear == rankQueue.length) {
			System.out.println("Queue is Full !!");
		} else {
			rankQueue[rear] = item;
			rear++;
			size++;
		}
		
	}

	/**
	 * removes an item from queue
	 */
	@Override
	public Object dequeue() {
		Object deletedElement = null;
		
		if (size != 0) {
			deletedElement = rankQueue[front];
			if (front == rear - 1) {
				front = 0;
				rear = 0;
			} else {
				front++;
			}
			size--;	
		}
		
		return deletedElement;
	}

	/**
	 * shows the queue
	 */
	public void showQueue() {
		System.out.println("Queue");
		
		for (int i = front; i < rear; i++) {
			System.out.print(rankQueue[i]);
			
			if (i != rear - 1) {
				System.out.print("<-");
			}
		}
	}
	
	/**
	 * gets an element from queue for a perticular position
	 * @param index
	 * @return
	 */
	public int get(int index) {
		return rankQueue[index];
	}
	
	@Override
	public void makeEmpty() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getFront() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * sorts the queue
	 */
	public void sort() {
		Arrays.sort(rankQueue,front,rear);
	}

	/**
	 * returns the size of queue
	 * @return
	 */
	public int size() {
		return size;
	}

}
