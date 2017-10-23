package main.java.com.metacube.layeredArchitecture.dao.order;

import java.util.List;

import main.java.com.metacube.layeredArchitecture.dto.Message;
import main.java.com.metacube.layeredArchitecture.model.Order;

public interface OrderDao {

	Message placeOrder(String userEmail);

	List<Order> orderList(String userEmail);

}
