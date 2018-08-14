package com.optica.controllers;


import com.optica.domain.Contacts;
import com.optica.entity.User;
import com.optica.services.ContactsService;
import com.optica.services.login.SecurityService;
import com.optica.util.ReadLoadContacts;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class ContactsController {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(ContactsController.class);

    private static final String CONTACTS = "contacts::contacts";

    private static final String CONTACTS_CREATE = "contacts::create";

    private static final int SIZEPERPAGE = 5;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private ContactsService contactsService;

    @GetMapping("/app/people/contacts")
    public String getContacts(Model model) {
        User user = securityService.getCurrentUser();
        Page<Contacts> contacts = contactsService.findAllContacts(PageRequest.of(0, SIZEPERPAGE), user.getId());
        contacts.getTotalElements();
        model.addAttribute("contacts", contacts.getContent());
        model.addAttribute("pages", contacts.getTotalElements());
        model.addAttribute("total", contacts.getTotalPages());
        return CONTACTS;
    }

    @GetMapping("/app/people/contacts/{page}")
    public String getContacts(@PathVariable int page, Model model) {
        User user = securityService.getCurrentUser();
        Page<Contacts> contacts = contactsService.findAllContacts(PageRequest.of(page, SIZEPERPAGE), user.getId());
        model.addAttribute("contacts", contacts.getContent());
        model.addAttribute("pages", contacts.getTotalElements());
        model.addAttribute("total", contacts.getTotalPages());
        return CONTACTS;
    }

    @PostMapping("/app/people/contacts/create")
    public String createContact(String contactName, String phoneNumber, Model model) {
        Contacts contact = new Contacts();
        User user = securityService.getCurrentUser();
        contact.setUserId(user.getId());
        contact.setName(contactName);
        contact.setPhone(phoneNumber);
        contactsService.createContact(contact);

        return "redirect:/people";
    }

    @PostMapping("/app/people/contacts/loadvcf")
    public String loadContactVCard(Model model, @RequestParam("file") MultipartFile multipartFile) {
        User user = securityService.getCurrentUser();
        List<Contacts> contacts = null;
        try {
            contacts = ReadLoadContacts.readContactsFromVCard(multipartFile.getInputStream(), user.getId());
            if(contacts!=null){
                contactsService.importContacts(contacts,user.getId());
            }
        } catch (Exception ex) {
            logger.error("Error importando contactos",ex);
        }

        return "redirect:/people";
    }


}
