package com.optica.repository.login;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.optica.entity.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findFirstByUserName(String userName);

}
