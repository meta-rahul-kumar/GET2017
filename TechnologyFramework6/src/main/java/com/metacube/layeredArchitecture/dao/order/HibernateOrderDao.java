package main.java.com.metacube.layeredArchitecture.dao.order;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import main.java.com.metacube.layeredArchitecture.dao.GenericHibernateDao;
import main.java.com.metacube.layeredArchitecture.dto.Message;
import main.java.com.metacube.layeredArchitecture.model.Cart;
import main.java.com.metacube.layeredArchitecture.model.Order;
import main.java.com.metacube.layeredArchitecture.model.OrderDetail;
import main.java.com.metacube.layeredArchitecture.model.Product;

@Repository("hibernateOrderDao")
public class HibernateOrderDao extends GenericHibernateDao<Order> implements OrderDao {

	@Override
	public void update(Order t, int id) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public Message placeOrder(String userEmail) {
		try {
			Session session = getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(Cart.class);

			List<Cart> cartItems = (List<Cart>) criteria.add(Restrictions.eq("addedBy", userEmail)).list();
			Iterator<Cart> itr = cartItems.iterator();
			float total = 0;

			while (itr.hasNext()) {
				criteria = session.createCriteria(Product.class);
				Product product = (Product) criteria.add(Restrictions.eq("id", itr.next().getProductId()))
						.uniqueResult();
				total += product.getPrice();
			}

			criteria = session.createCriteria(Order.class);
			Order order = new Order();
			order.setOrderBy(userEmail);
			order.setOrderDate(new Timestamp(new Date().getTime()));
			order.setOrderTotal(total);

			session.save(order);

			int currentOrderId = order.getId();

			criteria = session.createCriteria(OrderDetail.class);
			itr = cartItems.iterator();
			OrderDetail orderDetail;
			while (itr.hasNext()) {
				orderDetail = new OrderDetail();
				orderDetail.setOrderId(currentOrderId);
				orderDetail.setProductId(itr.next().getProductId());
				session.save(orderDetail);
			}

			criteria = session.createCriteria(Cart.class);
			itr = criteria.add(Restrictions.eq("addedBy", userEmail)).list().iterator();
			while (itr.hasNext()) {
				session.delete(itr.next());
			}

			Message msg = new Message();
			msg.setMessage("SUCCESS");
			return msg;
		} catch (Exception e) {
			Message msg = new Message();
			msg.setMessage("FAILURE");
			e.printStackTrace();
			return msg;

		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> orderList(String userEmail) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Order.class);
		return criteria.add(Restrictions.eq("orderBy", userEmail)).list();
	}

}
