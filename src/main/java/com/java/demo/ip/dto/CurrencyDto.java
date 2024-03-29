package com.java.demo.ip.dto;

import java.io.Serializable;
/**
 * 
 * @author AdrianRojas
 * 
 * dto que contiene iinformación de la ciudad de la ip
 *
 */

public class CurrencyDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String code;
    private String name;
    private String symbol;
    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
    
    
}
