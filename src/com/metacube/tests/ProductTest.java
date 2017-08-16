package com.metacube.tests;
import static org.junit.Assert.*;

import org.junit.*;

import com.metacube.models.Product;
public class ProductTest {
	Product product = new Product();
	@Test
	public void getTypeTest() {
		product.setProduct("1001", "Numero Uno T-Shirt", "200.00");
		String expected = "Numero Uno T-Shirt";
		assertEquals(expected, product.getName()); // True Case
		expected = "Numero Uno Shirt";
		assertNotEquals(expected, product.getName()); // False Case
	}
	
	@Test
	public void getCodeTest() {
		product.setProduct("1001", "Numero Uno T-Shirt", "200.00");
		String expected = "1001";
		assertEquals(expected,product.getCode()); // True Case
		expected = "10";
		assertNotEquals(expected, product.getCode()); // False Case
	}
	
	@Test
	public void getPriceTest() {
		product.setProduct("1001", "Numero Uno T-Shirt", "200.00");
		String expected = "200.00";
		assertEquals(expected, product.getPrice()); // True Case
		expected = "100.00";
		assertNotEquals(expected, product.getPrice()); // False Case
	}
}
