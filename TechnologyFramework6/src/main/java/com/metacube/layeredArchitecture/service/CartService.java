package main.java.com.metacube.layeredArchitecture.service;

import java.util.List;

import main.java.com.metacube.layeredArchitecture.dto.Message;
import main.java.com.metacube.layeredArchitecture.model.Product;

public interface CartService {
	public Message addProductToCart(int productId, String currentUser);

	public List<Product> getAllCartProducts();

	public Message removeCartProduct(int id);
}
