package main.java.com.metacube.layeredArchitecture.dao.product;

import main.java.com.metacube.layeredArchitecture.dao.GenericHibernateDao;
import main.java.com.metacube.layeredArchitecture.model.Product;
import org.springframework.stereotype.Repository;

@Repository("hibernateProductDao")
public class HibernateProductDao extends GenericHibernateDao<Product> implements ProductDao {
	public HibernateProductDao() {
		super(Product.class);
	}

}