package main.java.com.metacube.layeredArchitecture.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import main.java.com.metacube.layeredArchitecture.dao.product.ProductDao;
import main.java.com.metacube.layeredArchitecture.model.Product;

@Component("productService")
@Transactional
public class DefaultProductService implements ProductService {

	@Resource(name = "hibernateProductDao")
	ProductDao productDao;

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