package com.yectra.ezmeds.ezm.model;




public enum Frequency implements EnumBase<Frequency> {
	
	
	
	BBF("beforeBreakfast"),
	ABF("afterBreakfast"),
	BL("beforeLunch"),
	AL("afterLunch"),
	BF("beforeFood"),
	AF("afterFood"),
	BT("bedtime"),
	WE("weekly"),
	TE("temporary"),
	ASP("asPerNeed");
	
	public final String value;

	private Frequency(String value) {
		this.value = value;
	}
	
	@Override
	public String getCode() {
		return this.value;
	}

	@Override
	public String getValue() {
		return this.value;
	}
	
	
	
}