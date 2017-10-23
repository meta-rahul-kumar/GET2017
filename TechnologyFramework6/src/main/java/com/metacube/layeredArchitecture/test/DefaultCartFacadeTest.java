package main.java.com.metacube.layeredArchitecture.test;
import org.junit.*;

import main.java.com.metacube.layeredArchitecture.facade.DefaultCartFacade;

import static org.junit.Assert.*;

public class DefaultCartFacadeTest {

	@Test
	public void addProductToCartTest_true() {
		DefaultCartFacade defaultCartFacade = new DefaultCartFacade();
		int productId = 23;
		String currentUser = "rahul.ctae94@gmail.com";
		assertEquals("SUCCESS",defaultCartFacade.addProductToCart(productId, currentUser));
	}
	
}
