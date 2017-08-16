package com.metacube.facade;
import java.util.Arrays;
import java.util.Scanner;

import com.metacube.utils.Utils;

/**
 * 
 * @version 1.0 July 25, 2017
 * @author Rahul Kumar
 *
 */

public class CartFacade {
	final static String ERROR_MESSAGE_INVALID_INPUT = "It Must be an Integer and greater than 0. Please Try Again";
	public static void main(String[] args) {
		// reads all products from csv file
		ProductFacade listProduct = new ProductFacade();
		
		//Show products
		listProduct.showProducts();
		
		// reads all product_level promo codes
		ProductPromoFacade listProductPromo = new ProductPromoFacade();
		
		System.out.println("------------------------------------------------------------------------------------");
		// show product promos
		listProductPromo.showProductPromos();
		
		// reads all ORDER_level promo codes
		OrderPromoFacade listOrderPromo = new OrderPromoFacade();

		System.out.println("------------------------------------------------------------------------------------");
		// show product promos
		listOrderPromo.showOrderPromos();
		
		int totalBuyingProduct = 0;
		Utils validateByProductId = new Utils();
		UserCartFacade userCart = new UserCartFacade();
		Scanner scanner = new Scanner(System.in);
		while (totalBuyingProduct <= 0) {
			System.out.println("How Many Product do You want to buy ?");
			try {
				totalBuyingProduct = scanner.nextInt();
				if(totalBuyingProduct <= 0) {
					System.out.println(ERROR_MESSAGE_INVALID_INPUT);
				}
			}catch(Exception e) {
				System.out.println(ERROR_MESSAGE_INVALID_INPUT);
				totalBuyingProduct = 0;
				scanner.nextLine();
				continue;
			}
		}
		
		int[] productCode = new int[totalBuyingProduct];
		int[] productQuantity = new int[totalBuyingProduct];
		Arrays.fill(productCode, 0);
		Arrays.fill(productQuantity, 0);
		
		for (int iterator = 0; iterator < totalBuyingProduct; iterator++) {
			
			while (productCode[iterator] <= 0) {
				
				System.out.println("Enter Product ID :");
				try {
					productCode[iterator] = scanner.nextInt();
					
					if(!validateByProductId.validateProduct(listProduct.getProducts(), productCode[iterator])) {
						System.out.println("Invalid Product ID");
						productCode[iterator] = 0;
						continue;
					}
					if(productCode[iterator] <= 0) {
						System.out.println(ERROR_MESSAGE_INVALID_INPUT);
					}
				}catch(Exception e) {
					System.out.println(ERROR_MESSAGE_INVALID_INPUT);
					productCode[iterator] = 0;
					scanner.nextLine();
					continue;
				}
			}
			
			while (productQuantity[iterator] <= 0) {
			
				System.out.println("Enter Product Quantity");
				try {
					productQuantity[iterator] = scanner.nextInt();
					
					if(productQuantity[iterator] <= 0) {
						System.out.println(ERROR_MESSAGE_INVALID_INPUT);
					}
				}catch(Exception e) {
					System.out.println(ERROR_MESSAGE_INVALID_INPUT);
					productQuantity[iterator] = 0;
					scanner.nextLine();
					continue;
				}
			}
			userCart.addProduct(productCode[iterator], productQuantity[iterator]);
			userCart.showCart();
		}
		
		scanner.close();
		userCart.generateBill(); // to generate the bill
	}
}
