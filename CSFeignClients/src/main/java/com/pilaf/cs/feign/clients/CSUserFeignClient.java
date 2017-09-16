package com.pilaf.cs.feign.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "http://users")
public interface CSUserFeignClient {

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	String getAllUsers();
	
	@RequestMapping(method = RequestMethod.GET, value = "/{name}")
	String getByName(@PathVariable("name") String name);

}