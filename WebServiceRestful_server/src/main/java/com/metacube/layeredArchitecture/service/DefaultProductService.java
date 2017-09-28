package main.java.com.metacube.layeredArchitecture.service;

import java.util.List;

import main.java.com.metacube.layeredArchitecture.dao.product.ProductDao;
import main.java.com.metacube.layeredArchitecture.model.Product;

public class DefaultProductService implements ProductService {
	ProductDao productDao;

	public DefaultProductService(ProductDao productDao) {
		this.productDao = productDao;
	}
	public List<Product> getAllProducts() {
		return productDao.getAll();
	}

	public Product getProductById(int id) {
		return productDao.getById(id);
	}
	
	@Override
	public int deleteProductById(int id) {
		return productDao.deleteById(id);
	}	
}