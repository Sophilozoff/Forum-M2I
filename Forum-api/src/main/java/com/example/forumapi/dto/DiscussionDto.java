package com.example.forumapi.dto;

import com.example.forumapi.models.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscussionDto {

    public Long id;
    public String title;
    public String author;
    public List<Message> messages;
    public String firstMessage;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
    public int likes;

}
