package com.metacube.facade;
import java.util.HashMap;
import com.metacube.dao.FileProductDAO;
import com.metacube.models.Product;

/**
 * 
 * @version 1.0 July 25, 2017
 * @author Rahul Kumar
 *
 */
public class ProductFacade {
	final static String FILEPATH = "src/Products.csv";
	FileProductDAO fileProductDAO = FileProductDAO.getInstance();
	
	/**
	 * returns all products which is available in store
	 * @return
	 */
	HashMap<String, Product> getAllProducts(){
		// getter method
		return fileProductDAO.getAllProductsFromFilePath();
	}
	
	/**
	 *	return the Product using specific ProductId 
	 * @param productId
	 * @return
	 */
	Product getProductById(String productId) {
		HashMap<String, Product> allProducts = new HashMap<>();
		allProducts = fileProductDAO.getAllProductsFromFilePath();
		
		if (allProducts.containsKey(productId+"")) {
			return allProducts.get(productId);
		}else {
			return null;
		}
	}
	
	/**
	 * Product Constructor which reads the Products.csv file and stores it in totalProducts HashMap
	 */
	ProductFacade() {
		fileProductDAO.readAllProductsFromFilePath(FILEPATH);
	}
	
	/**
	 * Show all the available products
	 */
	void showAllProducts() {
		HashMap<String, Product> allProducts = new HashMap<>();
		allProducts = fileProductDAO.getAllProductsFromFilePath();
		
		System.out.println("Code \t Name \t\t\t\t Price");
		for (String key : allProducts.keySet()) {
			System.out.println(allProducts.get(key).getCode() + "\t" + allProducts.get(key).getName() + "\t\t" + allProducts.get(key).getPrice());
		}
	}
	
}
