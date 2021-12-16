package com.entities;

import javax.persistence.*;

//Specifies that the class is an entity
@Entity

@SequenceGenerator(name = "Cartsequence", initialValue = 301)
@Table(name = "Cart")
public class CartEntity {

	// primary key
	@Id

	// used to generate the valaues sequencially
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Cartsequence")

	// fields of cart entity and we have declared fields as private
	private Long id;
	@Column(name = "ProductName")
	private String productName;
	@Column(name = "Quantity")
	private Integer quantity;
	@Column(name = "Price")
	private Double price;
	@Column(name = "TotalBill")
	private Double total;
	private Long custId;

	// setters n getters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	// tostring method
	@Override
	public String toString() {
		return "CartEntity [id=" + id + ", productName=" + productName + ", quantity=" + quantity + ", price=" + price
				+ ", total=" + total + ", custId=" + custId + "]";
	}

	public CartEntity(Long id, String productName, Integer quantity, Double price, Double total) {
		super();
		this.id = id;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
	}

	// non-arg constructor
	public CartEntity() {
	}

	// parameterised contructor
	public CartEntity(String productName, Integer quantity, Double price, Double total, Long custId) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
		this.custId = custId;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}
}