package com.lams.clinical.clinicalapp.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "id" })
public class PatientDto {

	private Integer id;
	
	@NotEmpty(message = "{validation.clinical.patient.firstname.not.empty}")
	private String firstName;
	
	@NotEmpty(message = "{validation.clinical.patient.lastname.not.empty}")
	private String lastName;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "{validation.clinical.patient.birthday.not.empty}")
	@Past
	private LocalDate birthdate;
	
	
	private String sex;
	
	private Integer phone;
	
	private String address;
	
	private String city;
	
	private String country;
	
	private String docType;
	
	private String docNumber;
	
	@NotNull
	@Size(min = 1, max = 100)
	@Email(message = "{validation.clinical.patient.email.incorret}")
	private String email;
	
	public PatientDto() {
		super();
	}

	public PatientDto(Integer id, String firstName, String lastName, LocalDate birthdate, String sex, Integer phone,
			String address, String city, String country, String docType, String docNumber, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.sex = sex;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.country = country;
		this.docType = docType;
		this.docNumber = docNumber;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
