package com.stream.app.Stream.Application.services;

import com.stream.app.Stream.Application.entities.Video;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

public interface VideoService {

    String saveVideo(Video video , MultipartFile file);
    Video getVideo(String title);
    List<Video> getAllVideos();
    Video getById(String id);
}
