package com.metacube.facade;
import java.util.HashMap;
import com.metacube.dao.FileProductPromoDAO;
import com.metacube.models.ProductPromo;

/**
 * 
 * @version 1.0 July 25, 2017
 * @author Rahul Kumar
 *
 */
public class ProductPromoFacade {
	FileProductPromoDAO getProductPromos = FileProductPromoDAO.getInstance();
	final static String FILEPATH = "src/ProductPromo.csv";
	
	/**
	 * ProductPromos Constructor which reads the ProductPromo.csv file and stores it in totalProductPromos HashMap
	 */
	ProductPromoFacade() {
		getProductPromos.addData(FILEPATH);
	}
	
	/**
	 * Show all Product Level Promotions
	 */
	void showProductPromos() {
		HashMap<Integer, ProductPromo> allProductPromos = new HashMap<>();
		
		allProductPromos = getProductPromos.getAllProductPromos();
		System.out.println("Type \t Discount \t\t\t\t Applicable For");
		
		for (int key : allProductPromos.keySet()) {
			System.out.println(allProductPromos.get(key).getType() + "\t" 
					+ allProductPromos.get(key).getDiscount() + "\t\t" 
					+ allProductPromos.get(key).getApplicableProducts());
		}
	}
	
	/**
	 * return the applicable Product level promotion in formatted text
	 * @param productId
	 * @param price
	 * @param quantity
	 * @return
	 */
	String getApplicableProductPromo(int productId, double price, int quantity) {
		HashMap<Integer, ProductPromo> allProductPromos = new HashMap<>();
		HashMap<String, HashMap<String, String>> availPromoTypes = new HashMap<>();
		allProductPromos = getProductPromos.getAllProductPromos();
		String result = "";
		
		for (int promoKey : allProductPromos.keySet() ) {
			String[] productIds = allProductPromos.get(promoKey).getApplicableProducts().split(";"); // split the applicable product using ; seperator
			String promotionType = allProductPromos.get(promoKey).getType();
			HashMap<String, String> newMap = new HashMap<>();
			
			for (String iterator : productIds) {
				if (promotionType.contains("Amount")) {
					// if type is of FixedAmout type
					newMap.put("AMOUNT", allProductPromos.get(promoKey).getDiscount());
					if (availPromoTypes.containsKey(iterator)) {
						newMap = availPromoTypes.get(iterator);
						
					}
					newMap.put("AMOUNT", allProductPromos.get(promoKey).getDiscount());
					availPromoTypes.put(iterator, newMap);
				}else if (promotionType.contains("Percent")) {
					// if type is of FixedPercent type
					if (availPromoTypes.containsKey(iterator)) {
						newMap = availPromoTypes.get(iterator);
						
					}
					newMap.put("PERCENT", allProductPromos.get(promoKey).getDiscount());
					availPromoTypes.put(iterator, newMap);
				}
			}
		}
		
		String promoAmount = null;
		String promoPercent = null;
		double discountFromFixedAmount = 0;
		double discountFromFixedPercent = 0;
		
		if (availPromoTypes.get(productId+"").containsKey("AMOUNT")) {
			promoAmount = availPromoTypes.get(productId+"").get("AMOUNT");
			discountFromFixedAmount = Double.parseDouble(promoAmount);
//			System.out.println(promoAmount);
		}
		
		if (availPromoTypes.get(productId+"").containsKey("PERCENT")) {
			promoPercent = availPromoTypes.get(productId+"").get("PERCENT");
			discountFromFixedPercent = (price * Double.parseDouble(promoPercent)) / 100;
//			System.out.println(promoPercent);
		}
		
		
		 
		ProductFacade productDetails = new ProductFacade();
		
		if (discountFromFixedAmount > discountFromFixedPercent ) {
			result += "Rs." + availPromoTypes.get(productId+"").get("AMOUNT") + " off on " + ApplicableProductPromos(availPromoTypes.get(productId+"").get("AMOUNT"), quantity); 
			//System.out.println("Amount" + discount);
		} else {
			discountFromFixedAmount = discountFromFixedPercent;
			result += availPromoTypes.get(productId+"").get("PERCENT") + "% off on " + productsAppliedForPercent(availPromoTypes.get(productId+"").get("PERCENT"), quantity, productDetails.getProductById(productId+"").getPrice()); 
			//System.out.println(discount2);
		}
		
	return result;
	}
	
	/**
	 * checks the products level promotion of type fixed Amount
	 * @param Amount
	 * @param quantity
	 * @return
	 */
	String ApplicableProductPromos(String Amount, int quantity) {
		HashMap<Integer, ProductPromo> allProductPromos = new HashMap<>();
		allProductPromos = getProductPromos.getAllProductPromos();
		String appliedOn = "";
		
		
		for (int i = 0; i < allProductPromos.size(); i++) {
			ProductFacade getById = new ProductFacade();
			
			if (allProductPromos.get(i).getType().equals("ProductFixedAmountPromotion") && allProductPromos.get(i).getDiscount().equals(Amount)) {
				String[] promoProductIds = allProductPromos.get(i).getApplicableProducts().split(";");
				
				for (String oneByOne : promoProductIds) {
					appliedOn += getById.getProductById(oneByOne).getName() + "[";
					appliedOn += "Code:" + oneByOne + "], ";
				}
				
				appliedOn = appliedOn.substring(0, appliedOn.length() - 2);
				appliedOn += "\nDiscount : Rs." + (quantity * Double.parseDouble(allProductPromos.get(i).getDiscount()));
			}
		}
		
		return appliedOn;
	}
	
	/**
	 * checks the product level promotion of type fixed percent
	 * @param Percent
	 * @param quantity
	 * @param price
	 * @return
	 */
	String productsAppliedForPercent(String Percent, int quantity , String price) {
		HashMap<Integer, ProductPromo> allProductPromos = new HashMap<>();
		allProductPromos = getProductPromos.getAllProductPromos();
		String appliedOn = "";
		
		for (int iterator = 0; iterator < allProductPromos.size(); iterator++) {
			ProductFacade getById = new ProductFacade();
			if (allProductPromos.get(iterator).getType().equals("ProductFixedPercentPromotion") && allProductPromos.get(iterator).getDiscount().equals(Percent)) {
				String[] promoProductIds = allProductPromos.get(iterator).getApplicableProducts().split(";");
				
				for (String oneByOneIterator : promoProductIds) {
					appliedOn += getById.getProductById(oneByOneIterator).getName() + "[";
					appliedOn += "Code:" + oneByOneIterator + "], ";
				}
				appliedOn = appliedOn.substring(0, appliedOn.length() - 2);
				appliedOn += "\nDiscount : Rs." + (quantity * (Double.parseDouble(allProductPromos.get(iterator).getDiscount()) * Double.parseDouble(price) / 100));
			}
		}
		
		return appliedOn;
	}
}
