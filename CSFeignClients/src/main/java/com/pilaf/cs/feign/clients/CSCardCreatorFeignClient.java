package com.pilaf.cs.feign.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "http://cardcreator")
public interface CSCardCreatorFeignClient {

	@RequestMapping(method = RequestMethod.GET, value = "/create")
	String create();

}
