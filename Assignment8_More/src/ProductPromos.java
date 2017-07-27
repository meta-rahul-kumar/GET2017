import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 
 * @version 1.0 July 25, 2017
 * @author Rahul Kumar
 *
 */
public class ProductPromos {
	final static String FILEPATH = "src/ProductPromo.csv";
	HashMap<Integer,ProductPromo> totalProductPromos = new HashMap<>();
	
	/**
	 * ProductPromos Constructor which reads the ProductPromo.csv file and stores it in totalProductPromos HashMap
	 */
	ProductPromos() {
		ReadCsv read = new ReadCsv();
		int lineNo = 0;
		
		for(String altu : read.ReadCsvFile(FILEPATH)) {
			StringTokenizer tokenizer = new StringTokenizer(altu, "\t"); // splits using \t seperator
			
			while(tokenizer.hasMoreTokens()) {
				ProductPromo productPromo = new ProductPromo();
				productPromo.setProductPromo(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
				totalProductPromos.put(lineNo++, productPromo);
			}
			
		}
	}
	
	/**
	 * Show all Product Level Promotions
	 */
	void showProductPromos() {
		System.out.println("Type \t Discount \t\t\t\t Applicable For");
		
		for (int key : totalProductPromos.keySet()) {
			System.out.println(totalProductPromos.get(key).getType() + "\t" 
					+ totalProductPromos.get(key).getDiscount() + "\t\t" 
					+ totalProductPromos.get(key).getApplicableProducts());
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
		String result = "";
		HashMap<String, HashMap<String, String>> availPromoTypes = new HashMap<>();
		
		for (int promoKey : totalProductPromos.keySet() ) {
			String[] productIds = totalProductPromos.get(promoKey).getApplicableProducts().split(";"); // split the applicable product using ; seperator
			String promotionType = totalProductPromos.get(promoKey).getType();
			HashMap<String, String> newMap = new HashMap<>();
			
			for (String iterator : productIds) {
				if (promotionType.contains("Amount")) {
					// if type is of FixedAmout type
					newMap.put("AMOUNT", totalProductPromos.get(promoKey).getDiscount());
					if (availPromoTypes.containsKey(iterator)) {
						newMap = availPromoTypes.get(iterator);
						
					}
					newMap.put("AMOUNT", totalProductPromos.get(promoKey).getDiscount());
					availPromoTypes.put(iterator, newMap);
				}else if (promotionType.contains("Percent")) {
					// if type is of FixedPercent type
					if (availPromoTypes.containsKey(iterator)) {
						newMap = availPromoTypes.get(iterator);
						
					}
					newMap.put("PERCENT", totalProductPromos.get(promoKey).getDiscount());
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
		
		
		 
		Products productDetails = new Products();
		
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
		String appliedOn = "";
		
		
		for (int i = 0; i < totalProductPromos.size(); i++) {
			Products getById = new Products();
			
			if (totalProductPromos.get(i).getType().equals("ProductFixedAmountPromotion") && totalProductPromos.get(i).getDiscount().equals(Amount)) {
				String[] promoProductIds = totalProductPromos.get(i).getApplicableProducts().split(";");
				
				for (String oneByOne : promoProductIds) {
					appliedOn += getById.getProductById(oneByOne).getName() + "[";
					appliedOn += "Code:" + oneByOne + "], ";
				}
				
				appliedOn = appliedOn.substring(0, appliedOn.length() - 2);
				appliedOn += "\nDiscount : Rs." + (quantity * Double.parseDouble(totalProductPromos.get(i).getDiscount()));
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
		String appliedOn = "";
		
		for (int iterator = 0; iterator < totalProductPromos.size(); iterator++) {
			Products getById = new Products();
			if (totalProductPromos.get(iterator).getType().equals("ProductFixedPercentPromotion") && totalProductPromos.get(iterator).getDiscount().equals(Percent)) {
				String[] promoProductIds = totalProductPromos.get(iterator).getApplicableProducts().split(";");
				
				for (String oneByOneIterator : promoProductIds) {
					appliedOn += getById.getProductById(oneByOneIterator).getName() + "[";
					appliedOn += "Code:" + oneByOneIterator + "], ";
				}
				appliedOn = appliedOn.substring(0, appliedOn.length() - 2);
				appliedOn += "\nDiscount : Rs." + (quantity * (Double.parseDouble(totalProductPromos.get(iterator).getDiscount()) * Double.parseDouble(price) / 100));
			}
		}
		
		return appliedOn;
	}
}
