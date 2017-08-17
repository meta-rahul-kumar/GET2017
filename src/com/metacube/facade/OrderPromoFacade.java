package com.metacube.facade;
import java.util.HashMap;
import com.metacube.dao.FileOrderPromoDAO;
import com.metacube.models.OrderPromo;

/**
 * 
 * @version 1.0 July 25, 2017
 * @author Rahul Kumar
 *
 */
public class OrderPromoFacade {
	final static String FILEPATH = "src/OrderPromo.csv";
	FileOrderPromoDAO getOrderPromo = FileOrderPromoDAO.getInstance();
		
		OrderPromoFacade() {
			getOrderPromo.addData(FILEPATH);
		}
		
		void showOrderPromos() {
			HashMap<Integer,OrderPromo> totalOrderPromos = getOrderPromo.getAllOrderPromos();
			System.out.println("Type \t Discount \t\t\t\t Applicable For");
			
			for (int key : totalOrderPromos.keySet()) {
				System.out.println(totalOrderPromos.get(key).getType() + "\t" + totalOrderPromos.get(key).getDiscount() + "\t\t" + totalOrderPromos.get(key).getThresholdValue());
			}
		}
		
		
		String ApplicablePromos(double totalOrderAmount) {
			HashMap<Integer,OrderPromo> totalOrderPromos = getOrderPromo.getAllOrderPromos();
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

