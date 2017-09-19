package com.metacube.resource;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class provides the InOrder, PreOrder, and PostOrder Traversal Methods
 * @author Rahul Kumar
 *
 */
public class PostOrderTreeTraversal {
	Node root;
	Queue<Node> backTrack = new LinkedList<>();
	
	/**
	 * TreeTraversal class constructor
	 */
	public PostOrderTreeTraversal(){
		root = null;
		backTrack.add(root);
	}
	
	/**
	 * TreeTraversal class Parameterized constructor
	 */
	public PostOrderTreeTraversal(int item){
		root = new Node(item);
		backTrack.add(root);
	}
	
	/**
	 * method adds a new node in binary tree
	 * @param item
	 */
	public Node addNode(int item) {
		return addNode(backTrack.peek(), item);
	}
	
	/**
	 * overloaded method for addNode
	 * @param currentroot
	 * @param item
	 */
	private Node addNode(Node currentRoot, int item) {
		
		if (currentRoot == null) {
			currentRoot = new Node(item);
			backTrack.add(currentRoot);
		} else {
			if (currentRoot.getLeftChild() == null) {
				addLeftChild(currentRoot, item);
			} else if (currentRoot.getRightChild() == null) {
				addRightChild(currentRoot, item);
			} else if (currentRoot.getLeftChild() != null && currentRoot.getRightChild() != null) {
				backTrack.remove();
				addNode(backTrack.peek(), item);
			}
		}
		
		return currentRoot;
	}
	
	/**
	 * method adds a new left child
	 * @param currentRoot
	 * @param item
	 */
	public void addLeftChild(Node currentRoot, int item) {
		System.out.println("Left Child Created !!");
		Node leftChild = new Node(item);
		currentRoot.setLeftChild(leftChild);
		backTrack.add(leftChild);
	}
	
	/**
	 * method adds a new right child
	 * @param currentRoot
	 * @param item
	 */
	public void addRightChild(Node currentRoot, int item) {
		System.out.println("Right Child Created !!");
		Node rightChild = new Node(item);
		currentRoot.setRightChild(rightChild);
		backTrack.add(rightChild);
	}
	
	/**
	 * method returns the inOrder Traversal
	 */
	public void inOrder() {
		inOrder(root);
	}
	
	/**
	 * overloaded method for inOrder
	 * @param rootNode
	 */
	private void inOrder(Node rootNode) {
		if (rootNode.getLeftChild() != null) {
			inOrder(rootNode.getLeftChild());	
		}

		System.out.print(rootNode.getData());
		System.out.print(",");
		
		if (rootNode.getRightChild() != null) {
			inOrder(rootNode.getRightChild());
		}
	}
	
	/**
	 * method returns the postOrder Traversal
	 */
	public void postOrder() {
		postOrder(root);
	}
	
	/**
	 * overloaded method for postOrder
	 * @param rootNode
	 */
	private void postOrder(Node rootNode) {
		if (rootNode.getLeftChild() != null) {
			postOrder(rootNode.getLeftChild());	
		}

		if (rootNode.getRightChild() != null) {
			postOrder(rootNode.getRightChild());
		}
		
		System.out.print(rootNode.getData());
		System.out.print(",");
	}
}
