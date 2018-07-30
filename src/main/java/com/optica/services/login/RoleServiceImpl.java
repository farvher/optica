package com.optica.services.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optica.entity.Role;
import com.optica.repository.login.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void save(Role role) {
		roleRepository.save(role);

	}

	@Override
	public List<Role> findRoleByName(String role) {
		return roleRepository.findByName(role);
	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

}
