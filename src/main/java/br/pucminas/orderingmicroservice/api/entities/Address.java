package br.pucminas.orderingmicroservice.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address {
	
	private Long id;
	private Customer customer;
	private String fullName;
	private String countryRegion;
	private String streetAddress;
	private String city;
	private String stateProvinceRegion;
	private String zipCode;
	private String deliveryInstructions;
	
	public Address() {}
	
	public Address(Long id, Customer customer, String fullName, String countryRegion, String streetAddress, String city, String stateProvinceRegion, 
			String zipCode, String deliveryInstructions) {
		this.id = id;
		this.customer = customer;
		this.fullName = fullName;
		this.countryRegion = countryRegion;
		this.streetAddress = streetAddress;
		this.city = city;
		this.stateProvinceRegion = stateProvinceRegion;
		this.zipCode = zipCode;
		this.deliveryInstructions = deliveryInstructions;
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
	
	@Column(name = "fullName", nullable = false)
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@Column(name = "countryRegion", nullable = false)
	public String getCountryRegion() {
		return countryRegion;
	}
	public void setCountryRegion(String countryRegion) {
		this.countryRegion = countryRegion;
	}
	
	@Column(name = "streetAddress", nullable = false)
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	@Column(name = "city", nullable = false)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name = "stateProvinceRegion", nullable = false)
	public String getStateProvinceRegion() {
		return stateProvinceRegion;
	}
	public void setStateProvinceRegion(String stateProvinceRegion) {
		this.stateProvinceRegion = stateProvinceRegion;
	}
	
	@Column(name = "zipCode", nullable = false)
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	@Column(name = "deliveryInstructions")
	public String getDeliveryInstructions() {
		return deliveryInstructions;
	}
	public void setDeliveryInstructions(String deliveryInstructions) {
		this.deliveryInstructions = deliveryInstructions;
	}
	
}
