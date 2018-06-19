package com.optica.repository.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.optica.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findFirstByUsername(String username);

}
