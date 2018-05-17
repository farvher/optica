package com.optica.services.login;

public interface SecurityService {

	String findLoggedInUsername();

	void autologin(String username, String password);

}
