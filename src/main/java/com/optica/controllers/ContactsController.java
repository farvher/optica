package com.optica.controllers;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.optica.domain.Contacts;
import com.optica.entity.User;
import com.optica.services.ContactsService;
import com.optica.services.login.SecurityService;
import com.optica.util.ReadLoadContacts;

/**
 * Controlador para crud de  contactos de celular
 * 
 * @author fsanmiguel
 * */
@Controller
public class ContactsController {

	private final Logger logger = LoggerFactory.getLogger(ContactsController.class);

    private static final String CONTACTS = "people/contacts::contacts";

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
        model.addAttribute("elements", contacts.getTotalElements());
        model.addAttribute("pages", contacts.getTotalPages());
        model.addAttribute("startPage",0);
        int endPage = 7>= contacts.getTotalPages()?contacts.getTotalPages() : 7;
        model.addAttribute("endPage",endPage);
        model.addAttribute("page", 0);
        return CONTACTS;
    }

    @GetMapping("/app/people/contacts/{page}")
    public String getContacts(@PathVariable int page, Model model) {
        User user = securityService.getCurrentUser();
        Page<Contacts> contacts = contactsService.findAllContacts(PageRequest.of(page, SIZEPERPAGE), user.getId());
        model.addAttribute("contacts", contacts.getContent());
        model.addAttribute("elements", contacts.getTotalElements());
        model.addAttribute("pages", contacts.getTotalPages());
        int startPage = page>=7? page-6 : 0;
        int endPage = page+3>= contacts.getTotalPages()?contacts.getTotalPages() : page+3;
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("page", page);
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
