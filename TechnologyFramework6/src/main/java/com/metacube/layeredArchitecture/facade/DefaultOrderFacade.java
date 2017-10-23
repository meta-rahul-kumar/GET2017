package main.java.com.metacube.layeredArchitecture.facade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import main.java.com.metacube.layeredArchitecture.dto.Message;
import main.java.com.metacube.layeredArchitecture.dto.OrderDto;
import main.java.com.metacube.layeredArchitecture.model.Order;
import main.java.com.metacube.layeredArchitecture.service.OrderService;

@Component("orderFacade")
public class DefaultOrderFacade implements OrderFacade {

	@Autowired
	OrderService orderService;

	@Override
	public Message placeOrder(String userEmail) {
		return orderService.placeOrder(userEmail);
	}

	@Override
	public List<OrderDto> orderList(String userEmail) {
		Iterator<Order> itr = orderService.orderList(userEmail).iterator();
		List<OrderDto> orderDtoList = new ArrayList<>();
		Date date = new Date();
		while (itr.hasNext()) {
			Order order = itr.next();
			OrderDto orderDto = new OrderDto();
			orderDto.setId(order.getId());

			date.setTime(order.getOrderDate().getTime());
			String formattedDate = new SimpleDateFormat("yyyy-MM-dd, hh:mm:ss").format(date);

			orderDto.setDate(formattedDate);

			orderDto.setTotal(order.getOrderTotal());
			orderDtoList.add(orderDto);
		}
		return orderDtoList;
	}

}
