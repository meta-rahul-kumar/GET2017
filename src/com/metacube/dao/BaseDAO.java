package com.metacube.dao;

/**
 * 
 * BaseDAO is an Interface for all typeDAO
 * @author Rahul Kumar
 *
 */
public interface BaseDAO {
	
	/**
	 * adds to Database or file
	 * @return
	 */
	public boolean add();
	
	/**
	 * update to Database or file
	 * @return
	 */
	public boolean update();
	
	/**
	 * modify to Database or file
	 * @return
	 */
	public boolean modify();
	
	/**
	 * delete to Database or file
	 * @return
	 */
	public boolean delete();
	
}
