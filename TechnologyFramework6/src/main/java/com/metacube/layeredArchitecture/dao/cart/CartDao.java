package main.java.com.metacube.layeredArchitecture.dao.cart;

import java.util.List;
import main.java.com.metacube.layeredArchitecture.dao.BaseDao;
import main.java.com.metacube.layeredArchitecture.dto.Message;
import main.java.com.metacube.layeredArchitecture.model.Cart;
import main.java.com.metacube.layeredArchitecture.model.Product;

public interface CartDao extends BaseDao<Cart> {
	public Message addProductToCart(int productId, String currentUser);

	public List<Product> getAllCartProducts();

	public Message removeCartProduct(int id);
}