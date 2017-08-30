package com.metacube.views;

import com.metacube.resources.Job;
import com.metacube.resources.PriorityQueue;
import com.metacube.util.Util;

/**
 * Main Class
 * @author Rahul Kumar
 *
 */
public class Main {
	
	public static void main(String[] args) {
		int totalJobs = Util.getTotalJobs();
		PriorityQueue priorityQueue = new PriorityQueue(totalJobs);
		Job job = new Job();
		
		for (int i = 0; i < totalJobs; i++) {
			int jobId = Util.getJobId(priorityQueue, i+1);
			int jobPriority = Util.getJobPriority(i+1);
			priorityQueue.addJob(jobId, jobPriority);
		}
		
		System.out.println("Job ID\tJob Priority");
		System.out.println("--------------------");
		for (int i = 0 ; i < totalJobs; i++) {
			job = priorityQueue.remove();
			System.out.println( job.getid() + "\t" + job.getPriority());
		}
		//priorityQueue.showQueue();
	}
}
