package br.pucminas.orderingmicroservice.api.dtos;

public class OrderDTO 
{
	private Long id;
	private Long customerId;
	private String orderStatus;
	private ShoppingCartDTO shoppingCart;
	private DeliveryDTO delivery;
	private Double subTotal;
	
	public OrderDTO() {}
	
	public OrderDTO(Long id, Long customerId, String orderStatus, ShoppingCartDTO shoppingCart, DeliveryDTO delivery,
			Double subTotal) {
		this.id = id;
		this.orderStatus = orderStatus;
		this.shoppingCart = shoppingCart;
		this.delivery = delivery;
		this.subTotal = subTotal;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public ShoppingCartDTO getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCartDTO shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	public DeliveryDTO getDelivery() {
		return delivery;
	}
	public void setDelivery(DeliveryDTO delivery) {
		this.delivery = delivery;
	}
	public Double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

}
