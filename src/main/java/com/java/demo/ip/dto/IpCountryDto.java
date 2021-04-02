package com.java.demo.ip.dto;

import java.io.Serializable;

/**
 * 
 * @author AdrianRojas
 * 
 * dto que tiene información de la geolocalización de la ip
 *
 */
public class IpCountryDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String countryCode;
	private String countryCode3;
	private String countryName;
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryCode3() {
		return countryCode3;
	}
	public void setCountryCode3(String countryCode3) {
		this.countryCode3 = countryCode3;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	
}
