package com.metacube.resource;
/**
 * Class Node 
 * @author Rahul Kumar
 *
 * @param <T>
 */
public class Node<T> {
	T data;
	@SuppressWarnings("rawtypes")
	Node next;
	
	/**
	 * Node Class Constructor
	 */
	public Node() {
		
	}
	
	/**
	 * Class Node Parameterized Constructor
	 * @param data
	 */
	public Node(T data) {
		this.data = data;
	}
	
	/**
	 * returns the node data
	 * @return
	 */
	public T getData() {
		return data;
	}
	
	/**
	 * returns the next node 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Node getNext() {
		return next;
	}
	
	/**
	 * sets the next node
	 * @param nextNode
	 */
	@SuppressWarnings("rawtypes")
	public void setNext(Node nextNode) {
		next = nextNode;
	}
	
	/**
	 * sets the data field of node
	 * @param data
	 */
	public void setData(T data) {
		this.data = data;
	}
}
