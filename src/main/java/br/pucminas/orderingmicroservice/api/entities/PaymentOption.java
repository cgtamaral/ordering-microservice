package br.pucminas.orderingmicroservice.api.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.pucminas.orderingmicroservice.api.enums.CardTypeEnum;

@Entity
public class PaymentOption {
	
	private Long id;
	private Customer customer;
	private String nameOnCard;
	private String cardNumber;
	private Calendar expirationDate;
	private CardTypeEnum cartType;
	
	public PaymentOption() {}
	
	
	public PaymentOption(Long id,Customer customer, String nameOnCard, String cardNumber, Calendar expirationDate,
			CardTypeEnum cartType) {
		this.id = id;
		this.customer = customer;
		this.nameOnCard = nameOnCard;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.cartType = cartType;
	}

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Column(name = "nameOnCard", nullable = false)
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	@Column(name = "cardNumber", nullable = false)
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Column(name = "expirationDate", nullable = false)
	public Calendar getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Calendar expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "cartType", nullable = false)
	public CardTypeEnum getCartType() {
		return cartType;
	}
	public void setCartType(CardTypeEnum cartType) {
		this.cartType = cartType;
	}
}
