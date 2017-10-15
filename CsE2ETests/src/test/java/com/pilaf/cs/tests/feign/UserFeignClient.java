package com.pilaf.cs.tests.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pilaf.cs.tests.FeignLogConfiguratinon;

import feign.HeaderMap;

@Component
@FeignClient(value = "http://users", configuration = FeignLogConfiguratinon.class)
public interface UserFeignClient {

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	String getAllUsers(@HeaderMap MultiValueMap<String, String> headers);
	
	@RequestMapping(method = RequestMethod.GET, value = "/{name}")
	String getUserByName(@HeaderMap MultiValueMap<String, String> headers, @PathVariable("name") String name);
	
}
