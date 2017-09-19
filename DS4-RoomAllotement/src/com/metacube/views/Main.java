package com.metacube.views;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.metacube.menu.ActionableMenuItem;
import com.metacube.menu.Menu;
import com.metacube.menu.MenuItem;
import com.metacube.utils.Util;

/**
 * Main Class
 * @author Rahul Kumar
 *
 */
public class Main {
	
	/**
	 * sets the PreOrderTreeTraversal Object
	 */
	public void welcomeMessage() {
		System.out.println("The Leela Palace Hotel Management Portal");
		System.out.println("------------------------------------------");
		int noOfRooms = Util.getRooms();
		Input input = new Input();
		
		input.addRooms(noOfRooms);
	}
	
	/**
	 * Method creates the menu
	 * @return
	 */
	public  static Menu createMenu(){
		Menu mainMenu=new Menu();
		List<MenuItem> subMenu=mainMenu.getSubMenu();
		
		MenuItem mi=new ActionableMenuItem(new AddGuest());
		mi.setDisplayName("1. Add Guest");
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new ViewGuests());
		mi.setDisplayName("2. View Guests");
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new AllotRooms());
		mi.setDisplayName("3. Allot Rooms");
		subMenu.add(mi);
		
		return mainMenu;
		
	}
	
	/**
	 * method displays the menu
	 * @param menu
	 */
	public static void display(Menu menu){
		
		Iterator<MenuItem> itr=menu.getSubMenu().iterator();
		
		while(itr.hasNext()){
			System.out.println(itr.next().getDisplayName());
		}
	}
	
	/**
	 * method takes the input for menu choice
	 * @param size
	 * @return
	 */
	public static int getInput(int size){
		@SuppressWarnings("resource")
		Scanner scan= new Scanner(System.in);
		int choice = 0;
		
		do {
			System.out.println("Enter Your Choice");
			try { 
				choice = scan.nextInt();
				if (choice > 3 || choice < 1) {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Please Enter a Valid Choice !!");
				scan.nextLine();
				continue;
			}
			break;
		} while (true);
		
		return choice-1;
	}
	
	/**
	 * method performs and displays the actions
	 * @param menu
	 */
	public void displayAndPerformAction(Menu menu) {	
		display(menu);
		int choice=getInput(menu.getSubMenu().size());
		MenuItem menuItem= menu.getSelection(choice);
		
		if(menuItem==null){
			displayAndPerformAction(menu);
		} else if(menuItem instanceof ActionableMenuItem){
			((ActionableMenuItem)menuItem).triggerAction();
		} else{
			displayAndPerformAction((Menu)menuItem);
		}
	}

	public static void main(String[] args) {
		Menu menu=createMenu();
		Main mainClass = new Main();
		mainClass.welcomeMessage();
		while(true){
		mainClass.displayAndPerformAction(menu);
		}
	}
}
