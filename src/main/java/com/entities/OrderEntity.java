package com.entities;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "Ordersequence", initialValue = 501)
@Table(name = "orderss")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Ordersequence")
	// fields for order
	private Long id;
	@Column(name = "amount")
	private Double amount;
	@Column(name = "ProductName")
	private String productName;
	@Column(name = "billingDate")
	private String billingDate;
	@Column(name = "paymentMethod")
	private String paymentMethod;
	private Long custId;

	public OrderEntity(Long id, Double amount, String productName, String billingDate, String paymentMethod,
			Long custId) {
		super();
		this.id = id;
		this.amount = amount;
		this.productName = productName;
		this.billingDate = billingDate;
		this.paymentMethod = paymentMethod;
		this.custId = custId;
	}

	public OrderEntity(Double amount, String billingDate, String paymentMethod, String productName, Long custId) {
		super();
		this.amount = amount;
		this.billingDate = billingDate;
		this.paymentMethod = paymentMethod;
		this.productName = productName;
		this.custId = custId;
	}

	public OrderEntity() {
		super();
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(String localDate) {
		this.billingDate = localDate;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", amount=" + amount + ", productName=" + productName + ", billingDate="
				+ billingDate + ", paymentMethod=" + paymentMethod + ", custId=" + custId + "]";
	}

	public void setBillingDate(LocalDate parse) {
		// TODO Auto-generated method stub

	}

	public void setCartEntity(CartEntity cartEntity) {
		// TODO Auto-generated method stub

	}

}