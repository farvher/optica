package com.optica.services.login;

import java.util.List;

import com.optica.entity.Role;

public interface RoleService {

	void save(Role role);

	List<Role> findRoleByName(String role);

	List<Role> findAll();

}
