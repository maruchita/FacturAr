package com.facturar.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address implements Serializable {
	
	private static final long serialVersionUID = 6378353443085899431L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @OneToOne(mappedBy = "address")
    private UserEntity user;
    
    private String street;
    
    private String nro_street;

	public Address() {
		
	}

	public Address(Long id, UserEntity user, String street, String nro_street) {
		this.id = id;
		this.user = user;
		this.street = street;
		this.nro_street = nro_street;
	}



	public Long getId() {
		return id;
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

	public String getNro_street() {
		return nro_street;
	}

	public void setNro_street(String nro_street) {
		this.nro_street = nro_street;
	}
	
	
    
    

}
