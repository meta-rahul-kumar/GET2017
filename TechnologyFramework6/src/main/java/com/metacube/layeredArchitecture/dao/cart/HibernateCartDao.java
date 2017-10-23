package main.java.com.metacube.layeredArchitecture.dao.cart;

import main.java.com.metacube.layeredArchitecture.dao.GenericHibernateDao;
import main.java.com.metacube.layeredArchitecture.dto.Message;
import main.java.com.metacube.layeredArchitecture.model.Cart;
import main.java.com.metacube.layeredArchitecture.model.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("hibernateCartDao")
public class HibernateCartDao extends GenericHibernateDao<Cart> implements CartDao {
	public HibernateCartDao() {
		super(Cart.class);
	}

	@Override
	public void update(Cart t, int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Cart getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message addProductToCart(int productId, String currentUser) {
		Message msg = new Message();
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Product.class);
		Product product = (Product) criteria.add(Restrictions.eq("id", productId)).uniqueResult();

		criteria = session.createCriteria(Cart.class);
		criteria.add(Restrictions.eq("productId", productId));
		criteria.add(Restrictions.eq("addedBy", currentUser));
		if (criteria.list().size() > 0) {
			msg.setMessage("FAILURE");
		} else {
			Cart cart = new Cart();
			cart.setProductId(productId);
			cart.setName(product.getName());
			cart.setAddedBy(currentUser);
			session.save(cart);
			msg.setMessage("SUCCESS");
		}

		return msg;
	}

	@Override
	public List<Product> getAllCartProducts() {
		List<Product> productList = new ArrayList<>();
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Cart.class);
		criteria.add(Restrictions.eq("addedBy", "rahul.ctae94@gmail.com"));
		@SuppressWarnings("unchecked")
		Iterator<Cart> iter = criteria.list().iterator();
		Cart cart = new Cart();
		while (iter.hasNext()) {
			cart = iter.next();
			criteria = session.createCriteria(Product.class);
			productList.add((Product) criteria.add(Restrictions.eq("id", cart.getProductId())).uniqueResult());

		}
		return productList;
	}

	@Override
	public Message removeCartProduct(int id) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Cart.class);
		Message msg = new Message();
		if (criteria.list().size() == 0) {
			msg.setMessage("FAILURE");
		} else {
			msg.setMessage("SUCCESS");
			session.delete(criteria.add(Restrictions.eq("productId", id)).uniqueResult());
		}
		return msg;
	}

}