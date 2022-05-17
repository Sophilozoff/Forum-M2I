package com.example.forumapi.mappers;

import com.example.forumapi.dto.MessageDto;
import com.example.forumapi.models.Discussion;
import com.example.forumapi.models.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

public class MessageMapperTest {

    @InjectMocks
    private MessageMapper messageMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("should convert a Message to MessageDto")
    void convertToMessageDto() {
        Discussion discussion = new Discussion();
        Message message = new Message("content", "author", discussion);
        message.setId(1L);
        message.setCreatedAt(LocalDateTime.now());
        message.setUpdatedAt(LocalDateTime.now());
        MessageDto messageDto = messageMapper.toDto(message);

        Assertions.assertEquals(message.getId(), messageDto.getId());
        Assertions.assertEquals(message.getAuthor(), messageDto.getAuthor());
        Assertions.assertEquals(message.getContent(), messageDto.getContent());
        Assertions.assertEquals(message.getDiscussion(), messageDto.getDiscussion());
        Assertions.assertEquals(message.getCreatedAt(), messageDto.getCreatedAt());
        Assertions.assertEquals(message.getUpdatedAt(), messageDto.getUpdatedAt());
    }

    @Test
    @DisplayName("should convert a MessageDto to Message")
    void convertToMessage() {
        Discussion discussion = new Discussion();
        MessageDto messageDto = new MessageDto(1L, "content", "author", LocalDateTime.now(), LocalDateTime.now(), discussion);
        Message message = messageMapper.toEntity(messageDto);

        Assertions.assertEquals(messageDto.getAuthor(), message.getAuthor());
        Assertions.assertEquals(messageDto.getContent(), message.getContent());
        Assertions.assertEquals(messageDto.getDiscussion(), message.getDiscussion());
    }
}
