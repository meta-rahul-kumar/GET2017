/**
 * 
 * @version 1.0 July 25, 2017
 * @author Rahul Kumar
 *
 */
public class Product {
	private String productCode;
	private String productName;
	private String productPrice;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	void setProduct(String code, String name, String price) {
		this.productCode = code;
		this.productName = name;
		this.productPrice = price;
	}
	
	String getCode() {
		return productCode;
	}
	
	String getName() {
		return productName;
	}
	
	String getPrice() {
		return productPrice;
	}
}
