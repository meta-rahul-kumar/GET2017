package com.metacube.models;
/**
 * 
 * @version 1.0 July 25, 2017
 * @author Rahul Kumar
 *
 */
public class ProductPromo implements BaseEntity{
	private String productPromoType;
	private String productPromoDiscount;
	private String applicableProducts;
	
	public ProductPromo() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Setter method for set the Product Promo
	 * @param type
	 * @param discount
	 * @param applicableProducts
	 */
	public void setProductPromo(String type, String discount, String applicableProducts) {
		this.productPromoType = type;
		this.productPromoDiscount = discount;
		this.applicableProducts = applicableProducts;
	}
	
	/**
	 * Getter method to get the type of promotion
	 * @return
	 */
	public String getType() {
		return productPromoType;
	}
	
	/**
	 * Getter method to get the discount of promotion
	 * @return
	 */
	public String getDiscount() {
		return productPromoDiscount;
	}
	
	/**
	 * Getter method to get the product for which promotional code is applicable
	 * @return
	 */
	public String getApplicableProducts() {
		return applicableProducts;
	}
}
