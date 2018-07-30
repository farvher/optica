package com.optica.services.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.userdetails.UserDetails;

import com.optica.entity.User;

public interface SecurityService {

	String findLoggedInUsername();

	void autologin(String username, String password, HttpServletRequest request);

	User getCurrentUser();

}
