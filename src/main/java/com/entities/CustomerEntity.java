package com.entities;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SequenceGenerator(name = "Customersequence", initialValue = 1)
@Table(name = "Customer")
public class CustomerEntity {

	// The @Id annotation specifies the primary key of an entity
	@Id

	// @GeneratedValue provides for the specification of generation strategies for
	// the values of primary keys.
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Customersequence")
	// fileds for customer
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;
	@Column(name = "contactno")
	private String contactNo;
	@Column(name = "DateOfBirth")
	private LocalDate doB;

	// here one customer mapped to many addresses.
	@OneToMany(cascade = CascadeType.MERGE)
	private List<AddressEntity> addressEntity;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="login")
	private Login login;
	 
	@JsonIgnore
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="profile_fk")
	Profile profile;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public LocalDate getDoB() {
		return doB;
	}

	public void setDoB(LocalDate doB) {
		this.doB = doB;
	}

	public List<AddressEntity> getAddressEntity() {
		return addressEntity;
	}

	public void setAddressEntity(List<AddressEntity> addressEntity) {
		this.addressEntity = addressEntity;
	}

	@Override
	public String toString() {
		return "CustomerEntity [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", contactNo=" + contactNo + ", doB=" + doB + ", addressEntity=" + addressEntity + "]";
	}

	public CustomerEntity(Long id, String name, String password, String email, String contactNo, LocalDate doB,
			List<AddressEntity> addressEntity) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.contactNo = contactNo;
		this.doB = doB;
		this.addressEntity = addressEntity;
	}

	public CustomerEntity() {
	}

}
