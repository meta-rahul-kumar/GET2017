package com.metacube.resources;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * class have method to add a node to sorted Linkedlist and for showing the linkedlist.
 * @author Rahul Kumar
 *
 */
public class SortedLinkedList {
	LinkedList<Integer> linklist = new LinkedList<>();
	
	/**
	 * SortedLinkedList Constructor
	 */
	public SortedLinkedList() {
		
	}
	
	/**
	 * Adds a node to sorted linkedlist
	 * @param number
	 * @return Object
	 */
	public Object addNode(int number) {
		return addNodeToSortedLinkedList(0, number);
	}
	
	/**
	 * Private method to add node in sorted linkedlist
	 * @param position
	 * @param number
	 * @return
	 */
	private Object addNodeToSortedLinkedList(int position, int number) {
		if (linklist.size() == 0) {
			linklist.add(number);
			return number;
		} else if (position == linklist.size()) {
			linklist.addLast(number);
			return number;
		} else if (linklist.get(position) > number ) {
			linklist.add(position, number);
			return number;
		} else {
			 addNodeToSortedLinkedList(position + 1, number);
			 return number;
		}
			
	}

	/**
	 * method traverse the sorted linkedlist
	 */
	public void traverse() {
		Iterator<Integer> it = linklist.iterator();
		
		System.out.println("LinkedList : ");
		System.out.println("----------------------------------------------------");
		
		while (it.hasNext()) {
			System.out.print(it.next());
			
			if (it.hasNext()) {
				System.out.print(" -> ");
			}
		}
		
		System.out.println();
		System.out.println("----------------------------------------------------");
	}
}
