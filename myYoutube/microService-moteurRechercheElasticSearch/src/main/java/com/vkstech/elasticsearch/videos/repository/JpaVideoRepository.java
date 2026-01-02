package com.vkstech.elasticsearch.videos.repository;

import com.vkstech.elasticsearch.videos.entities.Video;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JpaVideoRepository extends ElasticsearchRepository<Video, Long> {
    @Override
    List<Video> findAll();
}
