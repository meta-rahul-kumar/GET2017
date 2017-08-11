/**
	LinkedList Class - contains function add and remove for singly linkedlist.
**/
function Linkedlist() {
	this.LinkedListLength = 0;
	this.LinkedListHead = null;

	/*
		Method - add function to add a node to front of linkedlist 
	*/
	this.add = function(value) {
		var node = new Node(value);
		var currentNode = this.LinkedListHead;

		// if linkedlist is empty
		if (!currentNode) {
			this.LinkedListHead = node;
			this.LinkedListLength++;

			return node;
		}

		// when linkedlist is not empty . iterating to the last node of linkedlist
		while (currentNode.nextNode) {
			currentNode = currentNode.nextNode;
		}

		currentNode.nextNode = node;
		this.LinkedListLength++;

		return node;
	};

	/*
		Method - remove function to remove a node from given position
	*/
	this.removeNode = function(position) {
		var currentNode = this.LinkedListHead,
        length = this.LinkedListLength,
        count = 0;
        beforeNodeToDelete = null,
        nodeToDelete = null,
        deletedNode = null;
 		
 		// when linkedlist is empty or given position is greater than length of the linkedlist
	    if (position < 0 || position > length) {
	        return false;
	    }
	 	
	 	// delete the first node of linkedlist
	    if (position === 1) {
	        this.LinkedListHead = currentNode.nextNode;
	        deletedNode = currentNode;
	        currentNode = null;
	        this.LinkedListLength--;
	         
	        return true;
	    }
	 	
	 	// delete the node which is not last or first node of linkedlist
	    while (count  < position - 1 ) {
	        beforeNodeToDelete = currentNode;
	        nodeToDelete = currentNode.nextNode;
			currentNode = currentNode.nextNode;
	        count++;
	    }
	 
	    beforeNodeToDelete.nextNode = nodeToDelete.nextNode;
	    deletedNode = nodeToDelete;
	    nodeToDelete = null;
	    this.LinkedListLength--;
	 
	    return true;
	}

	/*
		shows the all node of singly linkedlist
	*/
	this.show = function() {
		document.getElementById("singly-container-2").style.display = "block";
		document.getElementById("showlinks").innerHTML = "";
		var currentNode = this.LinkedListHead;

		while (currentNode) {
			if (currentNode == this.LinkedListHead) {
				document.getElementById("showlinks").innerHTML += "Head";
				document.getElementById("showlinks").innerHTML += "<div class='seperator'></div>";
			}
			document.getElementById("showlinks").innerHTML += "<div class='node'>"+ currentNode.value +"</div>";
			if (currentNode.nextNode != null) {
				document.getElementById("showlinks").innerHTML += "<div class='seperator'></div>";
			}
			currentNode = currentNode.nextNode;
		}

		document.getElementById("showlinks").innerHTML += "<div class='seperator'></div>";
		document.getElementById("showlinks").innerHTML += "Null";
	};

	/*
		search a node in singly linkedlist
	*/
	this.find = function(value) {
		var found = false;
		var position = 0;
		var currentNode = this.LinkedListHead;

		while (currentNode) {
			if (currentNode.value == value) {
				found = true;
				break;
			}
			position++;
			currentNode = currentNode.nextNode;
		}

		if (found) {
			alert("Element Found at Position : "+ position);
		}else{
			alert("Element Not Found");
		}

	};
	
}

/*
	creates a new node
*/
function Node(value){
	this.value = value;
	this.nextNode = null;
}


var linklist =new Linkedlist();  // creates a object of linkedlist

function findNode(){
	linklist.find(getValue("find-node"));
}

/*
	calls the add function of LinkedList Class.
*/
function addNode(){
	if((getValue("new-node")).match(/\d+/g) == null){
		document.getElementById("notification").style.display ="block";
		document.getElementById("node-add-msg").innerHTML = "Please Enter a valid node value";
	}else{
		linklist.add(getValue("new-node"));
		document.getElementById("notification").style.display ="block";
		document.getElementById("node-add-msg").innerHTML = "Node added with value " + getValue("new-node");
	}
	
};

/*
	calls the remove function of LinkedList Class.
*/
function removeNode(){
	if(linklist.removeNode(parseInt(getValue("delete-node")))){
		document.getElementById("notification2").style.display ="block";
		document.getElementById("node-add-msg2").innerHTML = "Node deleted";
	}else{
		document.getElementById("notification2").style.display ="block";
		document.getElementById("node-add-msg2").innerHTML = "Node not existss with this value";
	}	
}

/*
	calls the show function of LinkedList Class.
*/
function showLinks(){
	linklist.show();
};

/*
	function return the value of a input box with specific id
*/
function getValue(valueFor){
	return document.getElementById(valueFor).value;
}

/*
	dunction hides the notification
*/
function removeNotification(){
	document.getElementById("notification").style.display ="none";
}

/*
	dunction hides the notification
*/
function removeNotification2(){
	document.getElementById("notification2").style.display ="none";
}

