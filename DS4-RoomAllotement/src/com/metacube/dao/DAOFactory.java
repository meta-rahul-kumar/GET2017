package com.metacube.dao;
import com.metacube.enums.EntityType;

/**
 * DAOFactory is a factory class to instantiate the DAO's.
 * @author Rahul Kumar
 *
 */
public class DAOFactory{
	
	/**
	 * returns the entity type DAO instance;
	 * @param entity
	 * @return
	 */
	public static BaseDAO<?> getDAOForEntity(EntityType entity){
		if (entity == EntityType.Guest) {
			return (BaseDAO<?>) GuestDAO.getInstance();
		} else {
			return null;
		}
	}
}
