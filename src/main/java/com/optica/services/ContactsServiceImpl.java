package com.optica.services;


import com.optica.domain.Contacts;
import com.optica.repository.ContactsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsServiceImpl implements ContactsService{

    @Autowired
    private ContactsDao contactsDao;

    @Override
    public Page<Contacts> findAllContacts(Pageable pageable,Long userId) {
        return contactsDao.findAllByUserId(pageable,userId);
    }

    @Override
    public void deleteContact(Long id, Long userId) {
        contactsDao.deleteByIdAndUserId(id, userId);
    }

    @Override
    public void importContacts(List<Contacts> contacts, Long userId) {
        for (Contacts c : contacts){
            if (c.getUserId()!= userId){
                throw new IllegalStateException("Uno de los contactos no pertenece al usuario");
            }
        }
        contactsDao.saveAll(contacts);
    }

    @Override
    public List<Contacts> exportContact(Long userId) {
        return contactsDao.findAll();
    }

    @Override
    public void createContact(Contacts contacts) {
        contactsDao.save(contacts);

    }
}
