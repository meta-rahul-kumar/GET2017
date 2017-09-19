package com.metacube.controller;
import java.util.HashMap;

import com.metacube.facade.ProductFacade;
import com.metacube.models.Product;

/**
 * Controller for Product Facade
 * @author Rahul Kumar
 *
 */
public class ProductController {
	private static ProductController productController;
	
	/**
	 * Private Constructor of Product Controller
	 */
	private ProductController() {
		ProductFacade.getInstance();
	}

	/**
	 * Ensure only single instance of class is created
	 * 
	 * @return Product Controller object
	 */
	public static ProductController getInstance() {

		if (productController == null) {
			synchronized (ProductController.class) {
				if (productController == null) {
					productController = new ProductController();
				}

			}
		}

		return productController;
	}
	
	/**
	 * invokes the getAllProducts method of ProductFacade
	 * @return
	 */
	HashMap<String, Product> getAllProducts(){
		// getter method
		return ProductFacade.getInstance().getAllProducts();
	}
	
	/**
	 * invokes the getProductById method of ProductFacade
	 * @return
	 */
	Product getProductById(String productId) {
		return ProductFacade.getInstance().getProductById(productId);
	}
	
	/**
	 * invokes the showAllProducts method of ProductFacade
	 * @return
	 */
	public void showAllProducts() {
		ProductFacade.getInstance().showAllProducts();
	}
}
