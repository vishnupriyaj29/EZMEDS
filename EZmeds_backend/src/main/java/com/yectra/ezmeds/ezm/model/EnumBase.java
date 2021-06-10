package com.yectra.ezmeds.ezm.model;

import java.util.NoSuchElementException;


public interface EnumBase<T extends Enum<T>&EnumBase<T>> {
	
	String getCode();
	
	String getValue();
	
	public static <T extends Enum<T>&EnumBase<T>> T fromCode(String code, Class<T> type) {
        for (T en : type.getEnumConstants()) {
            if (en.getCode().equals(code)) {
                return en;
            }
        }
        throw new NoSuchElementException();
    }
	
	public static <T extends Enum<T>&EnumBase<T>> T fromValue(String value, Class<T> type) { //for UI
        for (T en : type.getEnumConstants()) {
            if (en.getValue().equals(value)) {
                return en;
            }
        }
        throw new NoSuchElementException();
    }
	
}
