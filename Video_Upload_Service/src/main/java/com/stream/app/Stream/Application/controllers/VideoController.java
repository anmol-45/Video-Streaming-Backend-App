package com.stream.app.Stream.Application.controllers;


import com.stream.app.Stream.Application.entities.Video;
import com.stream.app.Stream.Application.services.VideoService;
import com.stream.app.Stream.Application.services.videoServiceImpl.VideoServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/videos")
public class VideoController {

    VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping
    public String SaveVideos(   //while using param body will not be accepted
                                // as multipart file divides on the basis of file and
                                // text while request body excepts only single json
                             @RequestParam("file")MultipartFile file,
                                @RequestParam("title")String title,
                                @RequestParam("description")String description){

        Video video = new Video();

        return videoService.saveVideo(video , file);

    }
}
