package com.yectra.ezmeds.ezm.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "prescription")
public class Prescription extends Persistence{
	
	private String patientId;
	private String drId;
	
	private int prescriptionDate;
	private boolean isActive;
	
	@DBRef
	private List<PrescriptionLine> prescriptionLine;
	
	public Prescription() {
		super();
	}



	public Prescription(String id, LocalDateTime createdTime, LocalDateTime updatedTime, String createdBy,
			String updatedBy) {
		super(id, createdTime, updatedTime, createdBy, updatedBy);
	}



	public Prescription(String patientId, String drId, int prescriptionDate, boolean isActive,
			List<PrescriptionLine> prescriptionLine) {
		super();
		this.patientId = patientId;
		this.drId = drId;
		this.prescriptionDate = prescriptionDate;
		this.isActive = isActive;
		this.prescriptionLine = prescriptionLine;
	}



	public String getPatientId() {
		return patientId;
	}



	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}



	public String getDrId() {
		return drId;
	}



	public void setDrId(String drId) {
		this.drId = drId;
	}



	public int getPrescriptionDate() {
		return prescriptionDate;
	}



	public void setPrescriptionDate(int prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	public List<PrescriptionLine> getPrescriptionLine() {
		return prescriptionLine;
	}



	public void setPrescriptionLine(List<PrescriptionLine> prescriptionLine) {
		this.prescriptionLine = prescriptionLine;
	}



	@Override
	public String toString() {
		return "Prescription [patientId=" + patientId + ", drId=" + drId + ", prescriptionDate=" + prescriptionDate
				+ ", isActive=" + isActive + ", prescriptionLine=" + prescriptionLine + "]";
	}



	
	
	
	
	
	
	
}