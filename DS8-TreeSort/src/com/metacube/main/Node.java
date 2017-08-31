package com.metacube.main;

/**
 * Node Class
 * 
 * @author Rahul Kumar
 *
 */
public class Node {
	Student data;
	Node left;
	Node right;

	/**
	 * Node Class default constructor
	 */
	public Node() {
		left = null;
		right = null;
	}

	/**
	 * Node Class parameterized Constructor
	 * 
	 * @param data
	 */
	public Node(Student data) {
		this.data = data;
	}

	/**
	 * sets the data
	 * 
	 * @param data
	 */
	public void setData(Student data) {
		this.data = data;
	}

	/**
	 * sets the left child
	 * 
	 * @param left
	 */
	public void setLeftChild(Node left) {
		this.left = left;
	}

	/**
	 * sets the right child
	 * 
	 * @param right
	 */
	public void setRightChild(Node right) {
		this.right = right;
	}

	/**
	 * returns the data
	 * 
	 * @return
	 */
	public Student getData() {
		return data;
	}

	/**
	 * retruns the left child
	 * 
	 * @return
	 */
	public Node getLeftChild() {
		return left;
	}

	/**
	 * returns the right child
	 * 
	 * @return
	 */
	public Node getRightChild() {
		return right;
	}
}
