package com.metacube.resource;

public class Node<T> {
	T data;
	@SuppressWarnings("rawtypes")
	Node next;
	
	public Node() {
		
	}
	
	public Node(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	
	@SuppressWarnings("rawtypes")
	public Node getNext() {
		return next;
	}
	
	@SuppressWarnings("rawtypes")
	public void setNext(Node nextNode) {
		next = nextNode;
	}
	
	public void setData(T data) {
		this.data = data;
	}
}
