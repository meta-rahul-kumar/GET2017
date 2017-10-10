package main.java.com.metacube.layeredArchitecture.controller;

import java.util.List;

import main.java.com.metacube.layeredArchitecture.dto.ProductDto;
import main.java.com.metacube.layeredArchitecture.facade.ProductFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/service/product")
public class ProductController {
	@Autowired
	ProductFacade productFacade;

	@RequestMapping(value = "/list", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<ProductDto> getProducts() {
		return productFacade.getAllProducts();
	}

	@RequestMapping(value = "/{productId}", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody ProductDto getProductById(@PathVariable("productId") int id) {
		return productFacade.getProductById(id);
	}

	@RequestMapping(value = "/deleteProduct/{id}", produces = "application/json", method = RequestMethod.DELETE)
	public @ResponseBody int deleteProductById(@PathVariable("id") int id) {
		return productFacade.deleteProductById(id);
	}

}