package com.optica.services.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.optica.entity.User;
import com.optica.repository.login.RoleRepository;
import com.optica.repository.login.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User user) {
		user.setPass(bCryptPasswordEncoder.encode(user.getPass()));
		user.setRoles(roleRepository.findAll());
		userRepository.save(user);

	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findFirstByUserName(username);
	}

}
