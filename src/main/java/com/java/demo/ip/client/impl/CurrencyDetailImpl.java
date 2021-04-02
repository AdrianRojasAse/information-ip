package com.java.demo.ip.client.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.java.demo.ip.Exception.ExceptionHandlerIP;
import com.java.demo.ip.client.CurrencyDetailClient;
import com.java.demo.ip.dto.CurrencyDetailDto;
import com.java.demo.ip.utils.Constant;
/**
 * 
 * @author AdrianRojas
 * 
 * Implementación para el servicio api que consulta la información sobre las monedas 
 *
 */
@Component
public class CurrencyDetailImpl implements CurrencyDetailClient {

	@Value("${app.endpoint.urlCurrencyRates}")
	private String baseUrl;

	@Value("${app.endpoint.apiKeyCurrency}")
	private String key;

	@Override
	public CurrencyDetailDto getCurrencyDetail(String currency) throws ExceptionHandlerIP {
		RestTemplate restTemplate = new RestTemplate();
		String url = baseUrl + "latest?access_key=" + key + "&symbols = " + currency;
		ResponseEntity<CurrencyDetailDto> response = restTemplate.getForEntity(url, CurrencyDetailDto.class);
		if (response.getStatusCode() != HttpStatus.OK) {
			throw new ExceptionHandlerIP(Constant.MESSAGE_ERROR_CLIENT  + response.getStatusCode());
		}
		return response.getBody();
	}

}
