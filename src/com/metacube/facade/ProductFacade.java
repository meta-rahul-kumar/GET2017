package com.metacube.facade;
import java.util.HashMap;
import com.metacube.dao.InMemoryProductDAO;
import com.metacube.models.Product;

/**
 * 
 * @version 1.0 July 25, 2017
 * @author Rahul Kumar
 *
 */
public class ProductFacade {
	final static String FILEPATH = "src/Products.csv";
	InMemoryProductDAO fileProductDAO = InMemoryProductDAO.getInstance();
	private static ProductFacade productFacade;

	/**
	 * Product Constructor which reads the Products.csv file and stores it in totalProducts HashMap
	 */
	private ProductFacade() {
		fileProductDAO.readAllProductsFromFilePath(FILEPATH);
	}
	
	/**
	 * Ensure only single instance of class is created
	 * 
	 * @return Product object
	 */
	public static ProductFacade getInstance() {

		if (productFacade == null) {
			synchronized (ProductFacade.class) {
				if (productFacade == null) {
					productFacade = new ProductFacade();
				}

			}
		}

		return productFacade;
	}
	
	/**
	 * returns all products which is available in store
	 * @return
	 */
	public HashMap<String, Product> getAllProducts(){
		// getter method
		return fileProductDAO.getAllProductsFromFilePath();
	}
	
	/**
	 *	return the Product using specific ProductId 
	 * @param productId
	 * @return
	 */
	public Product getProductById(String productId) {
		HashMap<String, Product> allProducts = new HashMap<>();
		allProducts = fileProductDAO.getAllProductsFromFilePath();
		
		if (allProducts.containsKey(productId+"")) {
			return allProducts.get(productId);
		}else {
			return null;
		}
	}
	
	
	
	/**
	 * Show all the available products
	 */
	public void showAllProducts() {
		HashMap<String, Product> allProducts = new HashMap<>();
		allProducts = fileProductDAO.getAllProductsFromFilePath();
		
		System.out.println("Code \t Name \t\t\t\t Price");
		for (String key : allProducts.keySet()) {
			System.out.println(allProducts.get(key).getCode() + "\t" + allProducts.get(key).getName() + "\t\t" + allProducts.get(key).getPrice());
		}
	}
	
}
