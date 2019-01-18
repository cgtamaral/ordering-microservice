package br.pucminas.orderingmicroservice.api.dtos;

public class DeliveryDTO {
	
	private Long id;
	private AddressDTO deliveryAddress;
	private String deliveryType;
	private String deliveryStatus;
	private PaymentDTO payment;
	private Double price;
	
	public DeliveryDTO() {}
	
	public DeliveryDTO(Long id, AddressDTO deliveryAddress, String deliveryType,
			String deliveryStatus, PaymentDTO payment, Double price) {
		this.id = id;
		this.deliveryAddress = deliveryAddress;
		this.deliveryType = deliveryType;
		this.deliveryStatus = deliveryStatus;
		this.payment = payment;
		this.price = price;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public AddressDTO getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(AddressDTO deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public PaymentDTO getPayment() {
		return payment;
	}
	public void setPayment(PaymentDTO payment) {
		this.payment = payment;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
