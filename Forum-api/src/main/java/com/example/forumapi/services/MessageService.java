package com.example.forumapi.services;

import com.example.forumapi.models.Message;

public interface MessageService extends GenericService <Message, Long>{

    public void deleteById(Long id);
}
