package com.myYoutube.scopes.videos.repository;

import com.myYoutube.scopes.videos.entities.Video;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VideoRepository extends CrudRepository<Video, Long> {
    @Override
    List<Video> findAll();
}
