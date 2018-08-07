package com.optica.repository;


import com.optica.domain.ShortMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ShortMessageDao extends JpaRepository<ShortMessage,Long> {

    Page<ShortMessage> findByUserId(Pageable pageble, Long userId);

    Page<ShortMessage> findByUserIdAndMessageContains(Pageable pageable, Long userId, String message);

    Page<ShortMessage> findByUserIdAndCreationBetweenAnd(Pageable pageable, Long userId, LocalDate start,LocalDate end);

    ShortMessage findFirstByUserIdAndId(Long userId , Long id);
}
