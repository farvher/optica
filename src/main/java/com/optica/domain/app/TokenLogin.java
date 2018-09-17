package com.optica.domain.app;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class TokenLogin {

	@Id
	@GeneratedValue
	Long id;

	String token;

	String email;

	LocalDate expirationDate;

	LocalDate creationDate;

	Boolean enabled;

	@Transient
	Boolean validToken;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setValidToken(Boolean validToken) {
		this.validToken = validToken;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public Boolean getValidToken() {
		return expirationDate == null ? false : enabled && expirationDate.isBefore(LocalDate.now());
	}

}
