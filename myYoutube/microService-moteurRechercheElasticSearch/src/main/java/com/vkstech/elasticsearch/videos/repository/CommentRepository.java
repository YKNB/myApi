package com.vkstech.elasticsearch.videos.repository;

import com.vkstech.elasticsearch.videos.entities.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment,Long> {

    List<Comment> findAll();
}
