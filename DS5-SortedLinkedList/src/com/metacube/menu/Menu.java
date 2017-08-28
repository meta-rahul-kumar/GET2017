package com.metacube.menu;
import java.util.ArrayList;
import java.util.List;

/**
 * Menu Class
 * @author Rahul Kumar
 *
 */
public class Menu extends MenuItem{
	
	private List<MenuItem> subMenu=new ArrayList<MenuItem>();

	public List<MenuItem> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(List<MenuItem> list) {
		this.subMenu= list;
	}
	
	public MenuItem getSelection(int choice){
		if(choice>=subMenu.size())return null;
		
		return subMenu.get(choice);
	}

	
}
