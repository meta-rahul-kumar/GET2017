package com.metacube.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.metacube.helper.QueriesHelper;

public class View {
	
	public int getChoice() {
		boolean status = true;
		int choice = 0;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		while(status) {
			
			System.out.println("Enter Choice");
			while (!sc.hasNextInt()) {
				System.out.println("Please Enter a Valid Number");
				sc.nextLine();
			}
			choice = sc.nextInt();
			
			if(choice < 1 || choice > 3) {
				System.out.println("Please enter a valid choice");
			} else {
				status = false;
			}
		}
		
		return choice;
	}
	
	public void displayMenu() throws SQLException {
		QueriesHelper queriesHelper = new QueriesHelper();
		int choice;
		
		while(true) {
			System.out.println("Welcome to Library Information System");
			System.out.println("1. Get All Book Title of an Author");
			System.out.println("2. Check book issued by member on not");
			System.out.println("3. Delete All Books which is not issued from 1 Year");
			choice = getChoice();
			
			switch (choice) {
			case 1: queriesHelper.getBooksDataByAuthorName();
			break;
			case 2: queriesHelper.checkIssueStatus();
			break;
			case 3: queriesHelper.deleteBooks();
			}
		}
	}
}
