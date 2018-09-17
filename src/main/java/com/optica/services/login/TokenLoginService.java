package com.optica.services.login;

import com.optica.domain.app.TokenLogin;

/**
 * 
 * 
 * @author fsanmiguel
 */
public interface TokenLoginService {

	/**
	 * crea un token login para validar correo o recuperar contraseña
	 * */
	void createTokenLogin(String email);

	/**
	 * valida el token asociado al correo
	 */
	Boolean tokenValido(String email, String token);

	/**
	 * expira el token despues de no utilizarse en el tiempo estipulado
	 * USAR EN JOBS
	 * */
	void expireTokenLogin(String email);

}
