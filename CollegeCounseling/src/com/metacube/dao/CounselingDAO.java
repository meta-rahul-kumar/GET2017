package com.metacube.dao;
import com.metacube.models.College;
import com.metacube.models.Student;
import com.metacube.queue.Queue;

/**
 * CounselingDAO performs operation for Counseling and it is an singleton class.
 * @author Rahul Kumar
 *
 */
public class CounselingDAO implements BaseDAO<College>{
	private static CounselingDAO counselingDAO;
	Queue queue = new Queue();
	
	/**
	 * returns the instance of CounselingDAO
	 * @return
	 */
	public static CounselingDAO getInstance() {
		if (counselingDAO == null) {
			synchronized (CounselingDAO.class) {
				if (counselingDAO == null) {
					counselingDAO = new CounselingDAO();
				}
			}
		}
		
		return counselingDAO;
	}
	
	/**
	 * adds student rank to Queue
	 * @param student
	 */
	public void addStudentRankToQueue(Student student) {
		queue.enqueue(student.getStudentRank());
	}
	
	/**
	 * sort the queue which contains the ranks of students
	 */
	public void sortRanksInAscendingOrder() {
		queue.sort();
	}
	
	/**
	 * returns the sorted Queue
	 * @return
	 */
	public Queue getSortedRanks() {
		return queue;
	}
}
