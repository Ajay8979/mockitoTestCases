package com.candidjava.spring.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "UserInfo")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "country")
	private String country;
	@Column(name = "name")

	private String name;
	/*
	 * @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "add_id") private List<Address> address;
	 */
	
	private String status;
	
	

	public String getStatus() {
		return status;
	}

	public String setStatus(String status) {
		this.status = status;
		return status;
	}



	public User() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


}
