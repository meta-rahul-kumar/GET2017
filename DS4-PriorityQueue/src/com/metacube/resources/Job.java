package com.metacube.resources;

public class Job {
	int id;
	int priority;
	
	public Job() {
		// TODO Auto-generated constructor stub
	}
	
	Job(int id, int priority) {
		this.id = id;
		this.priority = priority;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public int getid() {
		return id;
	}
	
	public int getPriority() {
		return priority;
	}

	public int compareTo(Job job) {
		if (this.priority > job.getPriority()) {
			return 1;
		} else {
			return 0;
		}
	}
}
