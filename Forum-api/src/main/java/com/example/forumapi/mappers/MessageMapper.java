package com.example.forumapi.mappers;

import com.example.forumapi.dto.MessageDto;
import com.example.forumapi.models.Discussion;
import com.example.forumapi.models.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class MessageMapper {


    public MessageDto toDto(Message message) {
        Long id = message.getId();
        String content = message.getContent();
        String author = message.getAuthor();
        Discussion discussion = message.getDiscussion();
        LocalDateTime createdAt = message.getCreatedAt();
        LocalDateTime updatedAt = message.getUpdatedAt();

        return new MessageDto(id, content, author, discussion, createdAt, updatedAt);
    }

    public Message toEntity(MessageDto messageDto) {
        return new Message(messageDto.getAuthor(), messageDto.getContent(), messageDto.getDiscussion());
    }
}
