package com.springboot.Api.repository;

import com.springboot.Api.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {

    Video findById(String id);

    @Query("SELECT v.id as id,  v.createdDate as createdDate, v.title as title, v.views as views FROM Video as v JOIN User as u on u.id = v.id WHERE v = :id")
    VideoResponse findVideoInfo(@Param("id") Long id);

    Video save(Video video);
}
