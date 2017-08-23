package com.metacube.resource;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class provides the Mirror Test For Two Trees
 * @author Rahul Kumar
 *
 */
public class MirrorTrees {
	Node root;
	Queue<Node> backTrack = new LinkedList<>();
	
	/**
	 * method returns the root of Tree
	 */
	public Node getRoot() {
		return root;
	}
	/**
	 * TreeTraversal class constructor
	 */
	public MirrorTrees(){
		root = null;
		backTrack.add(root);
	}
	
	/**
	 * TreeTraversal class Parameterized constructor
	 */
	public MirrorTrees(int item){
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
		Node right = new Node(item);
		currentRoot.setRightChild(right);
		backTrack.add(right);
	}
	
	/**
	 * function checks that two tress are mirror or not
	 * @param firstRoot
	 * @param secondRoot
	 * @return
	 */
	public boolean checkMirror(Node firstRoot, Node secondRoot) {
		
		if (firstRoot == null && secondRoot == null) {
			return true;
		}
		
		if (firstRoot == null && secondRoot == null) {
			return false;
		}

		return (firstRoot.getData() == secondRoot.getData() &&
	            checkMirror(firstRoot.getLeftChild(), secondRoot.getRightChild()) &&
	            checkMirror(firstRoot.getRightChild(), secondRoot.getLeftChild()));
	}
	
	public static void main(String[] args) {
		MirrorTrees mirrorTest = new MirrorTrees(5); // notice that root node is 5 for first Tree
		MirrorTrees mirrorTest2 = new MirrorTrees(5); // notice that root node is 5 for second Tree
		
		mirrorTest.addNode(1);
		mirrorTest.addNode(2);
		mirrorTest.addNode(3);
		mirrorTest.addNode(4);
		mirrorTest.addNode(6);
		mirrorTest.addNode(7);
		
		mirrorTest2.addNode(2);
		mirrorTest2.addNode(1);
		mirrorTest2.addNode(7);
		mirrorTest2.addNode(6);
		mirrorTest2.addNode(4);
		mirrorTest2.addNode(3);
		
		if (mirrorTest.checkMirror(mirrorTest.getRoot(), mirrorTest2.getRoot())) {
			System.out.println("Trees are Mirrors");
		} else { 
			System.out.println("Trees are Not Mirrors");
		}
	}
}
