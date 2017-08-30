package com.metacube.resources;

public class PriorityQueue {
	Job[] jobs;
	int queueSize;
	int maxSize;
	
	public PriorityQueue(int totalJobs) {
		jobs = new Job[totalJobs];
		maxSize = totalJobs;
		queueSize = 0;
	}

	public int getParent(int position) {
		return (position)/ 2;
	}
	
	public int getLeftChild(int position) {
		return 2 * position;
	}
	
	public int getRightChild(int position) {
		return (2 * position ) + 1;
	}
	
	public boolean isLeafNode(int position) {
		if (position >= (queueSize / 2) &&  position <= queueSize) {
			return true;
		}
		
		return false;
	}
	
	public void swap (int firstPosition, int secondPosition) {
		Job temp = jobs[firstPosition];
		jobs[firstPosition] = jobs[secondPosition];
		jobs[secondPosition] = temp;
	}
	
	public void maxHeapify(int position) {
		int largest;
		
		if (!isLeafNode(position)) {
			if (jobs[getLeftChild(position)].compareTo(jobs[position]) > 0) {
				largest = getLeftChild(position);
			} else {
				largest = position;
			}
			
			if (jobs[getRightChild(position)].compareTo(jobs[position]) > 0) {
				largest = getRightChild(position);
			} else {
				largest = position;
			}
			
			if (largest != position) {
				swap(largest, position);
				maxHeapify(largest);
			}
		}
	}
	
	public void maxHeap() {
		for (int i = queueSize / 2; i > 0 ; i--) {
			maxHeapify(i);
		}
	}
	
	public void addJob(int id, int priority) {
		Job job = new Job(id, priority);
		jobs[queueSize++] = job;
		
		int current = queueSize - 1;
		while (jobs[current].compareTo(jobs[getParent(current)]) > 0) {
			swap(current, getParent(current));
			current = getParent(current);
		}
	}
	
	public Job remove() {
		Job removeJob;
		removeJob = jobs[0];
		jobs[0] = jobs[queueSize-1];
		maxHeapify(0);
		
		return removeJob;
	}
	
	public  int size() {
		return queueSize;
	}
}
