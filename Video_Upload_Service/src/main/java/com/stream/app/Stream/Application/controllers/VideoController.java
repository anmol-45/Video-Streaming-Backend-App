package com.stream.app.Stream.Application.controllers;


import com.stream.app.Stream.Application.entities.Video;
import com.stream.app.Stream.Application.services.VideoService;
import com.stream.app.Stream.Application.services.videoServiceImpl.VideoServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/videos")
public class VideoController {

    VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping
    public String SaveVideos(@RequestParam("file") MultipartFile file,
                             @RequestParam("title") String title,
                             @RequestParam("description") String description) {

        Video video = new Video();
        video.setTitle(title);
        video.setDescription(description);

        return videoService.saveVideo(video, file);
    }

    @GetMapping
    public List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }

    @GetMapping("/search/{title}")
    public Video getVideoByTitle(@PathVariable String title) {
        return videoService.getVideo(title);
    }

    @GetMapping("/{id}")
    public Video getVideoById(@PathVariable String id) {
        return videoService.getById(id);
    }

}
