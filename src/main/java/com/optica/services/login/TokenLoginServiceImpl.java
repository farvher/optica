package com.optica.services.login;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.optica.domain.app.TokenLogin;
import com.optica.repository.login.TokenLoginRepository;

@Component
public class TokenLoginServiceImpl implements TokenLoginService {

	  private static final Logger logger = LoggerFactory.getLogger(TokenLoginServiceImpl.class);
	
	@Autowired
	private TokenLoginRepository tokenLoginRepository;

	@Override
	public void createTokenLogin(String email) {

		TokenLogin token = new TokenLogin();
		token.setEmail(email.toLowerCase());
		token.setToken(generateToken());
		token.setExpirationDate(LocalDate.now().plusDays(1));
		token.setCreationDate(LocalDate.now());
		tokenLoginRepository.save(token);

	}

	@Override
	public Boolean tokenValido(String email, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void expireTokenLogin(String email) {
		// TODO Auto-generated method stub

	}

	/**
	 * Genera token al random
	 */
	private static String generateToken() {
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[20];
		random.nextBytes(bytes);
		String token = Arrays.toString(bytes);
		return token;

	}

}
