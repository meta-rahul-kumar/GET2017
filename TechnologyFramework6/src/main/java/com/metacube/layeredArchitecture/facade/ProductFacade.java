package main.java.com.metacube.layeredArchitecture.facade;

import java.util.List;

import main.java.com.metacube.layeredArchitecture.dto.ProductDto;
import main.java.com.metacube.layeredArchitecture.model.Product;

public interface ProductFacade {
	List<ProductDto> getAllProducts();

	ProductDto getProductById(int id);

	int deleteProductById(int id);

	void updateProduct(Product product, int id);

	Product addProduct(Product product);
}