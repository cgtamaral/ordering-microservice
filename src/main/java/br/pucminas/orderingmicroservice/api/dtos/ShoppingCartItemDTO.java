package br.pucminas.orderingmicroservice.api.dtos;

public class ShoppingCartItemDTO {
	
	private Long id;
	private BookDTO book;
	private Integer quantity;
	
	public ShoppingCartItemDTO() {}
	
	public ShoppingCartItemDTO(Long id, BookDTO book, Integer quantity) {
		super();
		this.id = id;
		this.book = book;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BookDTO getBook() {
		return book;
	}

	public void setBook(BookDTO book) {
		this.book = book;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
