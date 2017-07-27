import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 
 * @version 1.0 July 25, 2017
 * @author Rahul Kumar
 *
 */
public class Products {
	final static String FILEPATH = "src/Products.csv";
	HashMap<String,Product> totalProducts = new HashMap<>();
	
	/**
	 * returns all products which is available in store
	 * @return
	 */
	HashMap<String, Product> getProducts(){
		// getter method
		return totalProducts;
	}
	
	/**
	 *	return the Product using specific ProductId 
	 * @param productId
	 * @return
	 */
	Product getProductById(String productId) {
		Product tempProductAttribute = new Product();
		String tempProductId = totalProducts.get(productId).getCode();
		String tempProductName = totalProducts.get(productId).getName();
		String tempProductPrice = totalProducts.get(productId).getPrice();
		tempProductAttribute.setProduct(tempProductId, tempProductName, tempProductPrice);
		return tempProductAttribute;
	}
	
	/**
	 * Product Constructor which reads the Products.csv file and stores it in totalProducts HashMap
	 */
	Products() {
		ReadCsv read = new ReadCsv();
		for(String lineNumber : read.ReadCsvFile(FILEPATH)) {
			StringTokenizer tokenizer = new StringTokenizer(lineNumber, "\t");
			while(tokenizer.hasMoreTokens()) {
				Product product = new Product();
				product.setProduct(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
				totalProducts.put(product.getCode(), product);
			}
		}
	}
	
	/**
	 * Show all the available products
	 */
	void showProducts() {
		System.out.println("Code \t Name \t\t\t\t Price");
		for (String key : totalProducts.keySet()) {
			System.out.println(totalProducts.get(key).getCode() + "\t" + totalProducts.get(key).getName() + "\t\t" + totalProducts.get(key).getPrice());
		}
	}
	
}
