package com.myYoutube.scopes.videos.repository;

import com.myYoutube.scopes.videos.entities.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment,Long> {

    List<Comment> findAll();
}
