package com.example.forumapi.controllers;

import com.example.forumapi.dto.MessageDto;
import com.example.forumapi.mappers.MessageMapper;
import com.example.forumapi.models.Message;
import com.example.forumapi.services.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    MessageServiceImpl messageService;

    @Autowired
    MessageMapper messageMapper;

    @GetMapping("")
    public ResponseEntity<List<MessageDto>> findMessages() {
        try {
            List<MessageDto> messages = messageService.findAll().stream().map(message -> messageMapper.toDto(message)).collect(Collectors.toList());
            return ResponseEntity.ok(messages);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<MessageDto> findMessageById(@PathVariable Long id) {
        try {
            MessageDto message = messageMapper.toDto(messageService.findById(id));
            return ResponseEntity.ok(message);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("discussion-{id}")
    public ResponseEntity<Optional<List<MessageDto>>> findMessagesByDiscussionId(@PathVariable Long id) {
        try {
            Optional<List<MessageDto>> messages = messageService.findByDiscussionId(id);
            return ResponseEntity.ok(messages);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("")
    public ResponseEntity<MessageDto> create(@RequestBody MessageDto messageDto) {
        try {
            Message message = messageMapper.toEntity(messageDto);
            message.setCreatedAt();
            messageService.save(message);
            return ResponseEntity.ok(messageDto);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<MessageDto> update(@RequestBody MessageDto messageDto, @PathVariable Long id) {
        try {
            Message message = messageService.findById(id);
            message.setUpdatedAt();
            message.setContent(messageDto.getContent());
            messageService.update(message);
            return ResponseEntity.ok(messageDto);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<MessageDto> deleteById(@PathVariable Long id) {
        try {
            messageService.deleteById(id);
            return ResponseEntity.ok(null);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
