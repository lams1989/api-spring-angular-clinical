package com.lams.clinical.clinicalapp.beans;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 3, max = 20, message = "the registry me must be between 3 and 20 characters")
	private String name;
	
	@Size(min = 3, max = 20, message = "the registry me must be between 3 and 20 characters")
	private String lastName;
	
	private LocalDate birthdate;
	
	private String sex;
	
	private Integer phone;
	
	private String address;
	
	private String city;
	
	private String country;
	
	private String docType;
	
	private String docNumber;

	public Cliente(Integer id,
			@Size(min = 3, max = 20, message = "the registry me must be between 3 and 20 characters") String name,
			@Size(min = 3, max = 20, message = "the registry me must be between 3 and 20 characters") String lastName,
			LocalDate birthdate, String sex, Integer phone, String address, String city, String country, String docType,
			String docNumber) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.sex = sex;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.country = country;
		this.docType = docType;
		this.docNumber = docNumber;
	}

	public Cliente() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getDocNumber() {
		return docNumber;
	}

	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}
	
	

}
