/**
	DoublyLinkedList Class - contains function add and remove.
**/
function DoublyLinkedList() {
	this.length = 0;
	this.head = null;
	this.tail = null;

	/*
		Method - add function to add a node to front of linkedlist 
	*/
	this.add = function(value) {

		var newNode = new Node(value);

		// If list is empty, point head node to new node.
		if (this.head == null) {
			this.head = newNode;
			this.length++;

		}
		else{
		// Otherwise, traverse to the end of list
		var iterator = this.head;
		while (iterator.next) {
			iterator = iterator.next;
		}

		// Point the last node to new node.
		iterator.next = newNode;
		newNode.back = iterator;
		this.length++;
		}

		return newNode;
	};

	/*
		Method - remove function to remove a node from given position
	*/
	this.remove = function(position) {
		var currentNode = this.head;
	    var length = this.length;
	    var count = 1;
	    var previousNode = null;
	    var nextNode = null;
	    var nodeToDelete = null;
	    var deletedNode = null;
	 	
	 	// when linkedlist is empty or given position is greater than length of the linkedlist
	    if (length === 0 || position < 1 || position > length) {
	        return null;
	    }
	 	
	 	// delete the first node of linkedlist
	    if (position === 1) {
	        this.head = currentNode.next;
	 
	        if (this.head != null) {
	            this.head.back = null;
	        } else {
	            this.tail = null;
	        }
	 
	    } else if (position === this.length) {
	    	// delete the last node of linkedlist
	        this.tail = this.tail.back;
	        this.tail.next = null;
	    } else {
	    	// delete the node which is not last or first node of linkedlist
	        while (count < position) {
	            currentNode = currentNode.next;
	            count++;
	        }
	 
	        previousNode = currentNode.back;
	        nodeToDelete = currentNode;
	        nextNode = currentNode.next;
	 
	        previousNode.next = nextNode;
	        nextNode.back = previousNode;
	        deletedNode = nodeToDelete;
	        nodeToDelete = null;
	    }
	 
	    this.length--;
	 
	    return deletedNode;
	};
}

/*
	creates a new node
*/
function Node(value) {
	this.value = value;
	this.next = null;
	this.back = null;
}
