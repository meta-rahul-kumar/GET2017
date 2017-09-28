package main.java.com.metacube.layeredArchitecture.facade;

import java.util.ArrayList;
import java.util.List;

import main.java.com.metacube.layeredArchitecture.dto.ProductDto;
import main.java.com.metacube.layeredArchitecture.model.Product;
import main.java.com.metacube.layeredArchitecture.service.ProductService;

public class DefaultProductFacade implements ProductFacade {
	ProductService productService;
	
	public DefaultProductFacade(ProductService productService) {
		this.productService = productService;
	}

	public List<ProductDto> getAllProducts() {
		List<ProductDto> productDtoList = new ArrayList<>();

		for (Product product : productService.getAllProducts()) {
			productDtoList.add(modelToDto(product));
		}

		return productDtoList;
	}
	
	public ProductDto getProductById(int id) {
		return modelToDto(productService.getProductById(id));
	}

	private ProductDto modelToDto(Product product) {
		if (product == null) {
			return null;
		}
		
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		productDto.setSeller(product.getSeller());
		productDto.setThumbnail(product.getThumbnail());
		productDto.setQuantity(product.getQuantity());
		productDto.setRating(product.getRating());
		return productDto;
	}
	
	protected Product dtoToModel(ProductDto productDto) {
		if (productDto == null) {
			return null;
		}
		
		Product product = new Product();
		product.setId(productDto.getId());
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setSeller(productDto.getSeller());
		product.setThumbnail(productDto.getThumbnail());
		product.setQuantity(productDto.getQuantity());
		product.setRating(productDto.getRating());
		return product;
	}

	@Override
	public int deleteProductById(int id) {
		return productService.deleteProductById(id);
	}
}