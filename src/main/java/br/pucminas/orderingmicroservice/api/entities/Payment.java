package br.pucminas.orderingmicroservice.api.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {
	
	private Long id;
	private String nameOnCard;
	private String cardNumber;
	private Calendar expirationDate;
	private String giftCardOrPromotionalCode;
	private Integer numberOfInstallments;
		
	public Payment(Long id, String nameOnCard, String cardNumber, Calendar expirationDate,
			String giftCardOrPromotionalCode, Integer numberOfInstallments) {
		this.id = id;
		this.nameOnCard = nameOnCard;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.giftCardOrPromotionalCode = giftCardOrPromotionalCode;
		this.numberOfInstallments = numberOfInstallments;
	}
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	@Column(name = "giftCardOrPromotionalCode", nullable = true)
	public String getGiftCardOrPromotionalCode() {
		return giftCardOrPromotionalCode;
	}
	public void setGiftCardOrPromotionalCode(String giftCardOrPromotionalCode) {
		this.giftCardOrPromotionalCode = giftCardOrPromotionalCode;
	}
	
	@Column(name = "numberOfInstallments", nullable = false)
	public Integer getNumberOfInstallments() {
		return numberOfInstallments;
	}
	public void setNumberOfInstallments(Integer numberOfInstallments) {
		this.numberOfInstallments = numberOfInstallments;
	}
}
