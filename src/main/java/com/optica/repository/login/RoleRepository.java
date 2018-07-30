package com.optica.repository.login;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.optica.entity.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	List<Role> findAll();

	List<Role> findByName(String name);


}
