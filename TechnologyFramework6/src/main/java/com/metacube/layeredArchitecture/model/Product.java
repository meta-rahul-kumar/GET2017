package main.java.com.metacube.layeredArchitecture.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements BaseModel {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy= GenerationType.IDENTITY) // for auto increment
	private int id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "price", nullable = false)
	private float price;
	
	@Column(name = "seller", nullable = false)
	private String seller;
	
	@Column(name = "thumbnail", nullable = false)
	private String thumbnail;
	
	@Column(name = "rating", nullable = false)
	private float rating;
	
	@Column(name = "quantity", nullable = false)
	private int quantity;
	
//	@Column(name = "xyz", nullable = false)
//	private int xyz;
	
	public Product() { }
	
	public Product(int id, String name, float price, String seller, String thumbnail, int quantity, float rating) {
		setId(id);
		setName(name);
		setPrice(price);
		setSeller(seller);
		setThumbnail(thumbnail);
		setQuantity(quantity);
		setRating(rating);
		//setXyz(xyz);
	}
	
	public float getRating() {
		return rating;
	}
	
	public void setRating(float rating) {
		this.rating = rating;
	}
	
//	public int getXyz() {
//		return xyz;
//	}
//	
//	public void setXyz(int xyz) {
//		this.xyz = xyz;
//	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
}