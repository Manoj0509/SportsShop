package com.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "productsequence", initialValue = 201)
@Table(name = "products")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productsequence")
	// fields of productEntity
	private Long id;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "product_category")
	private String category;
	@Column(name = "product_description")
	private String description;
	@Column(name = "product_brand")
	private String brand;
	@Column(name = "product_colour")
	private String colour;
	@Column(name = "product_size")
	private String size;
	@Column(name = "product_mrp")
	private Double mrp;
	@Column(name = "product_discount")
	private Double priceAfterDiscount;
	@Column(name = "in_stock")
	private Boolean inStock;
	@Column(name = "expected_delivery")
	private LocalDate expectedDelivery;

	// non-arg constructor
	public ProductEntity() {

	}

	// parameterized constructor
	public ProductEntity(Long id, String productName, String category, String description, String brand, String colour,
			String size, Double mrp, Double priceAfterDiscount, Boolean inStock, LocalDate expectedDelivery) {
		super();
		this.id = id;
		this.productName = productName;
		this.category = category;
		this.description = description;
		this.brand = brand;
		this.colour = colour;
		this.size = size;
		this.mrp = mrp;
		this.priceAfterDiscount = priceAfterDiscount;
		this.inStock = inStock;
		this.expectedDelivery = expectedDelivery;
	}

	// setter and getter methods
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Double getMrp() {
		return mrp;
	}

	public void setMrp(Double mrp) {
		this.mrp = mrp;
	}

	public Double getPriceAfterDiscount() {
		return priceAfterDiscount;
	}

	public void setPriceAfterDiscount(Double priceAfterDiscount) {
		this.priceAfterDiscount = priceAfterDiscount;
	}

	public Boolean getInStock() {
		return inStock;
	}

	public void setInStock(Boolean inStock) {
		this.inStock = inStock;
	}

	public LocalDate getExpectedDelivery() {
		return expectedDelivery;
	}

	public void setExpectedDelivery(LocalDate expectedDelivery) {
		this.expectedDelivery = expectedDelivery;
	}

	// toString method
	@Override
	public String toString() {
		return "ProductEntity [productId=" + id + ", productName=" + productName + ", category=" + category
				+ ", description=" + description + ", brand=" + brand + ", colour=" + colour + ", size=" + size
				+ ", mrp=" + mrp + ", priceAfterDiscount=" + priceAfterDiscount + ", inStock=" + inStock
				+ ", expectedDelivery=" + expectedDelivery + "]";
	}
}