package com.pilaf.cs.cardcreator.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pilaf.cs.cardcreator.service.ExternalUserService;

@RestController()
public class UsersRestService {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private ExternalUserService externalUserService;

	
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, name = "/usersf")
	public String getAllUsersFeign() {
		return externalUserService.getAllUsers();
	}
	
	

}
