package com.optica.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author farsan
 */
@Controller
public class HomeController {


    @GetMapping(Routes.INDEX_PATH)
    public String index(HttpServletRequest request, Model model) {

        return "index";
    }

    @GetMapping(Routes.ABOUT_PATH)
    public String about(Model model) {
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
