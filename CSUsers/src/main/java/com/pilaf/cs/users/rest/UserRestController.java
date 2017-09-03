package com.pilaf.cs.users.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.pilaf.cs.users.model.User;
import com.pilaf.cs.users.repository.UserRepository;

@RestController("/users")
public class UserRestController {

	private UserRepository userRepository;

	@Autowired
	public UserRestController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@RequestMapping("/all")
	private List<User> getAllUsers() {
		return Lists.newArrayList(userRepository.findAll());
	}

}
