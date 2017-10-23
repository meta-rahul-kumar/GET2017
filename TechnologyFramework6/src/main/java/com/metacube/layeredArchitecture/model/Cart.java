package main.java.com.metacube.layeredArchitecture.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart implements BaseModel {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy= GenerationType.IDENTITY) // for auto increment
	private int id;
	
	@Column(name = "cart_item_id", nullable = false)
	private int productId;
	
	@Column(name = "cart_item_name", nullable = false)
	private String name;
	
	@Column(name = "cart_item_added_by", nullable = false)
	private String addedBy;
	
	public Cart() { }
	
	public Cart(int id, int pid, String name, String addedBy) {
		setId(id);
		setProductId(pid);
		setName(name);
		setAddedBy(addedBy);
	}
	
	public void setProductId(int pid) {
		this.productId = pid;
	}
	
	public int getProductId() {
		return productId;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}
	
	public String getAddedBy() {
		return addedBy;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}