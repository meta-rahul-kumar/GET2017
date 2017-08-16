package com.metacube.models;
/**
 * 
 * @version 1.0 July 25, 2017
 * @author Rahul Kumar
 *
 */
public class OrderPromo {
	private String orderPromoType;
	private String orderPromoDiscount;
	private String thresholdValue;
	
	public OrderPromo() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Setter method for set the Order Promo
	 * @param type
	 * @param discount
	 * @param thresholdValue
	 */
	public void setOrderPromo(String type, String discount, String thresholdValue) {
		this.orderPromoType = type;
		this.orderPromoDiscount = discount;
		this.thresholdValue = thresholdValue;
	}
	
	/**
	 * Getter method to get the type of promotion
	 * @return
	 */
	public String getType() {
		return orderPromoType;
	}
	
	/**
	 * Getter method to get the discount of promotion
	 * @return
	 */
	public String getDiscount() {
		return orderPromoDiscount;
	}
	
	/**
	 * Getter method to get the Applicable Threshold value
	 * @return
	 */
	public String getThresholdValue() {
		return thresholdValue;
	}
}
