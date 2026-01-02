package com.springboot.Api.repository;

import com.springboot.Api.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PostRepository extends JpaRepository<Post, Long> {

    Optional<Post> findByTitle(String title);

}
