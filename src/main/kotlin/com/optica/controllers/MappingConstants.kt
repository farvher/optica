package com.optica.controllers

interface MappingConstants {
    companion object {

        const val INDEX_PATH = "/"

        const val LOGIN_PATH = "/login"

        const val REGISTRATION_PATH = "/registration"

        const val ABOUT_PATH = "/about"

        const val CONTACT_PATH = "/contact"

        const val TEAM_PATH = "/team"

        const val BLOG_PATH = "/blog"

        const val PEOPLE_PATH = "/people"

        const val JOB_SEARCH_PATH = "/search/{keyword:.*}/{city:.*}"

        const val JOB_DETAIL_PATH = "/detail/{title:.*}/{id:.*}"

        const val JOB_OFFER_NEW = "/job-offer/"
    }

}
