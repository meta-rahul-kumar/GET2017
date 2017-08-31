package com.metacube.main;

import com.metacube.util.Util;

/**
 * Tree Sort
 * 
 * @author Rahul Kumar
 *
 */
public class TreeSort {
	Node root;

	/**
	 * default constrcutor
	 */
	public TreeSort() {
		root = null;
	}

	/**
	 * paramaterized constructor
	 * 
	 * @param data
	 */
	public TreeSort(Student data) {
		Node newNode = new Node(data);
		root = newNode;
	}

	/**
	 * returns the root node
	 * 
	 * @return
	 */
	public Node getRootNode() {
		return root;
	}

	/**
	 * inserts the student in BSR=T
	 * 
	 * @param student
	 */
	public Node insert(Student student) {
		root = insert(root, student);
		return root;
	}

	/**
	 * insert the student in BST
	 * 
	 * @param currentRoot
	 * @param student
	 * @return
	 */
	public Node insert(Node currentRoot, Student student) {
		if (currentRoot == null) {
			currentRoot = new Node(student);

		} else {
			if (student.getRollNo() > currentRoot.getData().getRollNo()) {
				// if roll no is less then current root student roll no.
				currentRoot.setRightChild(insert(currentRoot.getRightChild(), student));
			} else if (student.getRollNo() < currentRoot.getData().getRollNo()) {
				currentRoot.setLeftChild(insert(currentRoot.getLeftChild(), student));
			}
		}

		return currentRoot;
	}

	/**
	 * inOrder Traversal
	 */
	public void inOrder() {
		inOrderTraversal(root);
	}

	/**
	 * override inOrder Traversal of BST
	 * 
	 * @param currentNode
	 */
	public void inOrderTraversal(Node currentNode) {
		if (currentNode.getLeftChild() != null) {
			// checks that left child exists
			inOrderTraversal(currentNode.getLeftChild());
		}

		System.out.println(currentNode.getData().getRollNo() + "\t\t" + currentNode.getData().getName());

		if (currentNode.getRightChild() != null) {
			// checks that right child exists
			inOrderTraversal(currentNode.getRightChild());
		}
	}

	public static void main(String[] args) {
		TreeSort treeSort = new TreeSort();
		int noOfStudents = Util.getNumberOfStudents();

		for (int i = 0; i < noOfStudents; i++) {
			int rollNo = Util.getRollNo();
			String name = Util.getName();
			Student student = new Student(rollNo, name);
			treeSort.insert(student);
		}

		System.out.println("Sorted Students : ");
		System.out.println("Roll No \t Name");
		System.out.println("------------------------");
		treeSort.inOrder();
		System.out.println("------------------------");
	}
}
