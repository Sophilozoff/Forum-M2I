package com.example.forumapi.controllers;

import com.example.forumapi.dto.DiscussionDto;
import com.example.forumapi.mappers.DiscussionMapper;
import com.example.forumapi.models.Discussion;
import com.example.forumapi.services.impl.DiscussionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/discussions")
public class DiscussionController {

    @Autowired
    DiscussionServiceImpl discussionService;

    @Autowired
    DiscussionMapper discussionMapper;

    @GetMapping("")
    public ResponseEntity<List<DiscussionDto>> findDiscussions() {
        try {
            List<DiscussionDto> discussions = discussionService.findAll().stream().map(discussion -> discussionMapper.toDto(discussion)).collect(Collectors.toList());
            return ResponseEntity.ok(discussions);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<DiscussionDto> findDiscussion(@PathVariable Long id) {
        try {
            DiscussionDto discussion = discussionMapper.toDto(discussionService.findById(id));
            return ResponseEntity.ok(discussion);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("")
    public ResponseEntity<DiscussionDto> create(@RequestBody DiscussionDto discussionDto) {
        try {
            Discussion discussion = discussionMapper.toEntity(discussionDto);
            discussion.setCreatedAt();
            discussionService.save(discussion);
            return ResponseEntity.ok(discussionDto);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("like-{id}")
    public void incrementsLikes(@PathVariable Long id) {
        Discussion discussion = discussionService.findById(id);
        discussion.setLikes(discussion.getLikes() + 1);
        discussionService.update(discussion);
    }

    @PutMapping("dislike-{id}")
    public void decrementsLikes(@PathVariable Long id) {
        Discussion discussion = discussionService.findById(id);
        discussion.setLikes(discussion.getLikes() - 1);
        discussionService.update(discussion);
    }

    @PutMapping("{id}")
    public ResponseEntity<DiscussionDto> update(@RequestBody DiscussionDto discussionDto, @PathVariable Long id) {
        try {
            Discussion discussion = discussionService.findById(id);
            discussion.setUpdatedAt();
            discussion.setTitle(discussionDto.getTitle());
            discussion.setFirstMessage(discussionDto.getFirstMessage());
            discussionService.update(discussion);
            return ResponseEntity.ok(discussionDto);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<DiscussionDto> deleteById(@PathVariable Long id) {
        try {
            discussionService.deleteById(id);
            return ResponseEntity.ok(null);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
