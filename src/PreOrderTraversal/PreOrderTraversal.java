package PreOrderTraversal;

import java.util.LinkedList;
import java.util.Queue;

public class PreOrderTraversal {
	Node root;
	Queue<Node> backTrack = new LinkedList<>();
	
	PreOrderTraversal(){
		root = null;
	}
	
	PreOrderTraversal(int item){
		root = new Node(item);
		backTrack.add(root);
	}
	
	public void addNode(int item) {
		addNode(root, item);
	}
	private void addNode(Node currentroot, int item) {
		System.out.println("I am Here New Item : " + item);
		if (currentroot == null) {
			currentroot = new Node(item);
			backTrack.add(currentroot);
		} else {
			if (currentroot.getLeftChild() == null) {
				addLeft(currentroot, item);
			} else if (currentroot.getRightChild() == null) {
				addRight(currentroot, item);
			} else if (currentroot.getLeftChild() != null && currentroot.getRightChild() != null) {
				backTrack.remove();
				addNode(backTrack.peek(), item);
			}
		}
	}
	
	public void addLeft(Node currentRoot, int item) {
		System.out.println("Left Child Created !!");
		Node left = new Node(item);
		currentRoot.setLeftChild(left);
		backTrack.add(currentRoot);
	}
	
	public void addRight(Node currentRoot, int item) {
		System.out.println("Right Child Created !!");
		Node right = new Node(item);
		currentRoot.setRightChild(right);
		backTrack.add(currentRoot);
	}
	
	public void preOrder(){
		preOrder(root);
	}
	
	private void preOrder(Node rootNode) {
		System.out.print(rootNode.getData());
		
		if (rootNode.getLeftChild() != null) {
			preOrder(rootNode.getLeftChild());	
		}
		if (rootNode.getRightChild() != null) {
			preOrder(rootNode.getRightChild());
		}
		
	}
	
	public void inOrder() {
		inOrder(root);
	}
	
	private void inOrder(Node rootNode) {
		if (rootNode.getLeftChild() != null) {
			preOrder(rootNode.getLeftChild());	
		}

		System.out.print(rootNode.getData());
		
		if (rootNode.getRightChild() != null) {
			preOrder(rootNode.getRightChild());
		}
		
	}
	
	public void postOrder() {
		postOrder(root);
	}
	
	private void postOrder(Node rootNode) {
		if (rootNode.getLeftChild() != null) {
			preOrder(rootNode.getLeftChild());	
		}

		if (rootNode.getRightChild() != null) {
			preOrder(rootNode.getRightChild());
		}
		
		System.out.print(rootNode.getData());
		
	}

	public int getLeftData() {
		return root.getLeftChild().getData();
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		PreOrderTraversal orderTraversal = new PreOrderTraversal(5);
		orderTraversal.addNode(7);
		orderTraversal.addNode(6);
		orderTraversal.addNode(8);
		orderTraversal.addNode(9);
		orderTraversal.addNode(10);
		System.out.println("InOrder Traversal : ");
		orderTraversal.inOrder();
		System.out.println("PostOrder Traversal : ");
		orderTraversal.postOrder();
		System.out.println("PreOrder Traversal : ");
		orderTraversal.preOrder();
	}
}
