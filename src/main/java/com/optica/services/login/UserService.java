package com.optica.services.login;

import com.optica.entity.User;

public interface UserService {
	
	void save(User user);
	
	User findByUsername(String username);
}
