/**
 * Main Class of Menu Based Calculator
 * 
 * @author Rahul Kumar
 *
 */


import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;


public class Main {

	/**
	 * method - createMenu
	 * creates Menu and Sub Menus
	 * @return
	 */
	public  static Menu createMenu(){
		System.out.println("Welcome to Menu Based Calculator");
		Menu mainMenu = new Menu();
		
		MenuItem mi = new ActionableMenuItem(new Util());
		List<MenuItem> subMenu = mainMenu.getSubMenu();
		mi = new Menu();
		mi.setDisplayName("1. Operation on Float type Operands");
		subMenu.add(mi);
		
		List<MenuItem> subFloatMenu = ((Menu) mi).getSubMenu();
        
		mi = new ActionableMenuItem(new FloatAddition());
        mi.setDisplayName("1. Addition");
        subFloatMenu.add(mi);
        
        mi = new ActionableMenuItem(new FloatSubtraction());
        mi.setDisplayName("2. Subtraction");
        subFloatMenu.add(mi);
        
        mi = new ActionableMenuItem(new FloatDivision());
        mi.setDisplayName("3. Division");
        subFloatMenu.add(mi);
        
        mi = new ActionableMenuItem(new FloatMultiplication());
        mi.setDisplayName("4. Multiply");
        subFloatMenu.add(mi);
        
        mi = new ActionableMenuItem(new FloatNegation());
        mi.setDisplayName("5. Negation");
        subFloatMenu.add(mi);
        
        mi = new ActionableMenuItem(new FloatModulas());
        mi.setDisplayName("6. Modulas");
        subFloatMenu.add(mi);
        
        mi = new ActionableMenuItem(new ExitProgram());
        mi.setDisplayName("7. Exit");
        subFloatMenu.add(mi);
        
		mi = new Menu();
		mi.setDisplayName("2. Operation on Integer type Operands");
		subMenu.add(mi);
		
		List<MenuItem> subIntegerMenu = ((Menu) mi).getSubMenu();
		
        mi = new ActionableMenuItem(new IntegerAddition());
        mi.setDisplayName("1. Addition");
        subIntegerMenu.add(mi);
        
        mi = new ActionableMenuItem(new IntegerSubtraction());
        mi.setDisplayName("2. Subtraction");
        subIntegerMenu.add(mi);
        
        mi = new ActionableMenuItem(new IntegerDivision());
        mi.setDisplayName("3. Division");
        subIntegerMenu.add(mi);

        mi = new ActionableMenuItem(new IntegerMultiplication());
        mi.setDisplayName("4. Multiply");
        subIntegerMenu.add(mi);
        
        mi = new ActionableMenuItem(new IntegerNegation());
        mi.setDisplayName("5. Negation");
        subIntegerMenu.add(mi);
        
        mi = new ActionableMenuItem(new IntegerModulas());
        mi.setDisplayName("6. Modulas");
        subIntegerMenu.add(mi);
        
        mi = new ActionableMenuItem(new ExitProgram());
        mi.setDisplayName("7. Exit");
        subIntegerMenu.add(mi);
        
		
		mi = new ActionableMenuItem(new ExitProgram());
		mi.setDisplayName("3.Exit");
		subMenu.add(mi);
		
		return mainMenu;
		
	}
	
	/**
	 * method - display
	 * Display Menu
	 * @param menu
	 */
	public static void display(Menu menu){
		
		Iterator<MenuItem> itr = menu.getSubMenu().iterator();
		
		while(itr.hasNext()){
			System.out.println(itr.next().getDisplayName());
		}
		
		
	}
	
	/**
	 * method - getInput
	 * takes an choice for menu and sub menus
	 * @return
	 */
	public static int getInput(){
		int choice = 0;
		while(true) {
		    try
		    {
		    	System.out.println("Enter Your Choice");
				choice = Util.sc.nextInt();
				break;
		    } 
		    catch (InputMismatchException y)
		    {
			    System.out.println("You must enter a number.");
			    Util.sc.nextLine();

		    }  
		}  

		return choice-1;
	}
	
	/**
	 * method - displayAndPerformAction
	 * method display and performs the action on selected menu item
	 * @param menu
	 */
	public static void displayAndPerformAction(Menu menu){
		
		display(menu);
		
		int choice = getInput();
		
		MenuItem menuItem = menu.getSelection(choice);
	
		
		if(menuItem == null){
			displayAndPerformAction(menu);
		}
		else if(menuItem instanceof ActionableMenuItem) {
			
			((ActionableMenuItem)menuItem).triggerAction();
			
		}
		else{
			displayAndPerformAction((Menu)menuItem);
		}
	}
	
	public static void main(String args[]){
		Menu menu = createMenu();
		
		while (true) {
			displayAndPerformAction(menu);
		}
		
		
	}
}
