package com.example.forumapi.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "discussions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discussion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 200)
    private String title;

    private String author;

    @JsonIgnore
    @OneToMany(mappedBy = "discussion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages = new ArrayList<>();

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String firstMessage;

    private int likes;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Discussion(String title, String author, String firstMessage) {
        this.title = title;
        this.author = author;
        this.firstMessage = firstMessage;
    }

    public void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }

    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }
}
