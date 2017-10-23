package main.java.com.metacube.layeredArchitecture.facade;

import java.util.List;

import main.java.com.metacube.layeredArchitecture.dto.Message;
import main.java.com.metacube.layeredArchitecture.dto.OrderDto;

public interface OrderFacade {

	Message placeOrder(String userEmail);

	List<OrderDto> orderList(String userEmail);

}