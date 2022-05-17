package com.example.forumapi.dao;

import com.example.forumapi.models.Discussion;

import java.util.Optional;

public interface DiscussionDao extends GenericDao<Discussion, Long> {

    public Optional<Discussion> findByTitle(String title);

    public void deleteById(Long id);
}
