package com.pilaf.cs.rest;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController("test/users")
public class UserTestRest {

	@Autowired
	private RestTemplate restTemplate;
//
	@RequestMapping("getUser/{name}/{token}")
	public String getUserByName(@PathVariable("token")String token,@PathVariable("name")String userName){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization","Bearer " + token);
		HttpEntity entity = new HttpEntity(headers);
		 ResponseEntity<String> response = restTemplate.exchange(
				"http://users/"+userName, HttpMethod.GET, entity, String.class, new HashedMap());
		 return response.getBody();
	}

}
