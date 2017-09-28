package main.java.com.metacube.layeredArchitecture.controller;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import main.java.com.metacube.layeredArchitecture.dao.product.JdbcProductDao;
import main.java.com.metacube.layeredArchitecture.dto.ProductDto;
import main.java.com.metacube.layeredArchitecture.facade.DefaultProductFacade;
import main.java.com.metacube.layeredArchitecture.facade.ProductFacade;
import main.java.com.metacube.layeredArchitecture.model.Product;
import main.java.com.metacube.layeredArchitecture.service.DefaultProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import main.java.com.metacube.layeredArchitecture.spring.Factory;

@Path("/product")
public class ProductController {
	ProductFacade productFacade;

	public ProductController() {
		productFacade = Factory.getApplicationContext().getBean("productFacade",ProductFacade.class);
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProducts() {
		return Response.status(Response.Status.OK).entity(productFacade.getAllProducts()).build();
	}
	
	@GET
	@Path("/get-product-by-id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductByID(@PathParam("id") int id) {
		return Response.status(Response.Status.OK).entity(productFacade.getProductById(id)).build();
	}
	
	@GET
	@Path("/rahul")
	@Produces(MediaType.TEXT_PLAIN)
	public String getUsers() {
		return "Hello";
	}
	
	@DELETE
	@Path("/delete/{id}")
	public Response deleteUserById(@PathParam("id") int id) {
		int result = productFacade.deleteProductById(id);
		if (result == 0) {
			return Response.status(Response.Status.OK).entity("Error in product Deletion").build();
		} else {
			return Response.status(Response.Status.OK).entity("Product Delete with ID :" + id).build();
		}
	}
}