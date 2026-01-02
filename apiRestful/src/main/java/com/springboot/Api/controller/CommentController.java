package com.springboot.Api.controller;


import com.springboot.Api.dto.comment.CommentDto;
import com.springboot.Api.dto.comment.UpdateCommentDto;
import com.springboot.Api.service.comment.CommentService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @PostMapping("/video/{id}/comment/comments")
    @SecurityRequirement(name = "Authorization")
    public ResponseEntity<CommentDto> create(@PathVariable(value = "postId") Long postId, @Valid @RequestBody CommentDto dto) {
        CommentDto comment = commentService.create(postId, dto);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }


    @GetMapping("/video/{id}/comments")
    public ResponseEntity<CommentDto> getCommentById(
            @PathVariable(value = "postId") Long postId,
            @PathVariable(value = "commentId") Long commentId) {
        return new ResponseEntity<>(commentService.getCommentById(postId, commentId), HttpStatus.OK);
    }
}
