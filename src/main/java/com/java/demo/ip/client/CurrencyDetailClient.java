package com.java.demo.ip.client;

import com.java.demo.ip.Exception.ExceptionHandlerIP;
import com.java.demo.ip.dto.CurrencyDetailDto;

/**
 * 
 * @author AdrianRojas
 * 
 * interface api información de monedas
 *
 */
public interface CurrencyDetailClient {

	public CurrencyDetailDto getCurrencyDetail(String currency)throws ExceptionHandlerIP;
}
