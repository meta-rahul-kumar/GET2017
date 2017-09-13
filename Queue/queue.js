/**
	Queue Class have method for queue like enqueue, dequeue.
**/
function queue() {
	this.queue = [];
	this.maxLength = 5;
	this.length = 0;
	
	/*
		Enqueue function adds a element in queue.
	*/
	this.enqueue = function(value) {

		if (this.length + 1 > this.maxLength) {
			// when Queue is Full
			alert("Queue is Full");
		} else {
			// when queue is not full
			this.queue[this.length++] = value;
			alert("Element Inserted");
		}
	};

	/*
		dequeue function removes a element form queue.
	*/
	this.dequeue = function() {
		if (this.length < 1) {
			// when queue is empty
			alert("Queue is Empty");
		} else {
			// when queue is not empty
			this.queue.splice(0, 1);
			alert("Element Deleted");
			this.length--;
		}
	};

	/*
		function shows the queue elements
		Returns - queue array
	*/
	this.show = function() {
		return this.queue;
	};
}

var queueObj = new queue(); // queue object creation
