package com.java.demo.ip.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.java.demo.ip.Exception.ExceptionHandlerIP;
import com.java.demo.ip.client.CountryClient;
import com.java.demo.ip.client.CurrencyClient;
import com.java.demo.ip.client.CurrencyDetailClient;
import com.java.demo.ip.daos.IpBanDao;
import com.java.demo.ip.dto.CountryDto;
import com.java.demo.ip.dto.CurrencyDetailDto;
import com.java.demo.ip.dto.IpCountryDto;
import com.java.demo.ip.dto.Response;
import com.java.demo.ip.dto.RestCountriesDto;
import com.java.demo.ip.entities.IpBan;
import com.java.demo.ip.service.IPService;
import com.java.demo.ip.utils.Constant;
import com.java.demo.ip.utils.Utils;

@Service
public class IPImpl implements IPService {

	@Autowired
	private CountryClient countryClient;

	@Autowired
	private CurrencyClient currencyClient;

	@Autowired
	private CurrencyDetailClient currencyDetClient;

	@Autowired
	private IpBanDao ipBanDao;

	@Override
	public Response getCountryInfo(String ip) {
		Response response = new Response();
		CountryDto countryDto = new CountryDto();
		try {
			if (!Utils.validateFormatIp(ip)) {
				throw new ExceptionHandlerIP(Constant.IP_FORMAT_INVALID);
			}
			if (!isBanned(ip)) {
				IpCountryDto ipCountryDto = countryClient.getCountryDetail(ip);
				getCurrencyByCountry(ipCountryDto, countryDto);
				setResponse(Constant.STATUS_SUCCESS, "", false, countryDto, response);
			} else {
				throw new ExceptionHandlerIP(Constant.IP_IS_BAN);
			}

		} catch (ExceptionHandlerIP e) {
			setResponse(Constant.STATUS_FAIL, e.getMessage(), true, null, response);
		} catch (HttpClientErrorException e) {
			setResponse(Constant.STATUS_FAIL, Constant.MESSAGE_ERROR_INFO_NOT_FOUND, true, null, response);
		} catch (Exception e) {
			setResponse(Constant.STATUS_FAIL, Constant.MESSAGE_ERROR_UNEXPECTED_OCURRED, true, null, response);
		}

		return response;
	}

	private void getCurrencyByCountry(IpCountryDto ipCountryDto, CountryDto countryDto) throws ExceptionHandlerIP {
		if (ipCountryDto != null) {
			countryDto.setCountryName(ipCountryDto.getCountryName());
			countryDto.setIsoCode(ipCountryDto.getCountryCode3());
			Map<String, RestCountriesDto> countryMap = currencyClient.getAllCountriesInfoMap();
			RestCountriesDto currencyCountry = null;
			if (countryMap != null) {
				currencyCountry = countryMap.get(ipCountryDto.getCountryCode());
			} else {
				currencyCountry = currencyClient.getCurrencyByCode(ipCountryDto.getCountryCode());
			}
			getCurrencyRate(currencyCountry, countryDto);
		} else {
			throw new ExceptionHandlerIP(Constant.MESSAGE_ERROR_COUNTRY);
		}
	}

	private void getCurrencyRate(RestCountriesDto currencyCountry, CountryDto countryDto) throws ExceptionHandlerIP {
		if (currencyCountry != null) {
			countryDto.setCurrencyName(currencyCountry.getName());
			String currencyCode = currencyCountry.getCurrencies().get(0) != null
					? currencyCountry.getCurrencies().get(0).getCode()
					: " ";
			if (!currencyCode.isEmpty()) {
				CurrencyDetailDto currencyDetail = currencyDetClient.getCurrencyDetail(currencyCode);
				if (currencyDetail != null) {
					Double currencyValue = currencyDetail.getRates().get(Constant.CURRENCY_EUR);
					countryDto.setCurrencyValue(currencyValue);
				} else {
					throw new ExceptionHandlerIP(Constant.MESSAGE_ERROR_CURRENCY_RATES);
				}
			}
		} else {
			throw new ExceptionHandlerIP(Constant.MESSAGE_ERROR_CURRENCY_COUNTRY);
		}
	}

	private void setResponse(String status, String message, boolean error, Object object, Response response) {
		response.setStatus(status);
		response.setMessage(message);
		response.setError(error);
		response.setBody(object);
	}

	public boolean isBanned(String ip) {
		boolean isBanned = false;
		IpBan ipBan = ipBanDao.findByIp(ip);
		if (ipBan != null) {
			isBanned = true;
		}
		return isBanned;
	}

}
