import java.util.HashMap;

/**
 * class checks that a product is exists in all the product with specific id
 * @version 1.0 July 25, 2017
 * @author Rahul Kumar
 *
 */
public class ProductValidator {

	/**
	 * validate the product
	 * false - product does not exists
	 * true - product exists
	 * @param productIterator
	 * @param productCode
	 * @return
	 */
	boolean validateProduct(HashMap<String,Product> productIterator, int productCode) {
		return productIterator.containsKey(productCode+"");
	}
}
