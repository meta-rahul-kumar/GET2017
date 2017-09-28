package main.java.com.metacube.layeredArchitecture.facade;

import java.util.List;

import main.java.com.metacube.layeredArchitecture.dto.ProductDto;

public interface ProductFacade {
	List<ProductDto> getAllProducts();
	ProductDto getProductById(int id);
	int deleteProductById(int id);
}