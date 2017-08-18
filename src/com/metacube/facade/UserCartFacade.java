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
	private static UserCartFacade userCartFacade;

	/**
	 * Ensure only single instance of class is created
	 * 
	 * @return Product Controller object
	 */
	public static UserCartFacade getInstance() {

		if (userCartFacade == null) {
			synchronized (UserCartFacade.class) {
				if (userCartFacade == null) {
					userCartFacade = new UserCartFacade();
				}

			}
		}

		return userCartFacade;
	}
	/**
	 * empty UserCart Constructor
	 */
	private UserCartFacade(){
		
	}
	
	/**
	 * adds a product in the user cart
	 * @param productCode
	 * @param productQuantity
	 * @return
	 */
	public boolean addProduct(int productCode, int productQuantity) {
		boolean isAddProductSuccess = false;
		
		if(Utils.validateProduct(ProductFacade.getInstance().getAllProducts() , productCode)) {
			inMemoryUserCartDAO.add(productCode, productQuantity);
			isAddProductSuccess = true;
		}
		
		return isAddProductSuccess;
	}
	
	/**
	 * shows all the product in which exists in user cart
	 */
	public void showCart() {
		HashMap<Integer, Integer> allCartProducts = inMemoryUserCartDAO.getAllCartProducts();
		System.out.println("Cart : ");
		System.out.println("Code \t Name \t\t\t Price \t Quantity");
		
		for (int iteartor : allCartProducts.keySet()) {
			int quantity = allCartProducts.get(iteartor);
			System.out.println(ProductFacade.getInstance().getProductById(iteartor+"").getCode() +"\t"+ ProductFacade.getInstance().getProductById(iteartor+"").getName() + "\t\t" +ProductFacade.getInstance().getProductById(iteartor+"").getPrice()+ "\t    " +quantity);
		}
	}
	
	/**
	 * generate the bill when user checkouts
	 */
	public String generateBill() {
		HashMap<Integer, Integer> allCartProducts = inMemoryUserCartDAO.getAllCartProducts();
		ReceiptGenerator receiptGenerator = new ReceiptGenerator();
		double totalOrderAmount = 0;
		
		String toFile = recieptFormate();
		
		for (int iterator : allCartProducts.keySet()) {
			int quantity = allCartProducts.get(iterator);
			toFile = "Product : ";
			System.out.print(toFile);
			receiptGenerator.generateRecipt(toFile);
			toFile = ProductFacade.getInstance().getProductById(iterator+"").getCode() +" - "+ ProductFacade.getInstance().getProductById(iterator+"").getName() + "\nCost : Rs." + (Double.parseDouble(ProductFacade.getInstance().getProductById(iterator+"").getPrice()) * quantity )+ "(" +quantity + " x Rs." + ProductFacade.getInstance().getProductById(iterator+"").getPrice() + ")";
			System.out.println(toFile);
			receiptGenerator.generateRecipt(toFile+"\n\n");
			System.out.println();
			totalOrderAmount += Double.parseDouble(ProductFacade.getInstance().getProductById(iterator+"").getPrice()) * quantity;
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
		String orderDiscountShow = OrderPromoFacade.getInstance().ApplicablePromos(totalOrderAmount);
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
		
		return toFile;
	}

	/**
	 * method displays the formate of reciept
	 * @return
	 */
	public String recieptFormate() {
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

	/**
	 * method returns the ProductLevel Discount
	 * @param allCartProducts
	 * @return
	 */
	public String getProductLevelDiscount(HashMap<Integer, Integer> allCartProducts) {
		String productLevelDiscount ="";
		
		for (int iterator : allCartProducts.keySet()) {
			int quantity = allCartProducts.get(iterator);
			int requiredProductId = Utils.changeToInteger(ProductFacade.getInstance().getProductById(iterator+"").getCode());
			double requiredProductPrice = Utils.changeToDouble(ProductFacade.getInstance().getProductById(iterator+"").getPrice());
			productLevelDiscount += ProductPromoFacade.getInstance().getApplicableProductPromo(requiredProductId, requiredProductPrice, quantity) + "\n\n";
		}
		
		return productLevelDiscount;
	}
}
