package main.java.com.metacube.layeredArchitecture.service;

import java.util.List;

import main.java.com.metacube.layeredArchitecture.dto.Message;
import main.java.com.metacube.layeredArchitecture.model.Order;

public interface OrderService {

	Message placeOrder(String userEmail);

	List<Order> orderList(String userEmail);

}
