package main.java.com.metacube.layeredArchitecture.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import main.java.com.metacube.layeredArchitecture.dao.orderDetail.OrderDetailDao;
import main.java.com.metacube.layeredArchitecture.model.Product;

@Component("orderDetailService")
@Transactional
public class DefaultOrderDetailService implements OrderDetailService {

	@Resource(name = "hibernateOrderDetailDao")
	OrderDetailDao orderDetailDao;

	@Override
	public List<Product> orderProducts(int orderId) {
		return orderDetailDao.orderProducts(orderId);
	}

}
