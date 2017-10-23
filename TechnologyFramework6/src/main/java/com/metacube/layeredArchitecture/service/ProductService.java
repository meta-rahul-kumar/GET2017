package main.java.com.metacube.layeredArchitecture.service;

import java.util.List;
import main.java.com.metacube.layeredArchitecture.model.Product;

public interface ProductService {
	List<Product> getAllProducts();
	Product getProductById(int id);
	int deleteProductById(int id);
	int addProduct(Product product);
	void updateProduct(Product product, int id);
}