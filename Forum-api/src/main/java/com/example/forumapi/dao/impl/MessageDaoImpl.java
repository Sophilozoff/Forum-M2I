package com.example.forumapi.dao.impl;

import com.example.forumapi.dao.MessageDao;
import com.example.forumapi.dto.MessageDto;
import com.example.forumapi.models.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class MessageDaoImpl extends GenericDaoImpl<Message, Long> implements MessageDao {

    private static final Logger logger = LoggerFactory.getLogger(MessageDaoImpl.class);

    @Override
    public void deleteById(Long id) {
        entityManager.createQuery("DELETE FROM Message WHERE id=:id")
                .setParameter("id", id).executeUpdate();
    }

    @Override
    public void deleteByDiscussionId(Long id) {
        entityManager.createQuery("DELETE FROM Message m WHERE m.discussion.id =:id")
                .setParameter("id", id).executeUpdate();
    }

    @Override
    public Optional<List<MessageDto>> findMessagesByDiscussionId(Long id) {
        Query query = entityManager.createQuery(
                "SELECT m FROM Message m WHERE m.discussion.id=:id");
        query.setParameter("id", id).getResultList();
        List<MessageDto> messages = null;
        try {
            messages = query.getResultList();
        } catch (Exception e) {
            logger.error("Error finding messages for discussion id : " + id);
        }
        return Optional.ofNullable(messages);
    }
}
