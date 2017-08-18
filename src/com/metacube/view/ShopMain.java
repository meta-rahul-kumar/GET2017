package com.metacube.view;

/**
 * 
 * @version 1.0 July 25, 2017
 * @author Rahul Kumar
 *
 */

public class ShopMain {
	public static void main(String[] args) {
		Output.getInstance().showAllProducts();
		Output.getInstance().showAllProductPromos();
		Output.getInstance().showAllOrderPromos();
		
		int totalBuyingProduct = Input.getInstance().setTotalBuyingProducts();
		Input.getInstance().getProductsCodeAndQuantity(totalBuyingProduct);
		Output.getInstance().generateBill();
	}
}
