package com.metacube.view;
import com.metacube.controller.OrderPromoController;
import com.metacube.controller.ProductController;
import com.metacube.controller.ProductPromoController;
import com.metacube.controller.UserCartController;

/**
 * 
 * @author Rahul Kumar
 *
 */
public class Output {
	private static Output output;
	
	/**
	 * Ensure only single instance of class is created
	 * 
	 * @return Product Controller object
	 */
	public static Output getInstance() {

		if (output == null) {
			synchronized (Output.class) {
				if (output == null) {
					output = new Output();
				}

			}
		}

		return output;
	}
	/**
	 * empty UserCart Constructor
	 */
	private Output(){
		
	}
	
	/**
	 * shows the all products in store
	 */
	public void showAllProducts() {
		ProductController.getInstance().showAllProducts();	
	}
	
	/**
	 *	shows all the product level promos 
	 */
	public void showAllProductPromos() {
		System.out.println("------------------------------------------------------------------------------------");
		// show product promos
		ProductPromoController.getInstance().showAllProductPromos();
	}
	
	/**
	 * shows all order level promos
	 */
	public void showAllOrderPromos() {
		System.out.println("------------------------------------------------------------------------------------");
		// show product promos
		OrderPromoController.getInstance().showAllOrderPromos();
	}
	
	/**
	 * add the product
	 * @param productCode
	 * @param productQuantity
	 */
	public void addProduct(int productCode, int productQuantity) {
		UserCartController.getInstance().addProduct(productCode, productQuantity);
	}
	
	/**
	 * show the all cart products
	 */
	public void showCart() {
		// TODO Auto-generated method stub
		UserCartController.getInstance().showCart();
	}
	
	/**
	 * generate and show bill
	 */
	public void generateBill() {
		// TODO Auto-generated method stub
		UserCartController.getInstance().generateBill(); // to generate the bill
	}
}
