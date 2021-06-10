package com.yectra.ezmeds.ezm.model;

import java.time.LocalDateTime;



import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "prescription")
public class Prescription3 extends Persistence {
	
	private String patientId;
	private String drId;
	private String beforeBreakfast;
	private String afterBreakfast;
	private String beforeLunch;
	private String afterLunch;
	private String beforeFood;
	private String afterFood;
	private String bedtime;
	private String weekly;
	private String temporary;
	private String asPerNeed;
	
	public Prescription3() {
		super();
	}
	
	public Prescription3(String id, LocalDateTime createdTime, LocalDateTime updatedTime, String createdBy,
			String updatedBy) {
		super(id, createdTime, updatedTime, createdBy, updatedBy);
	}

	public Prescription3(String patientId, String drId, String beforeBreakfast, String afterBreakfast,
			String beforeLunch, String afterLunch, String beforeFood, String afterFood, String bedtime, String weekly,
			String temporary, String asPerNeed) {
		super();
		this.patientId = patientId;
		this.drId = drId;
		this.beforeBreakfast = beforeBreakfast;
		this.afterBreakfast = afterBreakfast;
		this.beforeLunch = beforeLunch;
		this.afterLunch = afterLunch;
		this.beforeFood = beforeFood;
		this.afterFood = afterFood;
		this.bedtime = bedtime;
		this.weekly = weekly;
		this.temporary = temporary;
		this.asPerNeed = asPerNeed;
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

	public String getBeforeBreakfast() {
		return beforeBreakfast;
	}

	public void setBeforeBreakfast(String beforeBreakfast) {
		this.beforeBreakfast = beforeBreakfast;
	}

	public String getAfterBreakfast() {
		return afterBreakfast;
	}

	public void setAfterBreakfast(String afterBreakfast) {
		this.afterBreakfast = afterBreakfast;
	}

	public String getBeforeLunch() {
		return beforeLunch;
	}

	public void setBeforeLunch(String beforeLunch) {
		this.beforeLunch = beforeLunch;
	}

	public String getAfterLunch() {
		return afterLunch;
	}

	public void setAfterLunch(String afterLunch) {
		this.afterLunch = afterLunch;
	}

	public String getBeforeFood() {
		return beforeFood;
	}

	public void setBeforeFood(String beforeFood) {
		this.beforeFood = beforeFood;
	}

	public String getAfterFood() {
		return afterFood;
	}

	public void setAfterFood(String afterFood) {
		this.afterFood = afterFood;
	}

	public String getBedtime() {
		return bedtime;
	}

	public void setBedtime(String bedtime) {
		this.bedtime = bedtime;
	}

	public String getWeekly() {
		return weekly;
	}

	public void setWeekly(String weekly) {
		this.weekly = weekly;
	}

	public String getTemporary() {
		return temporary;
	}

	public void setTemporary(String temporary) {
		this.temporary = temporary;
	}

	public String getAsPerNeed() {
		return asPerNeed;
	}

	public void setAsPerNeed(String asPerNeed) {
		this.asPerNeed = asPerNeed;
	}

	@Override
	public String toString() {
		return "Prescription [patientId=" + patientId + ", drId=" + drId + ", beforeBreakfast=" + beforeBreakfast
				+ ", afterBreakfast=" + afterBreakfast + ", beforeLunch=" + beforeLunch + ", afterLunch=" + afterLunch
				+ ", beforeFood=" + beforeFood + ", afterFood=" + afterFood + ", bedtime=" + bedtime + ", weekly="
				+ weekly + ", temporary=" + temporary + ", asPerNeed=" + asPerNeed + "]";
	}
	
	
}