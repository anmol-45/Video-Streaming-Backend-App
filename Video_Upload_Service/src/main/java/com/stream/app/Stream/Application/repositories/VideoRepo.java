package com.stream.app.Stream.Application.repositories;

import com.stream.app.Stream.Application.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VideoRepo extends JpaRepository<Video, Long> {

    Optional<Video> findByTitle(String s);
}
