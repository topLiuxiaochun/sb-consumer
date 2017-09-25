package com.liuxc.proSever.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerService {

	private final String SERVICE_NAME = "compute-service";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String getInfo() {
		return restTemplate.getForObject("http://" + SERVICE_NAME + "/add?a=10&b=20", String.class);
	}
}
