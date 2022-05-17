package com.example.forumapi.services;

import com.example.forumapi.models.Discussion;

import java.util.Optional;

public interface DiscussionService extends GenericService <Discussion, Long>{
    public Optional<Discussion> findByTitle(String title);

    public void deleteById(Long id);

}
