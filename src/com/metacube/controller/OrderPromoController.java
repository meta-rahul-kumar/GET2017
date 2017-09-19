package com.metacube.controller;
import com.metacube.facade.OrderPromoFacade;

/**
 * Controller for OrderPromo Facade
 * @author Rahul Kumar
 *
 */
public class OrderPromoController {
private static OrderPromoController orderPromoController;
	
	/**
	 * Private Constructor of OrderPromoController
	 */
	private OrderPromoController() {
		OrderPromoFacade.getInstance();
	}

	/**
	 * Ensure only single instance of class is created
	 * 
	 * @return Product Controller object
	 */
	public static OrderPromoController getInstance() {

		if (orderPromoController == null) {
			synchronized (OrderPromoController.class) {
				if (orderPromoController == null) {
					orderPromoController = new OrderPromoController();
				}

			}
		}

		return orderPromoController;
	}
	
	/**
	 * invokes the showAllOrderPromos method of OrderPromoFacade
	 */
	public void showAllOrderPromos() {
		OrderPromoFacade.getInstance().showAllOrderPromos();
	}
	
	/**
	 * invokes the ApplicablePromos method of OrderPromoFacade
	 */
	String ApplicablePromos(double totalOrderAmount) {
		return OrderPromoFacade.getInstance().ApplicablePromos(totalOrderAmount);
	}
}
