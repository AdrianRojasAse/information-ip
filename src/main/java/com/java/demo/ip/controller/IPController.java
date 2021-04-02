package com.java.demo.ip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.demo.ip.dto.Response;
import com.java.demo.ip.service.IPService;

@RestController
@RequestMapping("/api/ip")
public class IPController {
	
	@Autowired
	private IPService ipService;

	@GetMapping(value = "/country/{ip}")
	public Response getCountryInfo(@PathVariable String ip)  {
		return null;
	}
}
