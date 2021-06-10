package com.yectra.ezmeds.ezm.model;


import java.time.LocalDateTime;
import java.util.List;


import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Document(collection = "doctor")
@JsonInclude(Include.NON_NULL)
public class Doctor extends Persistence {

	private String firstName;
	private String lastName;
	private String email;
	private String specialization;
	
	@DBRef
	private List<Patient> patient;

	public Doctor() {
		super();
	}

	public Doctor(String id, LocalDateTime createdTime, LocalDateTime updatedTime, String createdBy, String updatedBy) {
		super(id, createdTime, updatedTime, createdBy, updatedBy);
	}

	public Doctor(String firstName, String lastName, String email, String specialization, List<Patient> patient) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.specialization = specialization;
		this.patient = patient;
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

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public List<Patient> getPatient() {
		return patient;
	}

	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Doctor [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", specialization="
				+ specialization + ", patient=" + patient + "]";
	}
	
}
	
	
	
	

