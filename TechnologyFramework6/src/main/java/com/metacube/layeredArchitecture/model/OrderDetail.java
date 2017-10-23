package main.java.com.metacube.layeredArchitecture.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_detail")
public class OrderDetail implements BaseModel{
	
	@Id
	@Column(name = "uniqueId")
	@GeneratedValue(strategy= GenerationType.IDENTITY) // for auto increment
	private int id;
	
	@Column(name = "order_id")
	private int orderId;
	
	@Column(name = "product_id", nullable = false)
	private int productId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
	
}
