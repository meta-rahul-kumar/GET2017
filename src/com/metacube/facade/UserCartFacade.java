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
	InMemoryUserCartDAO inMemoryUserCartDAO = InMemoryUserCartDAO.getInstance();
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
		ProductFacade productFacade = new ProductFacade();
		boolean isAddProductSuccess = false;
		
		if(Utils.validateProduct(productFacade.getAllProducts() , productCode)) {
			inMemoryUserCartDAO.add(productCode, productQuantity);
			isAddProductSuccess = true;
		}
		
		return isAddProductSuccess;
	}
	
	/**
	 * shows all the product in which exists in user cart
	 */
	void showCart() {
		HashMap<Integer, Integer> allCartProducts = inMemoryUserCartDAO.getAllCartProducts();
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
		HashMap<Integer, Integer> allCartProducts = inMemoryUserCartDAO.getAllCartProducts();
		ProductFacade productFacade = new ProductFacade();
		OrderPromoFacade orderPromoFacade = new OrderPromoFacade();
		ReceiptGenerator receiptGenerator = new ReceiptGenerator();
		double totalOrderAmount = 0;
		
		String toFile = recieptFormate();
		
		for (int iterator : allCartProducts.keySet()) {
			int quantity = allCartProducts.get(iterator);
			toFile = "Product : ";
			System.out.print(toFile);
			receiptGenerator.generateRecipt(toFile);
			toFile = productFacade.getProductById(iterator+"").getCode() +" - "+ productFacade.getProductById(iterator+"").getName() + "\nCost : Rs." + (Double.parseDouble(productFacade.getProductById(iterator+"").getPrice()) * quantity )+ "(" +quantity + " x Rs." + productFacade.getProductById(iterator+"").getPrice() + ")";
			System.out.println(toFile);
			receiptGenerator.generateRecipt(toFile+"\n\n");
			System.out.println();
			totalOrderAmount += Double.parseDouble(productFacade.getProductById(iterator+"").getPrice()) * quantity;
		}
		
		String discountOnProducts = "";
		toFile = "APPLIED PROMOTIONS/DISCOUNTS :";
		System.out.println(toFile);
		receiptGenerator.generateRecipt(toFile+"\n");

		discountOnProducts += getProductLevelDiscount(allCartProducts);
		
		toFile = discountOnProducts;
		System.out.println(toFile);
		receiptGenerator.generateRecipt(toFile+"\n");
		
//		System.out.println("---------------------------------------------");
//		System.out.println(totalOrderAmount);
		String orderDiscountShow = orderPromoFacade.ApplicablePromos(totalOrderAmount);
		toFile = orderDiscountShow;
		System.out.println(toFile);
		receiptGenerator.generateRecipt(toFile+"\n");
		
		double totalDiscount = 0;
		double productLevelDiscount = 0;
		double orderLevelDiscount = 0;
		String[] productDiscountShower = discountOnProducts.split("\n");
		String[] orderDiscountShower = orderDiscountShow.split("\n");
		
		for(int iterator=1;iterator<productDiscountShower.length;iterator+=3) {
			productLevelDiscount += Double.parseDouble(productDiscountShower[iterator].split("Discount : Rs.")[1]);
		}
		
		for(int iterator=1;iterator<orderDiscountShower.length;iterator+=3) {
			orderLevelDiscount += Double.parseDouble(orderDiscountShower[iterator].split("Discount : Rs.")[1]);
		}
		
		totalDiscount = productLevelDiscount + orderLevelDiscount;
		toFile = "SubTotal : Rs." + Utils.roundNumber(totalOrderAmount);
		System.out.println(toFile);
		receiptGenerator.generateRecipt(toFile+"\n");
		toFile = "Product Level Discounts : Rs." + Utils.roundNumber(productLevelDiscount) ;
		System.out.println(toFile);
		receiptGenerator.generateRecipt(toFile+"\n");
		toFile = "Order Level Discounts : Rs." + Utils.roundNumber(orderLevelDiscount);
		System.out.println(toFile);
		receiptGenerator.generateRecipt(toFile+"\n");
		toFile = "Total Discounts : Rs." + Utils.roundNumber(totalDiscount);
		System.out.println(toFile);
		receiptGenerator.generateRecipt(toFile+"\n");
		toFile = "Total : Rs." + Utils.roundNumber((totalOrderAmount - totalDiscount));
		System.out.println(toFile);
		receiptGenerator.generateRecipt(toFile+"\n");
	}

	private String recieptFormate() {
		ReceiptGenerator receiptGenerator = new ReceiptGenerator();
		String toFile = "###############################################################";
		System.out.println(toFile);
		receiptGenerator.generateRecipt(toFile+"\n");
		toFile = "YOUR ORDER :";
		System.out.println(toFile);
		receiptGenerator.generateRecipt(toFile+"\n");
		toFile = "###############################################################";
		System.out.println(toFile);
		receiptGenerator.generateRecipt(toFile+"\n");
		toFile = "PURCHASED PRODUCTS :";
		System.out.println(toFile);
		receiptGenerator.generateRecipt(toFile+"\n");
		
		return toFile;
	}

	private String getProductLevelDiscount(HashMap<Integer, Integer> allCartProducts) {
		String productLevelDiscount ="";
		ProductFacade productFacade = new ProductFacade();
		ProductPromoFacade productPromoFacade = new ProductPromoFacade();
		
		for (int iterator : allCartProducts.keySet()) {
			int quantity = allCartProducts.get(iterator);
			int requiredProductId = Utils.changeToInteger(productFacade.getProductById(iterator+"").getCode());
			double requiredProductPrice = Utils.changeToDouble(productFacade.getProductById(iterator+"").getPrice());
			productLevelDiscount += productPromoFacade.getApplicableProductPromo(requiredProductId, requiredProductPrice, quantity) + "\n\n";
		}
		
		return productLevelDiscount;
	}
}
