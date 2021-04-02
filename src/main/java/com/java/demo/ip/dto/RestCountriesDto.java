package com.java.demo.ip.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author AdrianRojas
 * 
 *  Dto que contiene toda la información de todos los paises.
 *
 */
public class RestCountriesDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String alpha2Code;
	private String name;
	private List<CurrencyDto> currencies;

	public String getAlpha2Code() {
		return alpha2Code;
	}

	public void setAlpha2Code(String alpha2Code) {
		this.alpha2Code = alpha2Code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CurrencyDto> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<CurrencyDto> currencies) {
		this.currencies = currencies;
	}

}
