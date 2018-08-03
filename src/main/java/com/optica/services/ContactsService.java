package com.optica.services;

import com.optica.domain.Contacts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContactsService {

    Page<Contacts> findAllContacts(Pageable pageable,Long userId);

    void deleteContact(Long id, Long userId);

    void importContacts(List<Contacts> contacts, Long userId);

    List<Contacts> exportContact (Long userId);

    void createContact(Contacts contacts);

}
