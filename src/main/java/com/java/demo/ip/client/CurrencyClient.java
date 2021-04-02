package com.java.demo.ip.client;

import java.util.Map;

import com.java.demo.ip.Exception.ExceptionHandlerIP;
import com.java.demo.ip.dto.RestCountriesDto;
/**
 * 
 * @author AdrianRojas
 * 
 * interface CurrencyClient
 */
public interface CurrencyClient {

	public RestCountriesDto getCurrencyByCode(String countryCode) throws ExceptionHandlerIP;

	public Map<String, RestCountriesDto> getAllCountriesInfoMap() throws ExceptionHandlerIP;
}
