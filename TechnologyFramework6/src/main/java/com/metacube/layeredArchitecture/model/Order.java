package main.java.com.metacube.layeredArchitecture.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order implements BaseModel{
	
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY) // for auto increment
	private int id;
	
	@Column(name = "order_by", nullable = false)
	private String orderBy;
	
	@Column(name = "order_date", nullable = false)
	private Timestamp orderDate;
	
	@Column(name = "order_total", nullable = false)
	private Float orderTotal;
	
	public Order() { }
	
	public Order(int id, String by, Timestamp date, Float totalAmount) {
		setId(id);
		setOrderBy(by);
		setOrderDate(date);
		setOrderTotal(totalAmount);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public Float getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(Float orderTotal) {
		this.orderTotal = orderTotal;
	}	
}
