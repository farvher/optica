package com.optica.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.optica.dto.CurriculumDto;
import com.optica.entity.User;
import com.optica.services.CurriculumService;
import com.optica.services.login.SecurityService;

@Controller
public class PeopleController {

    @Autowired
    private CurriculumService curriculumService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private ContactsController contactsController;

    @Autowired
    private SmsController smsController;

    @GetMapping(Routes.PEOPLE_HOME)
    public String index(Model model) {
        User user = securityService.getCurrentUser();
        contactsController.getContacts(model);
        smsController.getSmsList(model);
        loadModel(model, user);
        return "people";
    }

    @GetMapping("/app/people/curriculum/edit")
    public String edit(Model model, @Valid CurriculumDto curriculumDto, BindingResult errors) {
        User user = securityService.getCurrentUser();
        loadModel(model, user);
        return "people/edit";
    }

    @PostMapping("/app/people/curriculum/edit")
    public static String edit(Model model, @Valid CurriculumDto curriculumDto) {
        return "people/edit";
    }

    private void loadModel(Model model, User user) {
        model.addAttribute("user", user);


    }

}
