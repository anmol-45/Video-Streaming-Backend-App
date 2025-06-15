package com.stream.app.Stream.Application.services.videoServiceImpl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.stream.app.Stream.Application.entities.Video;
import com.stream.app.Stream.Application.repositories.VideoRepo;
import com.stream.app.Stream.Application.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

import java.util.List;
import java.util.Map;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private VideoRepo videoRepo;

    @Override
    public String saveVideo(Video video, MultipartFile file) {
        try {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap(
                    "resource_type", "video"  // very important for non-image files
            ));

            String url = (String) uploadResult.get("secure_url");
            String contentType = file.getContentType();

            video.setTitle(video.getTitle());
            video.setDescription(video.getDescription());
            video.setContentType(contentType);
            video.setFilePath(url); // cloud URL

            videoRepo.save(video);

            return "Video uploaded successfully to Cloudinary at URL: " + url;

        } catch (IOException e) {
            e.printStackTrace();
            return "Video upload failed.";
        }
    }

    @Override
    public Video getVideo(String title) {
        return videoRepo.findByTitle(title).orElse(null);
    }

    @Override
    public List<Video> getAllVideos() {
        return videoRepo.findAll();
    }

    @Override
    public Video getById(String id) {
        return videoRepo.findById(Long.parseLong(id)).orElse(null);
    }
}
