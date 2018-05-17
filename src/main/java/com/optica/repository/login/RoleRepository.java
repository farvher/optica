package com.optica.repository.login;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.optica.entity.Role;


@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

	List<Role> findAll();
	
	
}
