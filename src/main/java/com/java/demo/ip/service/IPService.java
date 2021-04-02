package com.java.demo.ip.service;

import com.java.demo.ip.dto.Response;


public interface IPService {

	public Response getCountryInfo(String ip);
	
	public boolean isBanned(String ip);
	

}
