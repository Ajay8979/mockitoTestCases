package com.candidjava.spring.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.candidjava.spring.Enum.Gender;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "UserInfo")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User implements Serializable {

	private static final long serialVersionUID = 5409480944729921055L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "country")
	private String country;
	@Column(name = "name")

	private String name;

	@Enumerated(EnumType.ORDINAL)
	@Column(name="gender")
	private Gender gender;
	/*
	 * @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "add_id") private List<Address> address;
	 */
//	@Enumerated(EnumType.STRING)
	private String status;

//	@Enumerated(EnumType.STRING)
	// @Column(name = "Gender")
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

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
