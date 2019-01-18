package br.pucminas.orderingmicroservice.api.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.pucminas.orderingmicroservice.api.dtos.OrderDTO;
import br.pucminas.orderingmicroservice.api.dtos.SimpleOrderDTO;
import br.pucminas.orderingmicroservice.api.enums.OrderStatusEnum;

@Entity
@Table(name = "pedido")
public class Order 
{
	private Long id;
	private OrderStatusEnum orderStatusEnum;
	private ShoppingCart shoppingCart;
	private Delivery delivery;
	private Double subTotal;
	
	public Order() {}
	
	public Order(Long id, OrderStatusEnum orderStatusEnum, ShoppingCart shoppingCart, Delivery delivery,
			Double subTotal) {
		this.id = id;
		this.orderStatusEnum = orderStatusEnum;
		this.shoppingCart = shoppingCart;
		this.delivery = delivery;
		this.subTotal = subTotal;
	}
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	public OrderStatusEnum getOrderStatusEnum() {
		return orderStatusEnum;
	}
	public void setOrderStatusEnum(OrderStatusEnum orderStatusEnum) {
		this.orderStatusEnum = orderStatusEnum;
	}
	
	@OneToOne
	@JoinColumn(name = "shoppingCart_id", nullable = false)
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
	@OneToOne
	@JoinColumn(name = "delivery_id", nullable = false)
	public Delivery getDelivery() {
		return delivery;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	
	@Column(name = "subTotal", nullable = false)
	public Double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public static List<SimpleOrderDTO> convertToDTO(List<Order> pedidos) {
		List<SimpleOrderDTO> retorno = new ArrayList<SimpleOrderDTO>();
		for (Order order : pedidos) 
		{
			SimpleOrderDTO simpleOrder = new SimpleOrderDTO();
			simpleOrder.setId(order.getId());
			simpleOrder.setCustomerId(order.getDelivery().getDeliveryAddress().getCustomer().getId());
			simpleOrder.setOrderStatus(order.getOrderStatusEnum().toString());
			simpleOrder.setSubTotal(order.getSubTotal());
			
			retorno.add(simpleOrder);
		}
		
		return retorno;
	}

	@Transient
	public static OrderDTO convertToDTO(Order order) 
	{
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setId(order.getId());
		orderDTO.setCustomerId(order.getDelivery().getDeliveryAddress().getCustomer().getId());
		orderDTO.setShoppingCart(ShoppingCart.convertToDTO(order.getShoppingCart()));
		orderDTO.setDelivery(Delivery.convertToDTO(order.getDelivery()));
		orderDTO.setOrderStatus(order.getOrderStatusEnum().toString());
		orderDTO.setSubTotal(order.getSubTotal());
				
		return orderDTO;
	}
}
