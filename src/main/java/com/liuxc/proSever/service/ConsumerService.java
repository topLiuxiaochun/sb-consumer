package com.liuxc.proSever.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ConsumerService {

	private final String SERVICE_NAME = "compute-service";
	
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * 断路由设置，当远程方法异常时， 降级执行fallbackInfo方法
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "fallbackInfo")
	public String getInfo() {
		return restTemplate.getForObject("http://" + SERVICE_NAME + "/add?a=10&b=20", String.class);
	}
	
	public String fallbackInfo() {
		return "fallbackInfo";
	}
}
