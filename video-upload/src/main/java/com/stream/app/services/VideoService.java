package com.stream.app.services;


import com.stream.app.entities.Video;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

public interface VideoService {

    Video saveVideo(Video video , MultipartFile file);
    Video getVideo(String title);
    List<Video> getAllVideos();
    Video getById(String id);
}