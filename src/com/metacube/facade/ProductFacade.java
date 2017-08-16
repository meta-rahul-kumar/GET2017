package com.metacube.facade;
import java.util.HashMap;
import java.util.StringTokenizer;

import com.metacube.dao.FileProductDAO;
import com.metacube.models.Product;
import com.metacube.utils.ReadFromFile;

/**
 * 
 * @version 1.0 July 25, 2017
 * @author Rahul Kumar
 *
 */
public class ProductFacade {
	final static String FILEPATH = "src/Products.csv";
	FileProductDAO getProducts = FileProductDAO.getInstance();
	
	/**
	 * returns all products which is available in store
	 * @return
	 */
	HashMap<String, Product> getProducts(){
		// getter method
		return getProducts.getAllProducts();
	}
	
	/**
	 *	return the Product using specific ProductId 
	 * @param productId
	 * @return
	 */
	Product getProductById(String productId) {
		HashMap<String, Product> allProducts = new HashMap<>();
		
		allProducts = getProducts.getAllProducts();
		Product tempProductAttribute = new Product();
		String tempProductId = allProducts.get(productId).getCode();
		String tempProductName = allProducts.get(productId).getName();
		String tempProductPrice = allProducts.get(productId).getPrice();
		tempProductAttribute.setProduct(tempProductId, tempProductName, tempProductPrice);
		return tempProductAttribute;
	}
	
	/**
	 * Product Constructor which reads the Products.csv file and stores it in totalProducts HashMap
	 */
	ProductFacade() {
		ReadFromFile read = new ReadFromFile();
		for(String lineNumber : read.ReadCsvFile(FILEPATH)) {
			StringTokenizer tokenizer = new StringTokenizer(lineNumber, "\t");
			while(tokenizer.hasMoreTokens()) {
				Product product = new Product();
				product.setProduct(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
				getProducts.add(product.getCode(), product);
			}
		}
	}
	
	/**
	 * Show all the available products
	 */
	void showProducts() {
		HashMap<String, Product> allProducts = new HashMap<>();
		allProducts = getProducts.getAllProducts();
		
		System.out.println("Code \t Name \t\t\t\t Price");
		for (String key : allProducts.keySet()) {
			System.out.println(allProducts.get(key).getCode() + "\t" + allProducts.get(key).getName() + "\t\t" + allProducts.get(key).getPrice());
		}
	}
	
}
