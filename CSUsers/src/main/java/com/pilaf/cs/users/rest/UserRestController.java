package com.pilaf.cs.users.rest;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pilaf.cs.users.model.User;
import com.pilaf.cs.users.service.UserService;

@RestController("/users")
public class UserRestController {

	private UserService userService;

	@Autowired
	public UserRestController(UserService userService) {
		super();
		this.userService = userService;
	}

	@RequestMapping("/all")
	public List<User> getAllUsers(Principal principal) {
		return userService.getAllUsers();
	}
	
	@RequestMapping("/{name}")
	public User getUserByUserName(@PathVariable("name") String name){
		return (User) userService.loadUserByUsername(name);
	}

}
