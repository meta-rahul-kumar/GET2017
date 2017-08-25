package com.metacube.facade;
import java.util.HashMap;
import java.util.Scanner;
import com.metacube.dao.CounselingDAO;
import com.metacube.dao.StudentDAO;
import com.metacube.models.Student;
import com.metacube.queue.Queue;

/**
 * CounselingFacade performs the operation for Counseling
 * @author Rahul Kumar
 *
 */
public class CounselingFacade {
	
	/**
	 * adds student ranks in Queue.
	 */
	public void addStudentsRanksInQueue() {
		HashMap<Integer,Student> students = StudentDAO.getInstance().getAllStudents();
		
		for (int key : students.keySet()) {
			CounselingDAO.getInstance().addStudentRankToQueue(students.get(key));
		}
	}

	/**
	 * sorts the queue in ascending order of ranks
	 */
	public void sortRanksInAscendingOrder() {
		CounselingDAO.getInstance().sortRanksInAscendingOrder();
	}

	/**
	 * allocate college for students
	 */
	@SuppressWarnings("resource")
	public void allocateCollegeToStudents() {
		Queue sortedRanks = CounselingDAO.getInstance().getSortedRanks();
		CollegeFacade collegeFacade = new CollegeFacade();
		Scanner sc = new Scanner(System.in);
		int requiredCollegeId = 0;
		int totalSeats = collegeFacade.getTotalSeats();
		
		for (int i = 0; i< totalSeats ; i++) {
			Student requiredStudent = StudentDAO.getInstance().getStudentByRank(sortedRanks.get(i));
			
			System.out.println("All Colleges : ");
			System.out.println("Code\tCollege Name\tSeat Available");
			System.out.println("----\t------------\t------------");
			collegeFacade.getAllColleges();
			
			while (true) {
				System.out.println("Enter College ID  " +  requiredStudent.getStudentName());
				requiredCollegeId = sc.nextInt();
				
				if (collegeFacade.checkCollegeForEmptySeat(requiredCollegeId)) { 
					// college have empty seats, college will be allocate to the student
					allocateCollegeForStudentWithID(requiredStudent, requiredCollegeId);
					break;
				} else {
					// college don't have empty seats, college will not be allocate to the student
					System.out.println("Sorry College don't have any Empty Seats.");
				}
			
			}
		}
		
	}

	/**
	 * Allocate College to Student
	 * @param requiredStudent
	 * @param allocatingCollegeId
	 */
	private void allocateCollegeForStudentWithID(Student requiredStudent, int allocatingCollegeId) {
		requiredStudent.setStudentAllotedCollegeID(allocatingCollegeId);
		CollegeFacade collegeFacade = new CollegeFacade();
		
		collegeFacade.decrementSeatsAfterSeatAllocation(allocatingCollegeId);
		
	}

	/**
	 * shows the allocated college seats 
	 */
	public void showAllocatedSeats() {
		StudentFacade studentFacade = new StudentFacade();
		studentFacade.showAllocatedSeats();
		
	}
}
