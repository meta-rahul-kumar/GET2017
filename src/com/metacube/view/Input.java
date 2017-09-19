package com.metacube.view;
import java.util.Arrays;
import java.util.Scanner;
import com.metacube.facade.ProductFacade;
import com.metacube.utils.Utils;

/**
 * Class Takes the input from the user
 * @author Rahul Kumar
 *
 */
public class Input {
	final static String ERROR_MESSAGE_INVALID_INPUT = "Please enter a valid product";
	private static Input input;
	
	/**
	 * Ensure only single instance of class is created
	 * 
	 * @return Product Controller object
	 */
	public static Input getInstance() {

		if (input == null) {
			synchronized (Input.class) {
				if (input == null) {
					input = new Input();
				}

			}
		}

		return input;
	}
	/**
	 * empty UserCart Constructor
	 */
	private Input(){
		
	}
	
	/**
	 * Method takes the Number total product user want to buy.
	 * @return
	 */
	public int setTotalBuyingProducts() {
		int totalBuyingProduct = 0;
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
		return totalBuyingProduct;
	}
	
	/**
	 * method takes all the Product Code and Respective Quantity for all Product which user wants to buy.
	 * @param totalBuyingProduct
	 */
	public void getProductsCodeAndQuantity(int totalBuyingProduct) {
		Scanner scanner = new Scanner(System.in);
		int[] productCode = new int[totalBuyingProduct];
		int[] productQuantity = new int[totalBuyingProduct];
		Arrays.fill(productCode, 0);
		Arrays.fill(productQuantity, 0);
		
		for (int iterator = 0; iterator < totalBuyingProduct; iterator++) {
			
			while (productCode[iterator] <= 0) {
				
				System.out.println("Enter Product ID :");
				try {
					productCode[iterator] = scanner.nextInt();
					
					if(!Utils.validateProduct(ProductFacade.getInstance().getAllProducts(), productCode[iterator])) {
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
			Output.getInstance().addProduct(productCode[iterator], productQuantity[iterator]);
			Output.getInstance().showCart();
		}
		scanner.close();
	}
}
