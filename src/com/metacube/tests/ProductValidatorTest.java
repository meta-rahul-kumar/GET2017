package com.metacube.tests;
import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import com.metacube.models.Product;
import com.metacube.utils.Utils;

public class ProductValidatorTest {
	Product product = new Product();
	HashMap<String,Product> productIterator;
	
	@Test(expected = NullPointerException.class)
	public void validateProduct() {
		product.setProduct("1001", "Numero Uno T-Shirt", "200.00");
		productIterator.put("1001", product);
		int productCode = 1001;
		boolean expected = true;
		assertNotEquals(expected, Utils.validateProduct(productIterator, productCode));
	}
}
