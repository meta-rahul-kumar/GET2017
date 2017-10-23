package main.java.com.metacube.layeredArchitecture.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import main.java.com.metacube.layeredArchitecture.dao.cart.CartDao;
import main.java.com.metacube.layeredArchitecture.dto.Message;
import main.java.com.metacube.layeredArchitecture.model.Product;

@Component("cartService")
@Transactional
public class DefaultCartService implements CartService {

	@Resource(name = "hibernateCartDao")
	CartDao cartDao;

	@Override
	public Message addProductToCart(int productId, String currentUser) {
		return cartDao.addProductToCart(productId, currentUser);
	}

	@Override
	public List<Product> getAllCartProducts() {
		return cartDao.getAllCartProducts();
	}

	@Override
	public Message removeCartProduct(int id) {
		return cartDao.removeCartProduct(id);
	}

}
