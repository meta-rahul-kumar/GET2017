package main.java.com.metacube.layeredArchitecture.facade;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import main.java.com.metacube.layeredArchitecture.dto.ProductDto;
import main.java.com.metacube.layeredArchitecture.model.Product;
import main.java.com.metacube.layeredArchitecture.service.OrderDetailService;

@Component("orderDetailFacade")
public class DefaultOrderDetailFacade implements OrderDetailFacade {
	@Autowired
	OrderDetailService orderDetailService;

	@Override
	public List<ProductDto> orderProducts(int orderId) {
		Iterator<Product> orderProductsIterator = orderDetailService.orderProducts(orderId).iterator();
		List<ProductDto> orderProductDto = new ArrayList<>();
		ProductDto productDto;

		while (orderProductsIterator.hasNext()) {
			Product product = orderProductsIterator.next();
			productDto = new ProductDto();
			productDto.setId(product.getId());
			productDto.setName(product.getName());
			productDto.setPrice(product.getPrice());
			productDto.setQuantity(product.getQuantity());
			productDto.setRating(product.getRating());
			productDto.setSeller(product.getSeller());
			productDto.setThumbnail(product.getThumbnail());
			orderProductDto.add(productDto);
		}

		return orderProductDto;
	}

}