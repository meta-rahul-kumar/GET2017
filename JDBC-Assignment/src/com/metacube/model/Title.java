package com.metacube.model;

/**
 * Title is a Model Class which have getter and setter methods
 * 
 * @author Rahul Kumar
 *
 */
public class Title {
	private int titleId;
	private String titleName;

	/**
	 * return the titleID
	 * 
	 * @return
	 */
	public int getTitleId() {
		return titleId;
	}

	/**
	 * sets the title id
	 * 
	 * @param titleId
	 */
	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}

	/**
	 * return the title name
	 * 
	 * @return
	 */
	public String getTitleName() {
		return titleName;
	}

	/**
	 * sets the title name
	 * 
	 * @param titleName
	 */
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
}
