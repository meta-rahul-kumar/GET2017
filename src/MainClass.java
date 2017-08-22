import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MainClass {
	public  static Menu createMenu(){
		Menu mainMenu=new Menu();
		List<MenuItem> subMenu=mainMenu.getSubMenu();
		
		MenuItem mi=new ActionableMenuItem(new AddElement());
		mi.setDisplayName("1. Add Element");
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new AddElementWithPosition());
		mi.setDisplayName("2. Add Element on Position");
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new GetElement());
		mi.setDisplayName("3. Get Element From Position");
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new IndexOfElement());
		mi.setDisplayName("4. Get Index Of Element");
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new RemoveFromLocation());
		mi.setDisplayName("5. Remove Item From Location");
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new Remove());
		mi.setDisplayName("6. Remove Item");
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new ClearList());
		mi.setDisplayName("7. Clear List");
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new ReverseList());
		mi.setDisplayName("8. Reverse the List");
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new SortList());
		mi.setDisplayName("9. Sort the List");
		subMenu.add(mi);
		
		return mainMenu;
		
	}
	
	public static void display(Menu menu){
		
		Iterator<MenuItem> itr=menu.getSubMenu().iterator();
		
		while(itr.hasNext()){
			System.out.println(itr.next().getDisplayName());
		}
	}
	
	public static int getInput(int size){
		Scanner scan= new Scanner(System.in);
		int choice = 0;
		choice=scan.nextInt();
		return choice-1;
	}
	
	public static void displayAndPerformAction(Menu menu){
		
		display(menu);
		
		int choice=getInput(menu.getSubMenu().size());
		
		
		MenuItem menuItem= menu.getSelection(choice);
		
		
		
		if(menuItem==null){
			displayAndPerformAction(menu);
			
		} else if(menuItem instanceof ActionableMenuItem){
			((ActionableMenuItem)menuItem).triggerAction();
			
		}
		else{
			displayAndPerformAction((Menu)menuItem);
		}
	}

	public static void main(String[] args) {
		Menu menu=createMenu();
		
		while(true){
		displayAndPerformAction(menu);
		}
	}
}
