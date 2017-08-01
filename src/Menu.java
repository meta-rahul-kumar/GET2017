/**
 * Main Class of Menu Based Calculator
 * 
 * @author Rahul Kumar
 *
 */


import java.util.ArrayList;
import java.util.List;


public class Menu extends MenuItem{
	
	private List<MenuItem> subMenu=new ArrayList<MenuItem>();
	
	/**
	 * method returns the Menu Items
	 * @return
	 */
	public List<MenuItem> getSubMenu() {
		return subMenu;
	}

	/**
	 * method make the submenu and menu from list
	 * @param list
	 */
	public void setSubMenu(List<MenuItem> list) {
		this.subMenu= list;
	}
	
	/**
	 * method select the menu item
	 * @param choice
	 * @return
	 */
	public MenuItem getSelection(int choice){
		if(choice>=subMenu.size())return null;
		
		return subMenu.get(choice);
	}

	
}
