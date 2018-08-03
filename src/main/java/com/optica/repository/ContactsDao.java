package com.optica.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.optica.domain.Contacts;

import java.util.List;

@Repository
public interface ContactsDao extends JpaRepository<Contacts, Long>{

     void deleteByIdAndUserId(Long id, Long userId);

     Page<Contacts> findAllByUserId(Pageable pageable, Long userId);

}
