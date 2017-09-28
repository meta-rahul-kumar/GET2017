package main.java.com.metacube.layeredArchitecture.dto;

public class ProductDto {
	private int id;
	private String name;
	private float price;
	private String seller;
	private String thumbnail;
	private float rating;
	private int quantity;
	
	public ProductDto() { }
	
	public ProductDto(int id, String name, float price, String seller, String thumbnail, int quantity, float rating) {
		setId(id);
		setName(name);
		setPrice(price);
		setSeller(seller);
		setThumbnail(thumbnail);
		setQuantity(quantity);
		setRating(rating);
	}
	
	public float getRating() {
		return rating;
	}
	
	public void setRating(float rating) {
		this.rating = rating;
	}
	
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