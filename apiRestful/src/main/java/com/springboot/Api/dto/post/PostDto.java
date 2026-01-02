package com.springboot.Api.dto.post;

import com.springboot.Api.dto.comment.CommentDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class PostDto extends CreatePostDto {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Set<CommentDto> comments;
}
