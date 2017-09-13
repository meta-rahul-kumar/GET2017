package com.metacube.view;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.metacube.helper.QueriesHelper;

/**
 * View Class
 * 
 * @author Rahul Kumar
 *
 */
public class View {

	/**
	 * Gets the Choice from the User
	 * 
	 * @return
	 */
	public int getChoice() {
		boolean status = true;
		boolean insideStatus = false;
		int choice = 0;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		while (status) {
			insideStatus = false;
			System.out.println("Enter Choice");
			try {
				choice = sc.nextInt();
			} catch (InputMismatchException ime) {
				System.out.println("Please enter a valid choice");
				sc.nextLine();
				insideStatus = true;
			}
			
			if ((choice < 1 || choice > 3) && insideStatus == false) {
				System.out.println("Please enter a valid choice");
			} else if ((choice < 1 || choice > 3) && insideStatus == true){
				
			} else {
				status = false;
			}
		}

		return choice;
	}

	/**
	 * Displays the menu
	 * 
	 * @throws SQLException
	 */
	public void displayMenu() throws SQLException {
		QueriesHelper queriesHelper = new QueriesHelper();
		int choice;

		while (true) {
			System.out.println("Welcome to Library Information System");
			System.out.println("1. Get All Book Title of an Author");
			System.out.println("2. Check if book is issued by a member or not");
			System.out.println("3. Delete All Books which is not issued from 1 Year");
			choice = getChoice();

			switch (choice) {
			case 1:
				queriesHelper.getBooksTitlesByAuthorName();
				break;
			case 2:
				queriesHelper.isBookIssued();
				break;
			case 3:
				queriesHelper.deleteBooks();
			}
		}
	}
}
