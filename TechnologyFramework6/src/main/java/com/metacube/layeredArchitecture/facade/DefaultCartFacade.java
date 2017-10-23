package main.java.com.metacube.layeredArchitecture.facade;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import main.java.com.metacube.layeredArchitecture.dto.Message;
import main.java.com.metacube.layeredArchitecture.dto.ProductDto;
import main.java.com.metacube.layeredArchitecture.model.Product;
import main.java.com.metacube.layeredArchitecture.service.CartService;

@Component("cartFacade")
public class DefaultCartFacade implements CartFacade {
	@Autowired
	CartService cartService;

	@Override
	public Message addProductToCart(int productId, String currentUser) {
		return cartService.addProductToCart(productId, currentUser);
	}

	public List<ProductDto> getAllCartProducts() {
		List<Product> allProduct = cartService.getAllCartProducts();
		List<ProductDto> productDtoList = new ArrayList<>();
		Iterator<Product> itr = allProduct.iterator();
		Product product;
		while (itr.hasNext()) {
			product = itr.next();
			productDtoList.add(new ProductDto(product.getId(), product.getName(), product.getPrice(),
					product.getSeller(), product.getThumbnail(), product.getQuantity(), product.getRating()));
		}

		return productDtoList;
	}

	@Override
	public Message removeCartProduct(int id) {
		return cartService.removeCartProduct(id);
	}

}
