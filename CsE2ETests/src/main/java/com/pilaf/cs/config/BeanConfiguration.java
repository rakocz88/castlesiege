package com.pilaf.cs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfiguration {
	
	private static final String APPLICATION_ID = "cs";
	private static final String APPLICATION_SECRET = "secret";
	
	@Bean
	public RestTemplate restTemplate(){
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(
				  new BasicAuthorizationInterceptor(APPLICATION_ID, APPLICATION_SECRET));
		return restTemplate;
	}

}
