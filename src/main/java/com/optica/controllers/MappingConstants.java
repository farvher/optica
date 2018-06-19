package com.optica.controllers;

public interface MappingConstants {

	String INDEX_PATH = "/";
	
	String LOGIN_PATH = "/login";
	
	String REGISTRATION_PATH = "/registration";

	String ABOUT_PATH = "/about";

	String CONTACT_PATH = "/contact";

	String TEAM_PATH = "/team";

	String BLOG_PATH = "/blog";

	String PEOPLE_PATH = "/people";

	String JOB_SEARCH_PATH = "/search/{keyword:.*}/{city:.*}";

	String JOB_DETAIL_PATH = "/detail/{title:.*}/{id:.*}";

	String JOB_OFFER_NEW = "/job-offer/";

}
