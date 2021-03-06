package br.pucminas.orderingmicroservice.api.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import br.pucminas.orderingmicroservice.api.dtos.ShoppingCartItemDTO;

@Entity
public class ShoppingCartItem 
{
	private Long id;
	private ShoppingCart shoppingCart;
	private Book book;
	private Integer quantity;
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shoppingCart_id", nullable = false)
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	@Column(name = "quantity", nullable = false)
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@Transient
	public static List<ShoppingCartItemDTO> convertToDTO(List<ShoppingCartItem> itemsShoppingCart)
	{
		List<ShoppingCartItemDTO> retorno = new ArrayList<ShoppingCartItemDTO>();
		for (ShoppingCartItem item : itemsShoppingCart)
		{ 
			ShoppingCartItemDTO itemDTO = new ShoppingCartItemDTO();
			itemDTO.setId(item.getId());
			itemDTO.setBook(Book.convertToDTO(item.getBook()));
			itemDTO.setQuantity(item.getQuantity());
			
			retorno.add(itemDTO);
		}
		return retorno;
	}
}
