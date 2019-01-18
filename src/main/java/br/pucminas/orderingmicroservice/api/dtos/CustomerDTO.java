package br.pucminas.orderingmicroservice.api.dtos;

public class CustomerDTO {
	
	private Long id;
	private UserDTO user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
}
