package com.stream.app.Stream.Application.services.videoServiceImpl;

import com.stream.app.Stream.Application.entities.Video;
import com.stream.app.Stream.Application.services.VideoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    //create the folder path
    @Value("${video.files}")
    String DIR;

    @PostConstruct
    public void init(){
        File file = new File(DIR);

        if(!file.exists()){
            boolean mkdir = file.mkdir();

            if(mkdir)
                System.out.println("Folder created");
        }

    }
    @Override
    public String saveVideo(Video video, MultipartFile file) {


        try{

            String fileName = file.getOriginalFilename();
            String contentType = file.getContentType();
            InputStream inputStream = file.getInputStream();

            //create the file path including file name
            assert fileName != null;
            String cleanFilePath = StringUtils.cleanPath(fileName);

            String cleanDir = StringUtils.cleanPath(DIR);

            Path path = Paths.get(cleanDir, cleanFilePath);
            System.out.println(path);


            //save the video in local folder

            Files.copy(inputStream , path , StandardCopyOption.REPLACE_EXISTING);

            // save the meta data in db

            video.setContentType(contentType);
            video.setFilePath(path.toString());

            //return the success message

            return "Video saved Successfully";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "video unable to be saved";
    }

    @Override
    public Video getVideo(String title) {
        return null;
    }

    @Override
    public List<Video> getAllVideos() {
        return List.of();
    }

    @Override
    public Video getById(String id) {
        return null;
    }
}
