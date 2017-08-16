package com.metacube.facade;
import java.util.HashMap;
import java.util.StringTokenizer;

import com.metacube.dao.FileOrderPromoDAO;
import com.metacube.models.OrderPromo;
import com.metacube.utils.ReadFromFile;

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
			ReadFromFile read = new ReadFromFile();
			int lineNo = 0;
			for(String altu : read.ReadCsvFile(FILEPATH)) {
				StringTokenizer tokenizer = new StringTokenizer(altu, "\t");
				while(tokenizer.hasMoreTokens()) {
					OrderPromo orderPromo = new OrderPromo();
					orderPromo.setOrderPromo(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
					getOrderPromo.add(lineNo++, orderPromo);
				}
			}
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

