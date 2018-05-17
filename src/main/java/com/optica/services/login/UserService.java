package com.optica.services.login;

import java.util.List;

import com.optica.entity.User;

public interface UserService {
	
	void save(User user);
	
	User findByUsername(String username);
	
	List<User> findAll();
}
