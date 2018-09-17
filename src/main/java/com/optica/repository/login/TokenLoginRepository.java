package com.optica.repository.login;

import org.springframework.data.repository.CrudRepository;

import com.optica.domain.app.TokenLogin;

public interface TokenLoginRepository extends CrudRepository<TokenLogin, Long> {
	
	

}
