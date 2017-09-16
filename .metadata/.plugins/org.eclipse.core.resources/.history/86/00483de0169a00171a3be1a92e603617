package com.pilaf.cs.users.repository;

import org.springframework.data.repository.CrudRepository;

import com.pilaf.cs.users.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findOneByUsername(String username);

}
