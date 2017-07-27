import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class ProductValidatorTest {
	Product product = new Product();
	HashMap<String,Product> productIterator;
	ProductValidator productValidator = new ProductValidator();
	
	@Test(expected = NullPointerException.class)
	public void validateProduct() {
		product.setProduct("1001", "Numero Uno T-Shirt", "200.00");
		productIterator.put("1001", product);
		int productCode = 1001;
		boolean expected = true;
		assertNotEquals(expected, productValidator.validateProduct(productIterator, productCode));
	}
}
