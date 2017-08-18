package com.metacube.models;
import com.metacube.Enums.EntityType;

/**
 * Entity Factory which implements BaseEntity
 * @author User17
 *
 */
public class EntityFactory implements BaseEntity{
	
	/**
	 * Method takes a entity type and creates the object of entity.
	 * @param type
	 * @return
	 */
	public static BaseEntity getEntityFromFactory(EntityType type) {
		
		if (type == EntityType.Product) {
			return new Product();
		} else if (type == EntityType.OrderPromo) {
			return new OrderPromo();
		} else if (type == EntityType.ProductPromo) {
			return new OrderPromo();
		}
		
		return null;
	}
}
