package com.metacube.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.metacube.helper.QueriesHelper;
import com.metacube.model.Title;

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
				Scanner sc = new Scanner(System.in);
				String authorName = "";
				System.out.println("Enter Author Name");
				authorName = sc.nextLine();
				
				ResultSet result = queriesHelper.getBooksTitlesByAuthorName(authorName);
				showBookTitlesResult(result);
				break;
			case 2:
				Scanner sc1 = new Scanner(System.in);
				String bookName = "";
				int memberId;

				System.out.println("Enter Book Name");
				bookName = sc1.nextLine();

				System.out.println("Enter Member ID");
				while (!sc1.hasNextInt()) {
					System.out.println("Please Enter a Valid Number");
				}
				memberId = sc1.nextInt();
				ResultSet resultSet = queriesHelper.isBookIssued(bookName, memberId);
				showBookIssueStatus(resultSet);
				break;
			case 3:
				System.out.println("--------------------------");
				System.out.println("Total Books Deleted : " + queriesHelper.deleteBooks());
				System.out.println("--------------------------");
			}
		}
	}

	/**
	 * Shows the status if book is issued by member or not
	 * @param resultSet
	 * @throws SQLException
	 */
	private void showBookIssueStatus(ResultSet resultSet) throws SQLException {
		int size = 0;
		if (resultSet != null) {
			resultSet.beforeFirst();
			resultSet.last();
			size = resultSet.getRow();
		}
		
		if (size > 0) {
			System.out.println("---------------------------------");
			System.out.println("Yes Book is Issued By " + resultSet.getString(1));
			System.out.println("---------------------------------");
		} else {
			System.out.println("---------------------------------------------------------");
			System.out.println("Book is not issued by the member with specified member id");
			System.out.println("---------------------------------------------------------");
		}
	}

	/**
	 * shows the books titles which are written by specified author
	 * @param result
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
	private void showBookTitlesResult(ResultSet result) throws NumberFormatException, SQLException {
		ArrayList<Title> resultTitles = new ArrayList<>();
		while (result.next()) {
			Title title = new Title();
			title.setTitleId(Integer.parseInt(result.getString(1)));
			title.setTitleName(result.getString(2));
			resultTitles.add(title);
		}

		if (resultTitles.size() > 0) {
			System.out.println("------------------------------------------------");
			System.out.println("Title ID\tTitle");
			System.out.println("------------------------------------------------");
			for (Title key : resultTitles) {
				System.out.println(key.getTitleId() + "\t\t" + key.getTitleName());
			}
	
			System.out.println("------------------------------------------------"); 
		} else {
			System.out.println("------------------------------------------------");
			System.out.println("No Book is written by the specified Author.");
			System.out.println("------------------------------------------------");
		}
	}
}
