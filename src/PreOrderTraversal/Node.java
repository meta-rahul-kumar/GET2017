package PreOrderTraversal;

class Node {
	int data;
	Node left;
	Node right;
	
	public Node() {
		this(0);
	}
	
	public Node(int item) {
		data = item;
		left = null;
		right = null;
	}
	
	public int getData(){
		return data;
	}
	
	public Node getLeftChild(){
		return left;
	}
	
	public Node getRightChild(){
		return right;
	}
	
	public void setLeftChild(Node child) {
		left = child;
	}
	
	public void setRightChild(Node child) {
		right = child;
	}
}