package com.java.demo.ip.client.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.java.demo.ip.Exception.ExceptionHandlerIP;
import com.java.demo.ip.client.CountryClient;
import com.java.demo.ip.dto.IpCountryDto;
import com.java.demo.ip.utils.Constant;

/**
 * 
 * @author AdrianRojas
 *
 *Implemantación del servicio api que consulta la geolocalización de la ip
 */
@Component
public class CountryClienteImpl implements CountryClient {

	@Value("${app.endpoint.urlCountry}")
	private String baseUrl;

	@Override
	public IpCountryDto getCountryDetail(String ip) throws ExceptionHandlerIP {
		RestTemplate restTemplate = new RestTemplate();
		String url = baseUrl + "ip?" + ip;
		ResponseEntity<IpCountryDto> response = restTemplate.getForEntity(url, IpCountryDto.class);
		if (response.getStatusCode() != HttpStatus.OK) {
			throw new ExceptionHandlerIP(Constant.MESSAGE_ERROR_CLIENT + response.getStatusCode());
		}
		return response.getBody();
	}

	

}
