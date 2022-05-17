package com.example.forumapi.services.impl;

import com.example.forumapi.dao.DiscussionDao;
import com.example.forumapi.dao.GenericDao;
import com.example.forumapi.dao.MessageDao;
import com.example.forumapi.models.Discussion;
import com.example.forumapi.services.DiscussionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiscussionServiceImpl extends GenericServiceImpl<Discussion, Long> implements DiscussionService {

    private DiscussionDao discussionDao;
    private MessageDao messageDao;

    @Autowired
    public DiscussionServiceImpl(@Qualifier("discussionDaoImpl") GenericDao<Discussion, Long> genericDao, DiscussionDao discussionDao, MessageDao messageDao) {
        super(genericDao);
        this.discussionDao = discussionDao;
        this.messageDao = messageDao;
    }

    @Override
    public Optional<Discussion> findByTitle(String title) {
        return discussionDao.findByTitle(title);
    }

    @Override
    public void deleteById(Long id) {
        messageDao.deleteByDiscussionId(id);
        discussionDao.deleteById(id);
    }
}
