package com.liuxc.proSever;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient		// 注册服务到注册中心
@SpringBootApplication
@EnableCircuitBreaker		// 开启断路由
public class ConsumerServiceApplication {

	/**
	 * RestTemplate 为远程调用模板工具类，方便使用注册中心的服务
	 * @return
	 */
	@Bean
	@LoadBalanced // 当注册中心同一个服务有多个实例时，可以负载均衡，由ribbon带来该给功能
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerServiceApplication.class, args);

	}

}
