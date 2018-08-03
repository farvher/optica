package com.optica.controllers;

import javax.servlet.http.HttpServletRequest;

import com.optica.util.Encryptor;
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


    @GetMapping(MappingConstants.INDEX_PATH)
    public String index(HttpServletRequest request, Model model) {

        return "index";
    }

    @GetMapping(MappingConstants.ABOUT_PATH)
    public String about(Model model) {
        return "about";
    }

    @GetMapping(MappingConstants.CONTACT_PATH)
    public String contact() {
        return "contact";
    }

    @GetMapping(MappingConstants.TEAM_PATH)
    public String team() {
        return "team";
    }

    @PostMapping(MappingConstants.CONTACT_PATH)
    @ResponseBody
    public String contant(Model model) {

        return "success";
    }

}
