package com.metacube.main;
/**
 * Class is an abstract class.
 * @author Rahul Kumar
 *
 */
public abstract class MenuItem {
	private String displayName;

	/**
	 * method return the Menu Name
	 * @return
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * method sets the menu display name
	 * @param displayName
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	

}
