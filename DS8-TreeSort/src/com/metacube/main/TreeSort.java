package com.metacube.main;
import java.util.Scanner;

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
			if (student.getRollNo() >= currentRoot.getData().getRollNo()) {
				// if roll no is less then current root student roll no.
				currentRoot.setRightChild(insert(currentRoot.getRightChild(), student));
			} else if (student.getRollNo() < currentRoot.getData().getRollNo()) {
				currentRoot.setLeftChild(insert(currentRoot.getLeftChild(), student));
			}
		}

		return currentRoot;
	}
	
	public boolean isStudentExists(Node currentNode, int rollNo) {
		
		if (currentNode == null) {
			return false;
		} else if (currentNode != null && currentNode.getData().getRollNo() == rollNo){
			return true;
		}
		
		if (currentNode.getData().getRollNo() < rollNo) {
			// if roll no is less then current root student roll no.
			return isStudentExists(currentNode.getRightChild(), rollNo);
		} else if (currentNode.getData().getRollNo() > rollNo) {
			return isStudentExists(currentNode.getLeftChild(), rollNo);
		}
		return false; 
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

	/**
	 * Takes a integer input
	 * 
	 * @return
	 */
	public int getNumberOfStudents() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int number = 0;
		boolean flag = true;
		System.out.println("How many Students do you want to enter ?");

		while (flag) {

			while (!sc.hasNextInt()) {
				// runs while next Input is not Integer
				System.out.println("Please Enter a Valid Number");
				sc.nextLine();
			}
			number = sc.nextInt();

			if (number <= 0) {
				System.out.println("Please Enter a Valid Number");
				sc.nextLine();
			} else {
				flag = false;
			}
		}
		return number;
	}

	/**
	 * Takes a Student Roll Number
	 * 
	 * @return
	 */
	public int getRollNo() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in); // Problem was in making the Static object of Scanner.
		int number = 0;
		boolean flag = true;
		System.out.println("Enter Student Roll No");

		while (flag) {
			while (!sc.hasNextInt()) {
				// runs while next Input is not Integer
				System.out.println("Please Enter a Valid Number");
				sc.nextLine();
			}
			number = sc.nextInt();

			if (number <= 0) {
				System.out.println("Please Enter a Valid Roll No.");
				sc.nextLine();
			} else if (this.isStudentExists(this.getRootNode(), number)) {
				System.out.println("Roll No Already Exists !!");
				System.out.println("Please Enter a Unique Roll No");
				sc.nextLine();
			} else {
				flag = false;
			}
		}
		return number;
	}

	/**
	 * Takes the Name of Student
	 * 
	 * @return
	 */
	public String getName() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String name;
		System.out.println("Enter Student Name");
		name = sc.nextLine();
		return name;
	}
	
	public static void main(String[] args) {
		TreeSort treeSort = new TreeSort();
		int noOfStudents = treeSort.getNumberOfStudents();

		for (int i = 0; i < noOfStudents; i++) {
			int rollNo = treeSort.getRollNo();
			String name = treeSort.getName();
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
