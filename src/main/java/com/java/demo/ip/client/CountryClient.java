package com.java.demo.ip.client;

import com.java.demo.ip.Exception.ExceptionHandlerIP;
import com.java.demo.ip.dto.IpCountryDto;
/**
 * 
 * @author AdrianRojas
 * 
 * interface api consulta geolocalización de IP
 */
public interface CountryClient {

	public IpCountryDto getCountryDetail(String ip) throws ExceptionHandlerIP;

}
