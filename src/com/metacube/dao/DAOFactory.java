package com.metacube.dao;
import com.metacube.Enums.DBType;
import com.metacube.Enums.EntityType;

public class DAOFactory {
	
	public static BaseDAO<?> getDAOforEntity(EntityType entity, DBType dbtype) {
		
		if (entity == EntityType.Product && dbtype == DBType.InMemory) {
			return InMemoryProductDAO.getInstance();
		} else if (entity == EntityType.ProductPromo && dbtype == DBType.InMemory) {
			return InMemoryProductPromoDAO.getInstance();
		} else if (entity == EntityType.OrderPromo && dbtype == DBType.InMemory) {
			return InMemoryOrderPromoDAO.getInstance();
		} else if (entity == EntityType.UserCart && dbtype == DBType.InMemory) {
			return InMemoryUserCartDAO.getInstance();
		}
		
		return null;
	}
}
