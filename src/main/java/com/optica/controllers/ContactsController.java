package com.optica.controllers;


import com.optica.domain.Contacts;
import com.optica.entity.User;
import com.optica.services.ContactsService;
import com.optica.services.login.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ContactsController {

    private static final String CONTACTS = "contacts::contacts";

    private static final int SIZEPERPAGE = 10;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private ContactsService contactsService;

    @GetMapping("/app/people/contacts")
    public String getContacts(Model model) {
        User user = securityService.getCurrentUser();
        Page<Contacts> contacts = contactsService.findAllContacts(PageRequest.of(1,SIZEPERPAGE),user.getId());
        model.addAttribute("contacts",contacts.getContent());
        return CONTACTS;
    }
    @GetMapping("/app/people/contacts/{page}")
    public String getContacts(@PathVariable int page,Model model) {
        User user = securityService.getCurrentUser();
        Page<Contacts> contacts = contactsService.findAllContacts(PageRequest.of(page,SIZEPERPAGE),user.getId());
        model.addAttribute("contacts",((Page) contacts).getContent());
        return CONTACTS;
    }


}