package com.example.forumapi.services.impl;

import com.example.forumapi.dao.GenericDao;
import com.example.forumapi.dao.MessageDao;
import com.example.forumapi.dto.MessageDto;
import com.example.forumapi.models.Message;
import com.example.forumapi.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl extends GenericServiceImpl<Message, Long> implements MessageService {

    private MessageDao messageDao;

    @Autowired
    public MessageServiceImpl(@Qualifier("messageDaoImpl") GenericDao<Message, Long> genericDao, MessageDao messageDao) {
        super(genericDao);
        this.messageDao = messageDao;
    }

    public Optional<List<MessageDto>> findByDiscussionId(Long id) {
        return messageDao.findMessagesByDiscussionId(id);
    }

    @Override
    public void deleteById(Long id) {
        messageDao.deleteById(id);
    }
}
