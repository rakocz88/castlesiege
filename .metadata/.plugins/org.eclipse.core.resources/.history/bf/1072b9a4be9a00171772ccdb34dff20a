package com.pilaf.cs.card.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "http://user-service")
public interface ExternalUserService {

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	String getAllUsers();

}
