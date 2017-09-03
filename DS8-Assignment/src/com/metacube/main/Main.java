package com.metacube.main;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.metacube.menu.ActionableMenuItem;
import com.metacube.menu.Menu;
import com.metacube.menu.MenuItem;

public class Main {
	int[] inputArray;

	/**
	 * sets the PreOrderTreeTraversal Object
	 */
	public void welcomeMessage() {
		System.out.println("Welcome to Sorting System");
		System.out.println("------------------------------------------");
		int number = Input.getNumber();
		inputArray = new int[number]; // make input array of size [number]
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i] = Input.getArrayElement(i+1); // takes input array input
		}
	}

	/**
	 * Method creates the menu
	 * 
	 * @return
	 */
	public static Menu createMenu() {
		Menu mainMenu = new Menu();
		List<MenuItem> subMenu = mainMenu.getSubMenu();

		MenuItem mi = new ActionableMenuItem(new ComparisionSorting());
		mi.setDisplayName("1. Comparison Sorting");
		subMenu.add(mi);

		mi = new ActionableMenuItem(new LinearSorting());
		mi.setDisplayName("2. Linear Sorting");
		subMenu.add(mi);

		return mainMenu;

	}

	/**
	 * method displays the menu
	 * 
	 * @param menu
	 */
	public static void display(Menu menu) {

		Iterator<MenuItem> itr = menu.getSubMenu().iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next().getDisplayName());
		}
	}

	/**
	 * method takes the input for menu choice
	 * 
	 * @param size
	 * @return
	 */
	public static int getInput(int size) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice = 0;

		do {
			System.out.println("Enter Your Choice");
			try {
				choice = scan.nextInt();
				if (choice > 2 || choice < 1) {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Please Enter a Valid Choice !!");
				scan.nextLine();
				continue;
			}
			break;
		} while (true);

		return choice - 1;
	}

	/**
	 * method performs and displays the actions
	 * 
	 * @param menu
	 */
	public void displayAndPerformAction(Menu menu) {
		display(menu); // displays the menu
		int choice = getInput(menu.getSubMenu().size()); // get the choice from user
		MenuItem menuItem = menu.getSelection(choice); // selects the appropriate menu item

		if (menuItem == null) {
			displayAndPerformAction(menu);
		} else if (menuItem instanceof ActionableMenuItem) {
			((ActionableMenuItem) menuItem).triggerAction(inputArray);
		} else {
			displayAndPerformAction((Menu) menuItem);
		}
	}

	public static void main(String[] args) {
		Menu menu = createMenu();
		Main mainClass = new Main();
		mainClass.welcomeMessage();
		while (true) {
			mainClass.displayAndPerformAction(menu);
		}
	}
}
