package com.optica.controllers;

public interface Routes {


    /**
     * APP ROUTES
     */
    String APP_PATH = "/app";

    String COMPANY_HOME = APP_PATH + "/company";

    String PEOPLE_HOME = APP_PATH + "/people";


    /**
     * Commons actions
     */
    String EDIT = "/edit";

    String NEW = "/new";

    String DELETE = "/delete";

    String SEARCH = "/search";


    /**
     * Public routes
     */
    String INDEX_PATH = "/";

    String LOGIN_PATH = "/login";

    String REGISTRATION_PATH = "/registration";

    String ABOUT_PATH = "/about";

    String CONTACT_PATH = "/contact";

    String TEAM_PATH = "/team";

    String BLOG_PATH = "/blog";


    String JOB_SEARCH_PATH = "/search/{keyword:.*}/{city:.*}";

    String JOB_DETAIL_PATH = "/detail/{title:.*}/{id:.*}";

    String JOB_OFFER_NEW = "/job-offer/";

}
