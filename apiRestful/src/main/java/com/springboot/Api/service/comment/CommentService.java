package com.springboot.Api.service.comment;

import com.springboot.Api.dto.comment.CommentDto;
import com.springboot.Api.dto.comment.UpdateCommentDto;

import java.util.List;

public interface CommentService {

    CommentDto create(Long postId, CommentDto dto);
    List<CommentDto> getAllByPost(Long postId);
    CommentDto getCommentById(Long postId, Long commentId);
    CommentDto update(Long postId, Long commentId, UpdateCommentDto dto);
    void delete(Long postId, Long commentId);

}
