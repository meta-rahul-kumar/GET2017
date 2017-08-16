package com.metacube.facade;
import java.util.HashMap;
import com.metacube.dao.InMemoryUserCartDAO;
import com.metacube.utils.ReceiptGenerator;
import com.metacube.utils.Utils;

/**
 * class handles the user cart
 * @version 1.0 July 25, 2017
 * @author Rahul Kumar
 *
 */
public class UserCartFacade {
	InMemoryUserCartDAO getUserCart = InMemoryUserCartDAO.getInstance();
	/**
	 * empty UserCart Constructor
	 */
	UserCartFacade(){
		
	}
	
	/**
	 * adds a product in the user cart
	 * @param productCode
	 * @param productQuantity
	 * @return
	 */
	boolean addProduct(int productCode, int productQuantity) {
		ProductFacade showProducts = new ProductFacade();
		Utils validate = new Utils();
		boolean isAddProductSuccess = false;
		
		if(validate.validateProduct(showProducts.getProducts() , productCode)) {
			getUserCart.add(productCode, productQuantity);
			isAddProductSuccess = true;
		}
		
		return isAddProductSuccess;
	}
	
	/**
	 * shows all the product in which exists in user cart
	 */
	void showCart() {
		HashMap<Integer, Integer> allCartProducts = getUserCart.getAllCartProducts();
		ProductFacade showProducts = new ProductFacade();
		System.out.println("Cart : ");
		System.out.println("Code \t Name \t\t\t Price \t Quantity");
		
		for (int iteartor : allCartProducts.keySet()) {
			int quantity = allCartProducts.get(iteartor);
			System.out.println(showProducts.getProductById(iteartor+"").getCode() +"\t"+ showProducts.getProductById(iteartor+"").getName() + "\t\t" +showProducts.getProductById(iteartor+"").getPrice()+ "\t    " +quantity);
		}
	}
	
	/**
	 * generate the bill when user checkouts
	 */
	void generateBill() {
		HashMap<Integer, Integer> allCartProducts = getUserCart.getAllCartProducts();
		ProductFacade showProducts = new ProductFacade();
		ProductPromoFacade applicablePromos = new ProductPromoFacade();
		OrderPromoFacade applicableOrderPromos = new OrderPromoFacade();
		ReceiptGenerator generateReceipt = new ReceiptGenerator();
		double totalOrderAmount = 0;
		String toFile = "###############################################################";
		System.out.println(toFile);
		generateReceipt.generateRecipt(toFile+"\n");
		toFile = "YOUR ORDER :";
		System.out.println(toFile);
		generateReceipt.generateRecipt(toFile+"\n");
		toFile = "###############################################################";
		System.out.println(toFile);
		generateReceipt.generateRecipt(toFile+"\n");
		toFile = "PURCHASED PRODUCTS :";
		System.out.println(toFile);
		generateReceipt.generateRecipt(toFile+"\n");
		
		for (int iterator : allCartProducts.keySet()) {
			int quantity = allCartProducts.get(iterator);
			toFile = "Product : ";
			System.out.print(toFile);
			generateReceipt.generateRecipt(toFile);
			toFile = showProducts.getProductById(iterator+"").getCode() +" - "+ showProducts.getProductById(iterator+"").getName() + "\nCost : Rs." + (Double.parseDouble(showProducts.getProductById(iterator+"").getPrice()) * quantity )+ "(" +quantity + " x Rs." + showProducts.getProductById(iterator+"").getPrice() + ")";
			System.out.println(toFile);
			generateReceipt.generateRecipt(toFile+"\n\n");
			System.out.println();
			totalOrderAmount += Double.parseDouble(showProducts.getProductById(iterator+"").getPrice()) * quantity;
		}
		
		String productDiscountShow = "";
		toFile = "APPLIED PROMOTIONS/DISCOUNTS :";
		System.out.println(toFile);
		generateReceipt.generateRecipt(toFile+"\n");
		
		Utils utils = new Utils();
		
		for (int iterator : allCartProducts.keySet()) {
			int quantity = allCartProducts.get(iterator);
			int requiredProductId = utils.changeToInteger(showProducts.getProductById(iterator+"").getCode());
			double requiredProductPrice = utils.changeToDouble(showProducts.getProductById(iterator+"").getPrice());
			productDiscountShow += applicablePromos.getApplicableProductPromo(requiredProductId, requiredProductPrice, quantity) + "\n\n";
		}
		
		toFile = productDiscountShow;
		System.out.println(toFile);
		generateReceipt.generateRecipt(toFile+"\n");
		
//		System.out.println("---------------------------------------------");
//		System.out.println(totalOrderAmount);
		String orderDiscountShow = applicableOrderPromos.ApplicablePromos(totalOrderAmount);
		toFile = orderDiscountShow;
		System.out.println(toFile);
		generateReceipt.generateRecipt(toFile+"\n");
		
		double totalDiscount = 0;
		double productLevelDiscount = 0;
		double orderLevelDiscount = 0;
		String[] productDiscountShower = productDiscountShow.split("\n");
		String[] orderDiscountShower = orderDiscountShow.split("\n");
		
		for(int iterator=1;iterator<productDiscountShower.length;iterator+=3) {
			productLevelDiscount += Double.parseDouble(productDiscountShower[iterator].split("Discount : Rs.")[1]);
		}
		
		for(int iterator=1;iterator<orderDiscountShower.length;iterator+=3) {
			orderLevelDiscount += Double.parseDouble(orderDiscountShower[iterator].split("Discount : Rs.")[1]);
		}
		
		totalDiscount = productLevelDiscount + orderLevelDiscount;
		toFile = "SubTotal : Rs." + utils.roundNumber(totalOrderAmount);
		System.out.println(toFile);
		generateReceipt.generateRecipt(toFile+"\n");
		toFile = "Product Level Discounts : Rs." + utils.roundNumber(productLevelDiscount) ;
		System.out.println(toFile);
		generateReceipt.generateRecipt(toFile+"\n");
		toFile = "Order Level Discounts : Rs." + utils.roundNumber(orderLevelDiscount);
		System.out.println(toFile);
		generateReceipt.generateRecipt(toFile+"\n");
		toFile = "Total Discounts : Rs." + utils.roundNumber(totalDiscount);
		System.out.println(toFile);
		generateReceipt.generateRecipt(toFile+"\n");
		toFile = "Total : Rs." + utils.roundNumber((totalOrderAmount - totalDiscount));
		System.out.println(toFile);
		generateReceipt.generateRecipt(toFile+"\n");
	}
}
