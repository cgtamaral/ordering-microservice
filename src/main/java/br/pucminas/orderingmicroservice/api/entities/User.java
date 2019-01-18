package br.pucminas.orderingmicroservice.api.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import br.pucminas.orderingmicroservice.api.dtos.UserDTO;
import br.pucminas.orderingmicroservice.api.enums.UserProfileEnum;

@Entity
public class User 
{
	private Long id;
	private String name;
	private String email;
	private String mobilePhoneNumber;
	private String cpf;
	private String password;
	private UserProfileEnum userProfile;
	private Calendar dateRegister;
	
	public User() {}
	
	public User(Long id, String name, String email, String mobilePhoneNumber, String cpf, String password, UserProfileEnum userProfile,
			Calendar dateRegister) {

		this.id = id;
		this.name = name;
		this.email = email;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.cpf = cpf;
		this.password = password;
		this.userProfile = userProfile;
		this.dateRegister = dateRegister;
	}
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "mobilePhone", nullable = false)
	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}
	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}
	
	@Column(name = "cpf", nullable = false)
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "profile", nullable = false)
	public UserProfileEnum getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(UserProfileEnum userProfile) {
		this.userProfile = userProfile;
	}
	
	@Column(name = "dateRegister", nullable = false)
	public Calendar getDateRegister() {
		return dateRegister;
	}
	public void setDateRegister(Calendar dateRegister) {
		this.dateRegister = dateRegister;
	}
	
	@Transient
	public static UserDTO convertToDTO(User user) {
		
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setEmail(user.getEmail());
		userDTO.setMobilePhoneNumber(user.getMobilePhoneNumber());
		userDTO.setCpf(user.getCpf());
		userDTO.setUserProfile(user.getUserProfile().toString());
		userDTO.setDateRegister(user.getDateRegister());
	

		return userDTO;
	}
	
}
