package com.example.forumapi.dao.impl;

import com.example.forumapi.dao.DiscussionDao;
import com.example.forumapi.models.Discussion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.Optional;

@Repository
public class DiscussionDaoImpl extends GenericDaoImpl<Discussion, Long> implements DiscussionDao {

    private static final Logger logger = LoggerFactory.getLogger(DiscussionDaoImpl.class);

    @Override
    public Optional<Discussion> findByTitle(String title) {
        Query query = entityManager.createQuery("from Discussion WHERE title=:title");
        query.setParameter("title", title);
        Discussion discussion = null;
        try {
            discussion = (Discussion) query.getSingleResult();
        } catch (Exception e) {
            logger.error("Error finding discussion with title: " + title);
        }
        return Optional.ofNullable(discussion);
    }

    @Override
    public void deleteById(Long id) {
        entityManager.createQuery("DELETE FROM Discussion WHERE id=:id")
                .setParameter("id", id).executeUpdate();
    }
}
