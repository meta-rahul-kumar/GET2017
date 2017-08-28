package com.metacube.resources;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Queue Class 
 * @author Rahul Kumar
 *
 */
public class QueueProgram implements QueueInterface{
	LinkedList<Integer> queue = new LinkedList<>();

	/**
	 * returns the size of queue
	 */
	@Override
	public int size() {
		return queue.size();
	}

	/**
	 * checks that queue is empty or not
	 * 
	 * @return true if empty
	 * @return false if not empty
	 */
	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	/**
	 * checks that object exists in queue or not
	 */
	@Override
	public boolean contains(Object o) {
		return queue.contains(o);
	}

	/**
	 * unimplemented iterator method
	 */
	@Override
	public Iterator<Object> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		return queue.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Object> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return queue.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * method clears the queue
	 */
	@Override
	public void clear() {
		queue.clear();	
	}

	/**
	 * method adds a object to the queue
	 */
	@Override
	public boolean add(Object object) {
		queue.addLast((int)(object));
		return true;
	}

	/**
	 * similar to peek(). Throws NoSuchElementException if queue is empty
	 */
	@Override
	public Object element() {
		return queue.element();
	}

	/**
	 * Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions.
	 */
	@Override
	public boolean offer(Object object) {
		return queue.offer((int)object);
	}

	/**
	 * return the peek element
	 */
	@Override
	public Object peek() {
		return queue.peek();
	}

	/**
	 * Retrieves and removes the head of this queue, or returns null if this queue is empty.
	 */
	@Override
	public Object poll() {
		return queue.poll();
	}

	/**
	 * dequeue an element
	 */
	@Override
	public Object remove() {
		return queue.removeFirst();
	}

	/**
	 * shows the queue elements
	 */
	@SuppressWarnings("rawtypes")
	public void show() {
		System.out.println("Queue : ");
		
		Iterator it = queue.iterator();
		while (it.hasNext()) {
			System.out.print( it.next() + " ");
		}
		
		System.out.println();
	}
}
