package com.yectra.ezmeds.ezm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "medicine")

public class Medicine extends Persistence {
 
	@Id
	private String id;
	private String ApplNo;
	private String ProductNo;
	private String Form;
	private String Strength;
	private String ReferenceDrug;
	private String DrugName;
	private String ActiveIngredient;
	private String ReferenceStandard;

	public Medicine() {
		super();
	}

	public Medicine(String id, String applNo, String productNo, String form, String strength, String referenceDrug,
			String drugName, String activeIngredient, String referenceStandard) {
		super();
		this.id = id;
		this.ApplNo = applNo;
		this.ProductNo = productNo;
		this.Form = form;
		this.Strength = strength;
		this.ReferenceDrug = referenceDrug;
		this.DrugName = drugName;
		this.ActiveIngredient = activeIngredient;
		this.ReferenceStandard = referenceStandard;
	}

	public String getId() {
		return id;
	}

	public String getApplNo() {
		return ApplNo;
	}

	public void setApplNo(String applNo) {
		ApplNo = applNo;
	}

	public String getProductNo() {
		return ProductNo;
	}

	public void setProductNo(String productNo) {
		ProductNo = productNo;
	}

	public String getForm() {
		return Form;
	}

	public void setForm(String form) {
		Form = form;
	}

	public String getStrength() {
		return Strength;
	}

	public void setStrength(String strength) {
		Strength = strength;
	}

	public String getReferenceDrug() {
		return ReferenceDrug;
	}

	public void setReferenceDrug(String referenceDrug) {
		ReferenceDrug = referenceDrug;
	}

	public String getDrugName() {
		return DrugName;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDrugName(String drugName) {
		DrugName = drugName;
	}

	public String getActiveIngredient() {
		return ActiveIngredient;
	}

	public void setActiveIngredient(String activeIngredient) {
		ActiveIngredient = activeIngredient;
	}

	public String getReferenceStandard() {
		return ReferenceStandard;
	}

	public void setReferenceStandard(String referenceStandard) {
		ReferenceStandard = referenceStandard;
	}

	@Override
	public String toString() {
		return "Meds [id=" + id + ", ApplNo=" + ApplNo + ", ProductNo=" + ProductNo + ", Form=" + Form + ", Strength="
				+ Strength + ", ReferenceDrug=" + ReferenceDrug + ", DrugName=" + DrugName + ", ActiveIngredient="
				+ ActiveIngredient + ", ReferenceStandard=" + ReferenceStandard + "]";
	}

}
