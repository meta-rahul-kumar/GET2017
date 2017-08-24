package com.metacube.main;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.metacube.menu.ActionableMenuItem;
import com.metacube.menu.Menu;
import com.metacube.menu.MenuItem;
import com.metacube.resource.AddNode;
import com.metacube.resource.ExitProgram;
import com.metacube.resource.InOrder;
import com.metacube.resource.PreOrder;
import com.metacube.resource.PreOrderTreeTraversal;

/**
 * Main Class 
 * @author Rahul Kumar
 *
 */
public class MainClass {
	PreOrderTreeTraversal tree;
	
	/**
	 * sets the PreOrderTreeTraversal Object
	 */
	public void setObject() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int root = 0;
		
		do {
			System.out.println("Enter Root Node Value");
			try { 
				root = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Please Enter a Valid Number !!");
				sc.nextLine();
				continue;
			}
			break;
		} while (true);
		
		tree = new PreOrderTreeTraversal(root);
	}
	
	/**
	 * Method creates the menu
	 * @return
	 */
	public  static Menu createMenu(){
		Menu mainMenu=new Menu();
		List<MenuItem> subMenu=mainMenu.getSubMenu();
		
		MenuItem mi=new ActionableMenuItem(new AddNode());
		mi.setDisplayName("1. Add Node");
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new InOrder());
		mi.setDisplayName("2. In Order Traversal");
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new PreOrder());
		mi.setDisplayName("3. Pre Order Traversal");
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new ExitProgram());
		mi.setDisplayName("4. Exit");
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
				if (choice < 0) {
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
			((ActionableMenuItem)menuItem).triggerAction(tree);
		} else{
			displayAndPerformAction((Menu)menuItem);
		}
	}

	public static void main(String[] args) {
		Menu menu=createMenu();
		MainClass mainClass = new MainClass();
		mainClass.setObject();
		while(true){
		mainClass.displayAndPerformAction(menu);
		}
	}
}
