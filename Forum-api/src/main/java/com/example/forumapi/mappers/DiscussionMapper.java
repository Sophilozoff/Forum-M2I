package com.example.forumapi.mappers;

import com.example.forumapi.dto.DiscussionDto;
import com.example.forumapi.models.Discussion;
import com.example.forumapi.models.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DiscussionMapper {

    public DiscussionDto toDto(Discussion discussion) {
        Long id = discussion.getId();
        String title = discussion.getTitle();
        String author = discussion.getAuthor();
        List<Message> messages = discussion.getMessages();
        String firstMessage = discussion.getFirstMessage();
        LocalDateTime createdAt = discussion.getCreatedAt();
        LocalDateTime updatedAt = discussion.getUpdatedAt();
        int likes = discussion.getLikes();

        return new DiscussionDto(id, title, author, messages, firstMessage, createdAt, updatedAt, likes);
    }

    public Discussion toEntity(DiscussionDto discussionDto) {
        return new Discussion(discussionDto.getTitle(), discussionDto.getAuthor(), discussionDto.getFirstMessage());
    }
}
