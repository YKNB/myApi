package com.springboot.Api.service.post;


import com.springboot.Api.dto.post.PostDto;
import com.springboot.Api.dto.post.PostResponseDto;
import com.springboot.Api.dto.post.CreatePostDto;
import com.springboot.Api.dto.post.UpdatePostDto;
import org.springframework.http.ResponseEntity;

public interface PostService {

    ResponseEntity<PostDto> create(CreatePostDto dto);
    PostResponseDto getAll(int page, int size, String sort, String sortBy);
    PostDto getById(Long id);
    PostDto update(Long id, UpdatePostDto dto);
    void delete(Long id);
}
