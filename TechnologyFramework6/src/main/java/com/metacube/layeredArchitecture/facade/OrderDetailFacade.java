package main.java.com.metacube.layeredArchitecture.facade;

import java.util.List;
import main.java.com.metacube.layeredArchitecture.dto.ProductDto;

public interface OrderDetailFacade {

	List<ProductDto> orderProducts(int orderId);
}