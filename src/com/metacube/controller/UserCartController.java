package com.metacube.controller;
import java.util.HashMap;
import com.metacube.facade.UserCartFacade;

/**
 * Controller for UserCart Facade
 * @author Rahul Kumar
 *
 */
public class UserCartController {
	private static UserCartController userCartController;
	
	/**
	 * UserCartController Private Constructor
	 */
	private UserCartController() {
		UserCartFacade.getInstance();
	}

	/**
	 * Ensure only single instance of class is created
	 * 
	 * @return Product Controller object
	 */
	public static UserCartController getInstance() {

		if (userCartController == null) {
			synchronized (UserCartController.class) {
				if (userCartController == null) {
					userCartController = new UserCartController();
				}

			}
		}

		return userCartController;
	}
	
	/**
	 * adds a product in the user cart
	 * @param productCode
	 * @param productQuantity
	 * @return
	 */
	public boolean addProduct(int productCode, int productQuantity) {
		return UserCartFacade.getInstance().addProduct(productCode, productQuantity);
	}
	
	/**
	 * shows all the product in which exists in user cart
	 */
	public void showCart() {
		UserCartFacade.getInstance().showCart();
	}
	
	/**
	 * generate the bill when user checkouts
	 */
	public void generateBill() {
		UserCartFacade.getInstance().generateBill();
	}

	String recieptFormate() {
		return UserCartFacade.getInstance().recieptFormate();
	}

	String getProductLevelDiscount(HashMap<Integer, Integer> allCartProducts) {
		return UserCartFacade.getInstance().getProductLevelDiscount(allCartProducts);
	}
}
