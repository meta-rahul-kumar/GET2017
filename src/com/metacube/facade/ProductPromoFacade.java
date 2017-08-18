package com.metacube.facade;
import java.util.HashMap;
import com.metacube.dao.InMemoryProductPromoDAO;
import com.metacube.models.ProductPromo;

/**
 * 
 * @version 1.0 July 25, 2017
 * @author Rahul Kumar
 *
 */
public class ProductPromoFacade {
	InMemoryProductPromoDAO fileProductPromoDAO = InMemoryProductPromoDAO.getInstance();
	final static String FILEPATH = "src/ProductPromo.csv";
	private static ProductPromoFacade productPromoFacade;

	/**
	 * Ensure only single instance of class is created
	 * 
	 * @return Product Controller object
	 */
	public static ProductPromoFacade getInstance() {

		if (productPromoFacade == null) {
			synchronized (ProductPromoFacade.class) {
				if (productPromoFacade == null) {
					productPromoFacade = new ProductPromoFacade();
				}

			}
		}

		return productPromoFacade;
	}
	
	/**
	 * ProductPromos Constructor which reads the ProductPromo.csv file and stores it in totalProductPromos HashMap
	 */
	private ProductPromoFacade() {
		fileProductPromoDAO.readAllProductPromoFromFilePath(FILEPATH);
	}
	
	/**
	 * Show all Product Level Promotions
	 */
	public void showAllProductPromos() {
		HashMap<Integer, ProductPromo> allProductPromos = new HashMap<>();
		
		allProductPromos = fileProductPromoDAO.getAllProductPromos();
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
	public String getApplicableProductPromo(int productId, double price, int quantity) {
		HashMap<Integer, ProductPromo> allProductPromos = new HashMap<>();
		HashMap<String, HashMap<String, String>> availPromoTypes = new HashMap<>();
		allProductPromos = fileProductPromoDAO.getAllProductPromos();
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
		
		if (discountFromFixedAmount > discountFromFixedPercent ) {
			result += "Rs." + availPromoTypes.get(productId+"").get("AMOUNT") + " off on " + ApplicableProductPromos(availPromoTypes.get(productId+"").get("AMOUNT"), quantity); 
			//System.out.println("Amount" + discount);
		} else {
			discountFromFixedAmount = discountFromFixedPercent;
			result += availPromoTypes.get(productId+"").get("PERCENT") + "% off on " + productsApplicableForFixedPercentPromo(availPromoTypes.get(productId+"").get("PERCENT"), quantity, ProductFacade.getInstance().getProductById(productId+"").getPrice()); 
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
	public String ApplicableProductPromos(String Amount, int quantity) {
		HashMap<Integer, ProductPromo> allProductPromos = new HashMap<>();
		allProductPromos = fileProductPromoDAO.getAllProductPromos();
		String appliedOn = "";
		
		
		for (int i = 0; i < allProductPromos.size(); i++) {
			
			if (allProductPromos.get(i).getType().equals("ProductFixedAmountPromotion") && allProductPromos.get(i).getDiscount().equals(Amount)) {
				String[] promoProductIds = allProductPromos.get(i).getApplicableProducts().split(";");
				
				for (String oneByOne : promoProductIds) {
					appliedOn += ProductFacade.getInstance().getProductById(oneByOne).getName() + "[";
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
	public String productsApplicableForFixedPercentPromo(String Percent, int quantity , String price) {
		HashMap<Integer, ProductPromo> allProductPromos = new HashMap<>();
		allProductPromos = fileProductPromoDAO.getAllProductPromos();
		String appliedPromos = "";
		
		for (int iterator = 0; iterator < allProductPromos.size(); iterator++) {
			if (allProductPromos.get(iterator).getType().equals("ProductFixedPercentPromotion") && allProductPromos.get(iterator).getDiscount().equals(Percent)) {
				String[] promoProductIds = allProductPromos.get(iterator).getApplicableProducts().split(";");
				
				for (String oneByOneIterator : promoProductIds) {
					appliedPromos += ProductFacade.getInstance().getProductById(oneByOneIterator).getName() + "[";
					appliedPromos += "Code:" + oneByOneIterator + "], ";
				}
				appliedPromos = appliedPromos.substring(0, appliedPromos.length() - 2);
				appliedPromos += "\nDiscount : Rs." + (quantity * (Double.parseDouble(allProductPromos.get(iterator).getDiscount()) * Double.parseDouble(price) / 100));
			}
		}
		
		return appliedPromos;
	}
}
