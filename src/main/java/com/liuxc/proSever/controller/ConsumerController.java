package com.liuxc.proSever.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liuxc.proSever.service.ConsumerService;

@RestController
public class ConsumerController {

	@Autowired
	private ConsumerService consumerService;
	
	@RequestMapping("/go")
	public String go(){
		return consumerService.getInfo();
	}
}
