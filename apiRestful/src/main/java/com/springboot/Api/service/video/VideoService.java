package com.springboot.Api.service.video;

import com.springboot.Api.entity.User;
import com.springboot.Api.entity.Video;
import com.springboot.Api.repository.VideoListResponse;
import com.springboot.Api.repository.VideoRepository;
import com.springboot.Api.repository.VideoResponse;
import com.springboot.Api.service.drive.DiskDrive;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.security.sasl.AuthenticationException;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class VideoService {
    private final VideoRepository videoRepository;
    private final DiskDrive videoDrive;

    @Transactional
    public Video createFile(MultipartFile file) throws IOException {
        String filename = videoDrive.createFile(file);

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Video video = Video.builder()
                .uploader(user)
                .createdDate(Timestamp.valueOf(LocalDateTime.now()))
                .originalFileName(filename)
                .build();


        return videoRepository.save(video);
    }

    public Video findById(String id) {
        return videoRepository.findById(id);
    }

    public File getFile(String originName) throws IOException {
        return videoDrive.getFile(originName);
    }

    @Transactional
    public void delete(Video video) throws IOException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (video.getUploader() == user) {
            videoDrive.delete(video.getOriginalFileName());
            videoRepository.delete(video);
        } else {
            throw new AuthenticationException("삭제할 수 없습니다.");
        }
    }


    @Transactional
    public void setVideoTitle(String id, String title) {
        Video video = videoRepository.findById(id);
        video.setTitle(title);
    }

    @Transactional
    public VideoResponse getVideoWithUser(String id) {
        VideoResponse video = videoRepository.findVideoInfo(Long.valueOf(id));
        increaseViews(videoRepository.findById(id));
        return video;
    }

    @Transactional
    public void increaseViews(Video video) {
        video.setViews(video.getViews() + 1);
    }

}
