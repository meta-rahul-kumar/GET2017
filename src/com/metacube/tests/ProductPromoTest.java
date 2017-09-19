package com.metacube.tests;
import static org.junit.Assert.*;

import org.junit.*;

import com.metacube.models.ProductPromo;
public class ProductPromoTest {
	ProductPromo productPromo = new ProductPromo();
	@Test
	public void getTypeTest() {
		productPromo.setProductPromo("OrderFixedAmountPromotion", "100.0", "1001");
		String expected = "OrderFixedAmountPromotion";
		assertEquals(expected, productPromo.getType()); // True Case
		expected = "OrderFixedPercentPromotion";
		assertNotEquals(expected, productPromo.getType()); // False Case
	}
	
	@Test
	public void getDiscountTest() {
		productPromo.setProductPromo("OrderFixedAmountPromotion", "100.0", "1001");
		String expected = "100.0";
		assertEquals(expected, productPromo.getDiscount()); // True Case
		expected = "10";
		assertNotEquals(expected, productPromo.getDiscount()); // False Case
	}
	
	@Test
	public void getApplicableProductsTest() {
		productPromo.setProductPromo("OrderFixedAmountPromotion", "100.0", "1001");
		String expected = "1001";
		assertEquals(expected, productPromo.getApplicableProducts()); // True Case
		expected = "1002";
		assertNotEquals(expected, productPromo.getApplicableProducts()); // False Case
	}
}
