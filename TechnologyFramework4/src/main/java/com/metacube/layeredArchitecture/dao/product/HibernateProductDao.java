package main.java.com.metacube.layeredArchitecture.dao.product;

import main.java.com.metacube.layeredArchitecture.dao.GenericHibernateDao;
import main.java.com.metacube.layeredArchitecture.model.Product;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository("hibernateProductDao")
public class HibernateProductDao extends GenericHibernateDao<Product> implements ProductDao {
	public HibernateProductDao() {
		super(Product.class);
	}

	public void update(Product product) {
		Session session = getSessionFactory().getCurrentSession();
		session.update(product);
	}

	public void create(Product product) {
		Session session = getSessionFactory().getCurrentSession();
		session.save(product);
	}

}