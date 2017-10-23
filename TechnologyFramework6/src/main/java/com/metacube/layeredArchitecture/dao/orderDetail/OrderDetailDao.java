package main.java.com.metacube.layeredArchitecture.dao.orderDetail;

import java.util.List;

import main.java.com.metacube.layeredArchitecture.model.Product;

public interface OrderDetailDao {

	List<Product> orderProducts(int orderId);

}
