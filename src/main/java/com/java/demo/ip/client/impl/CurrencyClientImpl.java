package com.java.demo.ip.client.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.java.demo.ip.Exception.ExceptionHandlerIP;
import com.java.demo.ip.client.CurrencyClient;
import com.java.demo.ip.dto.RestCountriesDto;
import com.java.demo.ip.utils.Constant;
/**
 * 
 * @author Asesoftware
 * 
 * Implementación de client currency para el consumo de la api de consulta de imformacion de paises
 */
@Component
public class CurrencyClientImpl implements CurrencyClient {

	@Value("${app.endpoint.urlCurrency}")
	private String baseUrl;

	@Override
	public RestCountriesDto getCurrencyByCode(String countryCode) throws ExceptionHandlerIP {
		RestTemplate restTemplate = new RestTemplate();
		String url = baseUrl + "alpha/" + countryCode;
		ResponseEntity<RestCountriesDto> response = restTemplate.getForEntity(url, RestCountriesDto.class);
		if (response.getStatusCode() != HttpStatus.OK) {
			throw new ExceptionHandlerIP(Constant.MESSAGE_ERROR_CLIENT  + response.getStatusCode());
		}
		return response.getBody();
	}

	@Cacheable(Constant.CACHE_ALL_COUNTRIES)
	public Map<String, RestCountriesDto> getAllCountriesInfoMap() throws ExceptionHandlerIP {
		Map<String, RestCountriesDto> countriesInfoMap = new HashMap<>();
		RestTemplate restTemplate = new RestTemplate();
		String url = baseUrl + "all";
		ResponseEntity<RestCountriesDto[]> response = restTemplate.getForEntity(url, RestCountriesDto[].class);
		if (response.getStatusCode() != HttpStatus.OK) {
			throw new ExceptionHandlerIP(Constant.MESSAGE_ERROR_CLIENT + response.getStatusCode());
		}
		List<RestCountriesDto> list = Arrays.asList(response.getBody());
		list.forEach(countryDto -> countriesInfoMap.put(countryDto.getAlpha2Code(), countryDto));
		return countriesInfoMap;

	}

}
