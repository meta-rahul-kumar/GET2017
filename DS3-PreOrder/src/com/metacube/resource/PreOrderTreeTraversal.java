package com.metacube.resource;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class provides the InOrder, PreOrder, and PostOrder Traversal Methods
 * @author Rahul Kumar
 *
 */
public class PreOrderTreeTraversal {
	Node root;
	Queue<Node> backTrack = new LinkedList<>();
	
	/**
	 * TreeTraversal class constructor
	 */
	public PreOrderTreeTraversal(){
		root = null;
		backTrack.add(root);
	}
	
	/**
	 * TreeTraversal class Parameterized constructor
	 */
	public PreOrderTreeTraversal(int item){
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
				addLeft(currentRoot, item);
			} else if (currentRoot.getRightChild() == null) {
				addRight(currentRoot, item);
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
	public void addLeft(Node currentRoot, int item) {
		System.out.println("Left Child Created !!");
		Node left = new Node(item);
		currentRoot.setLeftChild(left);
		backTrack.add(left);
	}
	
	/**
	 * method adds a new right child
	 * @param currentRoot
	 * @param item
	 */
	public void addRight(Node currentRoot, int item) {
		System.out.println("Right Child Created !!");
		Node right = new Node(item);
		currentRoot.setRightChild(right);
		backTrack.add(right);
	}
	
	/**
	 * method returns the preorder traversal
	 */
	public void preOrder(){
		preOrder(root);
	}
	
	/**
	 * overloaded method for preOrder
	 * @param rootNode
	 */
	private void preOrder(Node rootNode) {
		System.out.print(rootNode.getData());
		System.out.print(",");
		
		if (rootNode.getLeftChild() != null) {
			preOrder(rootNode.getLeftChild());	
		}
		if (rootNode.getRightChild() != null) {
			preOrder(rootNode.getRightChild());
		}
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
