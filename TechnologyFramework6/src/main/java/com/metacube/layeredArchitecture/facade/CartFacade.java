package main.java.com.metacube.layeredArchitecture.facade;

import java.util.List;

import main.java.com.metacube.layeredArchitecture.dto.Message;
import main.java.com.metacube.layeredArchitecture.dto.ProductDto;

public interface CartFacade {
	public Message addProductToCart(int productId, String currentUser);

	public List<ProductDto> getAllCartProducts();

	public Message removeCartProduct(int id);
}