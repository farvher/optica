package com.optica.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.optica.services.search.SearchService;

/**
 * @author farsan
 */
@Controller
public class HomeController {

	@Autowired
	private SearchService searchService;

    @GetMapping(Routes.INDEX_PATH)
    public String index(HttpServletRequest request, Model model) {
   

        return "index";
    }

    @GetMapping(Routes.ABOUT_PATH)
    public String about(Model model) {
    	searchService.indexSampleArticles();
        return "about";
    }

    @GetMapping(Routes.CONTACT_PATH)
    public String contact() {
        return "contact";
    }

    @GetMapping(Routes.TEAM_PATH)
    public String team() {
        return "team";
    }

    @PostMapping(Routes.CONTACT_PATH)
    @ResponseBody
    public String contant(Model model) {

        return "success";
    }

}
