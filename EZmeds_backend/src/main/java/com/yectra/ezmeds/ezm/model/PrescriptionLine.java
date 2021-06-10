package com.yectra.ezmeds.ezm.model;

import java.time.LocalDateTime;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "prescriptionLine")
public class PrescriptionLine extends Persistence {
	 
@Autowired
public Medicine medicine;

@Autowired
public Prescription prescription;
	
	
	
	@Enumerated(EnumType.STRING)
	private Frequency frequency;
	
	
	private float quantity;
	private String unitOfMeasure;
	private String comments;
	private int refills;
	
	public PrescriptionLine() {
		super();}
	
	public PrescriptionLine(String id, LocalDateTime createdTime, LocalDateTime updatedTime, String createdBy,
			String updatedBy) {
		super(id, createdTime, updatedTime, createdBy, updatedBy);
		}

	public PrescriptionLine(Frequency frequency, float quantity, String unitOfMeasure, String comments, int refills) {
		super();
		this.frequency = frequency;
		this.quantity = quantity;
		this.unitOfMeasure = unitOfMeasure;
		this.comments = comments;
		this.refills = refills;
	}

	public Frequency getFrequency() {
		return frequency;
	}

	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getRefills() {
		return refills;
	}

	public void setRefills(int refills) {
		this.refills = refills;
	}

	@Override
	public String toString() {
		return "PrescriptionLine [frequency=" + frequency + ", quantity=" + quantity + ", unitOfMeasure="
				+ unitOfMeasure + ", comments=" + comments + ", refills=" + refills + "]";
	}
	
	
	







}
