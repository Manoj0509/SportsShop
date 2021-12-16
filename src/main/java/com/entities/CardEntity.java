package com.entities;

import javax.persistence.*;

import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;

@Entity
@SequenceGenerator(name = "Cardsequence", initialValue = 701)
@Table(name = "cardentity")
public class CardEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Cardsequence")
	// fileds for card.
	private Long id;
	@Column(name = "cardName")
	private String cardName;
	@Column(name = "cardNumber")
	private String cardNumber;
	@Column(name = "expiryDate")
	private LocalDate expiryDate;
	@Column(name = "bankName")
	private String bankName;

	public CardEntity() {
		super();
	}

	public CardEntity(Long id, String cardName, String cardNumber, LocalDate expiryDate, String bankName) {
		super();
		this.id = id;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.bankName = bankName;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {

		this.expiryDate = expiryDate;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;

	}

	@Override
	public String toString() {
		return "CardEntity [id=" + id + ", cardName=" + cardName + ", cardNumber=" + cardNumber + ", expiryDate="
				+ expiryDate + ", bankName=" + bankName + "]";
	}

}