package com.example.forumapi.mappers;

import com.example.forumapi.dto.DiscussionDto;
import com.example.forumapi.models.Discussion;
import com.example.forumapi.models.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class DiscussionMapperTest {

    @InjectMocks
    private DiscussionMapper discussionMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("should convert a Discussion into DiscussionDto")
    void convertToDiscussionDto() {
        Discussion discussion = new Discussion("titre", "auteur", "firstMessage");
        DiscussionDto discussionDto = discussionMapper.toDto(discussion);

        Assertions.assertEquals(discussion.getTitle(), discussionDto.getTitle());
        Assertions.assertEquals(discussion.getAuthor(), discussionDto.getAuthor());
        Assertions.assertEquals(discussion.getFirstMessage(), discussionDto.getFirstMessage());
    }

    @Test
    @DisplayName("should convert a DiscussionDto to Discussion")
    void convertToDiscussion() {
        List<Message> messages = new ArrayList<>();
        DiscussionDto discussionDto = new DiscussionDto(1L, "title", "author", messages, "firstMessage", LocalDateTime.now(), LocalDateTime.now(), 5);
        Discussion discussion = discussionMapper.toEntity(discussionDto);

        Assertions.assertEquals(discussionDto.getTitle(), discussion.getTitle());
        Assertions.assertEquals(discussionDto.getAuthor(), discussion.getAuthor());
        Assertions.assertEquals(discussionDto.getFirstMessage(), discussion.getFirstMessage());
    }
}
