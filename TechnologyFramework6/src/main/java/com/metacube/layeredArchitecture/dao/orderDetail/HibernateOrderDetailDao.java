package main.java.com.metacube.layeredArchitecture.dao.orderDetail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import main.java.com.metacube.layeredArchitecture.dao.GenericHibernateDao;
import main.java.com.metacube.layeredArchitecture.model.OrderDetail;
import main.java.com.metacube.layeredArchitecture.model.Product;

@Repository("hibernateOrderDetailDao")
public class HibernateOrderDetailDao extends GenericHibernateDao<Product> implements OrderDetailDao {

	@Override
	public void update(Product t, int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> orderProducts(int orderId) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(OrderDetail.class);
		@SuppressWarnings("unchecked")
		Iterator<OrderDetail> itr = criteria.add(Restrictions.eq("orderId", orderId)).list().iterator();
		List<Product> orderProducts = new ArrayList<>();
		while (itr.hasNext()) {
			criteria = session.createCriteria(Product.class);
			orderProducts.add((Product) criteria.add(Restrictions.eq("id", itr.next().getProductId())).uniqueResult());
		}
		return orderProducts;
	}

}
