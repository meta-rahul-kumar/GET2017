package com.metacube.tests;
import static org.junit.Assert.*;

import org.junit.*;

import com.metacube.models.OrderPromo;
public class OrderPromoTest {
	OrderPromo orderPromo = new OrderPromo();
	@Test
	public void getTypeTest() {
		orderPromo.setOrderPromo("OrderFixedAmountPromotion", "100.0", "1001");
		String expected = "OrderFixedAmountPromotion";
		assertEquals(expected, orderPromo.getType()); // True Case
		expected = "OrderFixedPercentPromotion";
		assertNotEquals(expected, orderPromo.getType()); // False Case
	}
	
	@Test
	public void getDiscountTest() {
		orderPromo.setOrderPromo("OrderFixedAmountPromotion", "100.0", "1001");
		String expected = "100.0";
		assertEquals(expected, orderPromo.getDiscount()); // True Case
		expected = "10";
		assertNotEquals(expected, orderPromo.getDiscount()); // False Case
	}
	
	@Test
	public void getThresholdValueTest() {
		orderPromo.setOrderPromo("OrderFixedAmountPromotion", "100.0", "1001");
		String expected = "1001";
		assertEquals(expected, orderPromo.getThresholdValue()); // True Case
		expected = "1002";
		assertNotEquals(expected, orderPromo.getThresholdValue()); // False Case
	}
}
