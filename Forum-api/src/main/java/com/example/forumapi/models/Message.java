package com.example.forumapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String content;

    private String author;

    @ManyToOne
    @JoinColumn(name = "discussion_id")
    private Discussion discussion;

    private int likes;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Message(String author, String content, Discussion discussion) {
        this.author = author;
        this.content = content;
        this.discussion = discussion;
    }

    public void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }

    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }
}
