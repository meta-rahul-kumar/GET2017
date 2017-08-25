package com.metacube.queue;

/**
 * Queue Interface
 * @author Rahul Kumar
 *
 */
public interface QueueInteface {
	
	/**
	 * Insert an element in Queue
	 * @param item
	 */
	public void enqueue(int item);
	
	/**
	 * removes an element from queue
	 * @return
	 */
	public Object dequeue();
	
	/**
	 * remove all elements from Queue
	 */
	public void makeEmpty();
	
	/**
	 * returns the front element of queue
	 * @return
	 */
	public Object getFront();

}
