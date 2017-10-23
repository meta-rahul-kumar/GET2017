package main.java.com.metacube.layeredArchitecture.controller;

import java.util.List;

import main.java.com.metacube.layeredArchitecture.dto.Message;
import main.java.com.metacube.layeredArchitecture.dto.OrderDto;
import main.java.com.metacube.layeredArchitecture.dto.ProductDto;
import main.java.com.metacube.layeredArchitecture.facade.CartFacade;
import main.java.com.metacube.layeredArchitecture.facade.OrderDetailFacade;
import main.java.com.metacube.layeredArchitecture.facade.OrderFacade;
import main.java.com.metacube.layeredArchitecture.facade.ProductFacade;
import main.java.com.metacube.layeredArchitecture.facade.UserFacade;
import main.java.com.metacube.layeredArchitecture.model.Product;
import main.java.com.metacube.layeredArchitecture.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
@RequestMapping("/service/product")
public class ProductController {
	@Autowired
	ProductFacade productFacade;
	@Autowired
	UserFacade userFacade;
	@Autowired
	CartFacade cartFacade;
	@Autowired
	OrderFacade orderFacade;
	@Autowired
	OrderDetailFacade orderDetailFacade;

	@RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
	public @ResponseBody List<ProductDto> orderProducts(@PathVariable("id") int orderId) {
		System.out.println("Hello For All");
		return orderDetailFacade.orderProducts(orderId);
	}

	@RequestMapping(value = "/orderlist", method = RequestMethod.GET)
	public @ResponseBody List<OrderDto> orderList(@RequestParam("useremail") String userEmail) {
		System.out.println("Hello For All");
		return orderFacade.orderList(userEmail);
	}

	@RequestMapping(value = "/cart/placeOrder", method = RequestMethod.GET)
	public @ResponseBody Message placeProduct(@RequestParam("email") String userEmail) {
		return orderFacade.placeOrder(userEmail);
	}

	@RequestMapping(value = "/cart/addProduct", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody Message addProductToCart(@RequestParam("productId") int productId,
			@RequestParam("user") String currentUser) {
		return cartFacade.addProductToCart(productId, currentUser);
	}

	@RequestMapping(value = "/cartlist", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<ProductDto> getCartProducts() {
		return cartFacade.getAllCartProducts();
	}

	@RequestMapping(value = "/login", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody User checkLogin(@RequestParam("mailid") String name,
			@RequestParam("password") String password) {

		System.out.println(name + " , " + password);
		return userFacade.check(name, password);
	}

	@RequestMapping(value = "/list", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<ProductDto> getProducts() {
		return productFacade.getAllProducts();
	}

	@RequestMapping(value = "/{productId}", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody ProductDto getProductById(@PathVariable("productId") int id) {
		return productFacade.getProductById(id);
	}

	@RequestMapping(value = "/remove/{id}", produces = "application/json", method = RequestMethod.DELETE)
	public @ResponseBody Message removeCartProduct(@PathVariable("id") int id) {
		return cartFacade.removeCartProduct(id);
	}

	@RequestMapping(value = "/deleteProduct/{id}", produces = "application/json", method = RequestMethod.DELETE)
	public @ResponseBody int deleteProductById(@PathVariable("id") int id) {
		return productFacade.deleteProductById(id);
	}

	@RequestMapping(value = "/product/updateProduct/{id}", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	public @ResponseBody void editProduct(@RequestBody Product product, @PathVariable("id") int id) {
		productFacade.updateProduct(product, id);
	}

	@RequestMapping(value = "/product/addProduct", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody Product createProduct(@RequestBody Product product) {
		return productFacade.addProduct(product);
	}

}