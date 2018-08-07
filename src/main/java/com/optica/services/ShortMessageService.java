package com.optica.services;

import com.optica.domain.ShortMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface ShortMessageService {

    Page<ShortMessage> getMessages(Pageable pageable,Long userId);

    Page<ShortMessage> getMessages(Pageable pageable,Long userId, String contains);

    Page<ShortMessage> getMessages(Pageable pageable,Long userId, LocalDate start,LocalDate end);

    void deleteMessage(Long userId, Long messageId);

    ShortMessage findMessage(Long userId, Long id);

    void createMessage(ShortMessage shortMessage);


}
