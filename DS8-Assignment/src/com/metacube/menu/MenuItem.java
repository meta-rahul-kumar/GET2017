package com.metacube.menu;

/**
 * Menu Item Class is an Abstract Class
 * 
 * @author Rahul Kumar
 *
 */
public abstract class MenuItem {
	private String displayName;

	/**
	 * returns the Menu Item Name
	 * 
	 * @return
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Sets the menu item display name
	 * 
	 * @param displayName
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}
