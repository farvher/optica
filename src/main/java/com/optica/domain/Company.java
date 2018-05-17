package com.optica.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Company {

	@Id
	@GeneratedValue
	private Long id;

	private String companyName;
	
	private String nit;
	
	private String country;
	
	private Long businessSectorId;
	
	private Long workersNumber;
	
	private String URLImage;
	
	private String description;

	private String address;
	
	private String phone;
	
	private String phone2;
	
	private String webSite;
	
	private Long userIdAdmin;
	
	private Long cityId;
	
	private String neighborhood;
	
	private Long Latitude;
	
	private Long length;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getBusinessSectorId() {
		return businessSectorId;
	}

	public void setBusinessSectorId(Long businessSectorId) {
		this.businessSectorId = businessSectorId;
	}

	public Long getWorkersNumber() {
		return workersNumber;
	}

	public void setWorkersNumber(Long workersNumber) {
		this.workersNumber = workersNumber;
	}

	public String getURLImage() {
		return URLImage;
	}

	public void setURLImage(String uRLImage) {
		URLImage = uRLImage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public Long getUserIdAdmin() {
		return userIdAdmin;
	}

	public void setUserIdAdmin(Long userIdAdmin) {
		this.userIdAdmin = userIdAdmin;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public Long getLatitude() {
		return Latitude;
	}

	public void setLatitude(Long latitude) {
		Latitude = latitude;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}
	
	
	
	

}
