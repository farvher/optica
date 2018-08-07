package com.optica.services;

import com.optica.domain.ShortMessage;
import com.optica.repository.ShortMessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ShortMessageServiceImpl implements ShortMessageService {

    @Autowired
    private ShortMessageDao shortMessageDao;

    @Override
    public Page<ShortMessage> getMessages(Pageable pageable, Long userId) {
        return shortMessageDao.findByUserId(pageable, userId);
    }

    @Override
    public Page<ShortMessage> getMessages(Pageable pageable, Long userId, String contains) {
        return shortMessageDao.findByUserIdAndMessageContains(pageable, userId, contains);
    }

    @Override
    public Page<ShortMessage> getMessages(Pageable pageable, Long userId, LocalDate start, LocalDate end) {
        return shortMessageDao.findByUserIdAndCreationBetweenAnd(pageable, userId, start, end);
    }

    @Override
    public void deleteMessage(Long userId, Long messageId) {
        shortMessageDao.deleteById(userId);

    }

    @Override
    public ShortMessage findMessage(Long userId, Long id) {
        return shortMessageDao.findById(id).orElse(new ShortMessage());
    }

    @Override
    public void createMessage(ShortMessage shortMessage) {
        shortMessageDao.save(shortMessage);

    }
}
