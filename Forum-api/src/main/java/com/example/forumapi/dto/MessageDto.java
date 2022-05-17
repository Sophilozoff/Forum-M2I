package com.example.forumapi.dto;

import com.example.forumapi.models.Discussion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {

    public Long id;
    public String content;
    public String author;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
    public Discussion discussion;

    public MessageDto(Long id, String content, String author, Discussion discussion, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.discussion = discussion;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
