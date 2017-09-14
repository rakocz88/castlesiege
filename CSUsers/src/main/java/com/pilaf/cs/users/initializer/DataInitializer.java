package com.pilaf.cs.users.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.pilaf.cs.users.model.User;
import com.pilaf.cs.users.repository.UserRepository;

@Component
public class DataInitializer implements ApplicationRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		userRepository.save(new User("filip", passwordEncoder.encode("filip"), true));
	}

}
