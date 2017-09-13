/**
	Stack Class have method for queue like push, pop, peek, clone, clear, show, contains.
**/
function Stack() {
	this.stack = [];
	this.maxLength = 5;
	this.length = 0;

	/*
		function push an element in Stack
	*/
	this.push = function(value) {
		if (this.length == this.maxLength) {
			// if stack is full
			alert("Stack Overflows");
		} else {
			// if stack is not full
			this.stack[this.length++] = value;
			alert("Element Pushed");
		}
	};

	/*
		function pop an element from queue
	*/
	this.pop = function() {
		var deletedElement = null;

		if (this.length  < 1) {
			// when stack is empty
			alert("Stack is Empty");
		} else {
			// when stack is not empty
			deletedElement = this.stack[this.length-1];
			this.stack.splice(this.length-1, 1);
			this.length--;
			alert("Element Deleted");
		}

		return deletedElement;
	};

	/*
		function returns the peek element of Stack 
	*/
	this.peek = function() {
		var result = null;

		if (this.length > 0) {
			result = this.stack[this.length - 1];	
		}

		return result;
	};

	/*
		function clear all the elements of Stack
	*/
	this.clear = function() {
		this.stack.splice(0, this.length);

		return this.stack;
	};

	/*
		function clones the stack and returns it.
	*/
	this.clone = function() {
		var stack = [];
		stack = this.stack.slice();
		return stack;
	};

	/*
		function shows the all elements of Stack.
	*/
	this.show = function() {
		return this.stack;
	};

	/*
		function search a specific element in Stack.
		if contains return true , otherwise false
	*/
	this.contains = function(value) {
		var exists = false;

		for (var i in this.stack) {
			if (this.stack[i] == value) {
				exists = true;
				break;
			}
		}

		return exists;
	};
}