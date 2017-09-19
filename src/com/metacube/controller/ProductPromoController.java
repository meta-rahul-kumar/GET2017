package com.metacube.controller;
import com.metacube.facade.ProductPromoFacade;

/**
 * Controller for ProductPromo Facade
 * @author Rahul Kumar
 *
 */
public class ProductPromoController {
	private static ProductPromoController productPromoController;
	
	/**
	 * ProductPromoController Constructor
	 */
	private ProductPromoController() {
		ProductPromoFacade.getInstance();
	}

	/**
	 * Ensure only single instance of class is created
	 * 
	 * @return Product Controller object
	 */
	public static ProductPromoController getInstance() {

		if (productPromoController == null) {
			synchronized (ProductPromoController.class) {
				if (productPromoController == null) {
					productPromoController = new ProductPromoController();
				}

			}
		}

		return productPromoController;
	}
	
	/**
	 * Show all Product Level Promotions
	 */
	public void showAllProductPromos() {
		ProductPromoFacade.getInstance().showAllProductPromos();
	}
	
	/**
	 * return the applicable Product level promotion in formatted text
	 * @param productId
	 * @param price
	 * @param quantity
	 * @return
	 */
	String getApplicableProductPromo(int productId, double price, int quantity) {
		return ProductPromoFacade.getInstance().getApplicableProductPromo(productId, price, quantity);
	}
	
	/**
	 * checks the products level promotion of type fixed Amount
	 * @param Amount
	 * @param quantity
	 * @return
	 */
	String ApplicableProductPromos(String Amount, int quantity) {
		return ProductPromoFacade.getInstance().ApplicableProductPromos(Amount, quantity);
	}
	
	/**
	 * checks the product level promotion of type fixed percent
	 * @param Percent
	 * @param quantity
	 * @param price
	 * @return
	 */
	String productsApplicableForFixedPercentPromo(String Percent, int quantity , String price) {
		return ProductPromoFacade.getInstance().productsApplicableForFixedPercentPromo(Percent, quantity, price);
	}
}
