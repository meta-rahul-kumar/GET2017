package main.java.com.metacube.layeredArchitecture.service;

import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import main.java.com.metacube.layeredArchitecture.dao.order.OrderDao;
import main.java.com.metacube.layeredArchitecture.dto.Message;
import main.java.com.metacube.layeredArchitecture.model.Order;

@Component("orderService")
@Transactional
public class DefaultOrderService implements OrderService {

	@Resource(name = "hibernateOrderDao")
	OrderDao orderDao;

	@Override
	public Message placeOrder(String userEmail) {
		return orderDao.placeOrder(userEmail);
	}

	@Override
	public List<Order> orderList(String userEmail) {
		return orderDao.orderList(userEmail);
	}

}
