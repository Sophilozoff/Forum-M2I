package com.example.forumapi.dao;

import com.example.forumapi.dto.MessageDto;
import com.example.forumapi.models.Message;

import java.util.List;
import java.util.Optional;

public interface MessageDao extends GenericDao<Message, Long> {

    public void deleteById(Long id);

    public void deleteByDiscussionId(Long id);

    public Optional<List<MessageDto>> findMessagesByDiscussionId(Long id);
}
