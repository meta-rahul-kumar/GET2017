package com.metacube.main;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.metacube.menu.ActionableMenuItem;
import com.metacube.menu.Menu;
import com.metacube.menu.MenuItem;
import com.metacube.resources.QueueProgram;

/**
 * Main Class
 * @author Rahul Kumar
 *
 */
public class MainClass {
	QueueProgram queue = new QueueProgram();
	
	/**
	 * sets the PreOrderTreeTraversal Object
	 */
	public void welcomeMessage() {
		System.out.println("Queue Program with best Collection");
		System.out.println("------------------------------------------");
	}
	
	/**
	 * Method creates the menu
	 * @return
	 */
	public  static Menu createMenu(){
		Menu mainMenu=new Menu();
		List<MenuItem> subMenu=mainMenu.getSubMenu();
		
		MenuItem mi=new ActionableMenuItem(new Enqueue());
		mi.setDisplayName("1. Enqueue");
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new Dequeue());
		mi.setDisplayName("2. Dequeue");
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new Peek());
		mi.setDisplayName("3. Peek");
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new Poll());
		mi.setDisplayName("4. Poll");
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new Clear());
		mi.setDisplayName("5. Clear");
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new IsEmpty());
		mi.setDisplayName("6. Check for Empty");
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new Size());
		mi.setDisplayName("7. Size");
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new Contains());
		mi.setDisplayName("8. Contains");
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new Show());
		mi.setDisplayName("9. Show Queue");
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
				if (choice > 9 || choice < 1) {
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
			((ActionableMenuItem)menuItem).triggerAction(queue);
		} else{
			displayAndPerformAction((Menu)menuItem);
		}
	}

	public static void main(String[] args) {
		Menu menu=createMenu();
		MainClass mainClass = new MainClass();
		mainClass.welcomeMessage();
		while(true){
		mainClass.displayAndPerformAction(menu);
		}
	}
}
