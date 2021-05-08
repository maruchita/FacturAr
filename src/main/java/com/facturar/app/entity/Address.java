package com.facturar.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "address")
public class Address implements Serializable {
	
	private static final long serialVersionUID = 6378353443085899431L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
	
	@JsonIgnore
    @OneToOne(mappedBy = "address")
    private UserEntity user;
    
    private String street;
    
    private String city;
    
    private String address_type_id;
    
    private String province_id;
    
    private String country_id;

	public Address() {
		
	}
	
	public Address(Long id, UserEntity user, String street, String city, String address_type_id, String province_id,
			String country_id) {
		super();
		this.id = id;
		this.user = user;
		this.street = street;
		this.city = city;
		this.address_type_id = address_type_id;
		this.province_id = province_id;
		this.country_id = country_id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress_type_id() {
		return address_type_id;
	}

	public void setAddress_type_id(String address_type_id) {
		this.address_type_id = address_type_id;
	}

	public String getProvince_id() {
		return province_id;
	}

	public void setProvince_id(String province_id) {
		this.province_id = province_id;
	}

	public String getCountry_id() {
		return country_id;
	}

	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}

	public Long getId() {
		return id;
	}
    

}
