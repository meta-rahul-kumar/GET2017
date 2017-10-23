package main.java.com.metacube.layeredArchitecture.service;

import java.util.List;
import main.java.com.metacube.layeredArchitecture.model.Product;

public interface OrderDetailService {

	List<Product> orderProducts(int orderId);

}
