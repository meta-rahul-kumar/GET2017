package com.metacube.facade;
import java.util.HashMap;
import com.metacube.dao.InMemoryOrderPromoDAO;
import com.metacube.models.OrderPromo;

/**
 * Perform all Bussiness logics for OrderPromo's
 * @version 1.0 July 25, 2017
 * @author Rahul Kumar
 *
 */
public class OrderPromoFacade {
	final static String FILEPATH = "src/OrderPromo.csv";
	InMemoryOrderPromoDAO fileOrderPromoDAO = InMemoryOrderPromoDAO.getInstance();
	private static OrderPromoFacade orderPromoFacade;

		/**
		 * Ensure only single instance of class is created
		 * 
		 * @return
		 */
		public static OrderPromoFacade getInstance() {
	
			if (orderPromoFacade == null) {
				synchronized (OrderPromoFacade.class) {
					if (orderPromoFacade == null) {
						orderPromoFacade = new OrderPromoFacade();
					}
	
				}
			}
	
			return orderPromoFacade;
		}
		
		/**
		 * Private Constructor of OrderPromoFacade
		 */
		private OrderPromoFacade() {
			fileOrderPromoDAO.getAllOrderPromoFromFilePath(FILEPATH);
		}
		
		/**
		 * Methods displays all Order Level Promos
		 */
		public void showAllOrderPromos() {
			HashMap<Integer,OrderPromo> totalOrderPromos = fileOrderPromoDAO.getAllOrderPromos();
			System.out.println("Type \t Discount \t\t\t\t Applicable For");
			
			for (int key : totalOrderPromos.keySet()) {
				System.out.println(totalOrderPromos.get(key).getType() + "\t" + totalOrderPromos.get(key).getDiscount() + "\t\t" + totalOrderPromos.get(key).getThresholdValue());
			}
		}
		
		/**
		 * Method returns the Applicable Promos for a specified Amount
		 * @param totalOrderAmount
		 * @return
		 */
		public String ApplicablePromos(double totalOrderAmount) {
			HashMap<Integer,OrderPromo> totalOrderPromos = fileOrderPromoDAO.getAllOrderPromos();
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

