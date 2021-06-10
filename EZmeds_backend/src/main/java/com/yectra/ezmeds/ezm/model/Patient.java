package com.yectra.ezmeds.ezm.model;

import java.time.LocalDateTime;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Document(collection = "patient")
@JsonInclude(Include.NON_NULL)
public class Patient extends Persistence {

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNo;
	
	public Patient() {
		super();
	}

	public Patient(String id, LocalDateTime createdTime, LocalDateTime updatedTime, String createdBy,
			String updatedBy) {
		super(id, createdTime, updatedTime, createdBy, updatedBy);
	}

	public Patient(String firstName, String lastName, String email, String phoneNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Patient [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNo="
				+ phoneNo + "]";
	}
	
	
}
