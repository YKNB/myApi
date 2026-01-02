package com.springboot.Api.controller;


import com.google.common.io.Files;
import com.springboot.Api.entity.Video;
import com.springboot.Api.entity.VideoTitleModifyDto;
import com.springboot.Api.repository.VideoListResponse;
import com.springboot.Api.repository.VideoResponse;
import com.springboot.Api.service.video.VideoService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@AllArgsConstructor
@RequestMapping("/api/v1/")
public class VideoController {

    private final VideoService videoService;

    private final int RANDOM_VIDEO_ACCESS_SIZE = 10;

    @PostMapping(
            value = "/user/:id/video",
            consumes = {
                    MediaType.MULTIPART_FORM_DATA_VALUE,
                    MediaType.APPLICATION_OCTET_STREAM_VALUE})
    public ResponseEntity<Map<String, String>> createVideo(
            @RequestPart(value = "content") MultipartFile file) throws IOException {
        Video metaData = videoService.createFile(file);
        Map<String, String> response = new HashMap();
        response.put("videoId", String.valueOf(metaData.getId()));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/videos", produces = "video/mp4")
    public StreamingResponseBody getVideoStream(@PathVariable("id") String id) throws IOException {
        Video video = videoService.findById(id);
        File file = videoService.getFile(video.getOriginalFileName());
        final InputStream is = new FileInputStream(file);

        return os -> {
            readAndWrite(is, os);
        };
    }

    private void readAndWrite(final InputStream is, OutputStream os) {
        try {
            byte[] data = new byte[4096];
            int read = 0;
            while ((read = is.read(data)) > 0) {
                os.write(data, 0, read);
                os.flush();
            }
        } catch(IOException ignored) {

        } finally {
            try {
                is.close();
                os.close();
            } catch(IOException ignored) {
            }
        }
    }

    @DeleteMapping("/video/{id}")
    public void deleteVideo(@PathVariable("id") String id) throws IOException {
        Video video = videoService.findById(id);
        videoService.delete(video);
    }

    @GetMapping("/video/{id}")
    public ResponseEntity<VideoResponse> getVideoInfo(@PathVariable("id") String id) {
        VideoResponse video = videoService.getVideoWithUser(id);
        return new ResponseEntity<>(video, HttpStatus.OK);
    }



    @PatchMapping("/video/{id}")
    public void setVideoTitle(@RequestBody VideoTitleModifyDto dto) {
        videoService.setVideoTitle(dto.getId(), dto.getTitle());
    }


}
