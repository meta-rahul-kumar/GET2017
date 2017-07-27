import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 
 * @version 1.0 July 25, 2017
 * @author Rahul Kumar
 *
 */
public class OrderPromos {
	final static String FILEPATH = "src/OrderPromo.csv";
	HashMap<Integer,OrderPromo> totalOrderPromos = new HashMap<>();
		
		OrderPromos() {
			ReadCsv read = new ReadCsv();
			int lineNo = 0;
			for(String altu : read.ReadCsvFile(FILEPATH)) {
				StringTokenizer tokenizer = new StringTokenizer(altu, "\t");
				while(tokenizer.hasMoreTokens()) {
					OrderPromo orderPromo = new OrderPromo();
					orderPromo.setOrderPromo(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
					totalOrderPromos.put(lineNo++, orderPromo);
				}
			}
		}
		
		void showOrderPromos() {
			System.out.println("Type \t Discount \t\t\t\t Applicable For");
			
			for (int key : totalOrderPromos.keySet()) {
				System.out.println(totalOrderPromos.get(key).getType() + "\t" + totalOrderPromos.get(key).getDiscount() + "\t\t" + totalOrderPromos.get(key).getThresholdValue());
			}
		}
		
		
		String ApplicablePromos(double totalOrderAmount) {
			String appliedPromotions = "";
			double discount = 0;
			for (int iterator : totalOrderPromos.keySet()) {
				if (Double.parseDouble(totalOrderPromos.get(iterator).getThresholdValue()) <= totalOrderAmount) {
					if (totalOrderPromos.get(iterator).getType().equals("OrderFixedAmountPromotion") && 
							(discount < Double.parseDouble(totalOrderPromos.get(iterator).getDiscount()))) {
						
						appliedPromotions = "Rs." + totalOrderPromos.get(iterator).getDiscount() + " off on order Above Rs." + totalOrderPromos.get(iterator).getThresholdValue();
						appliedPromotions += "\nDiscount : Rs." + (Double.parseDouble(totalOrderPromos.get(iterator).getDiscount())) + "\n";
						discount = Double.parseDouble(totalOrderPromos.get(iterator).getDiscount());
						
					}else if(totalOrderPromos.get(iterator).getType().equals("OrderFixedPercentPromotion") &&
								(discount < ((Double.parseDouble(totalOrderPromos.get(iterator).getDiscount()) * totalOrderAmount) / 100))){
						
						appliedPromotions = totalOrderPromos.get(iterator).getDiscount() + "% off on order Above Rs." + totalOrderPromos.get(iterator).getThresholdValue();
						appliedPromotions += "\nDiscount : Rs." + (Double.parseDouble(totalOrderPromos.get(iterator).getDiscount()) * totalOrderAmount) / 100 + "\n";
						discount = (Double.parseDouble(totalOrderPromos.get(iterator).getDiscount()) * totalOrderAmount) / 100;
					}
				}
			}

			
			
		return appliedPromotions;
		}
	}

