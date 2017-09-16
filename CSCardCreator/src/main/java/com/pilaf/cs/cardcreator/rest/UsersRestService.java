package com.pilaf.cs.cardcreator.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/cardcreator")
public class UsersRestService {

//	@Autowired
//	RestTemplate restTemplate;
	

	
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, name = "/create")
	public String getAllUsersFeign() {
		return "Created";
	}
	
	

}
