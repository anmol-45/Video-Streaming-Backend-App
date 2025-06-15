package com.stream.app.Stream.Application.dto;

import lombok.*;

@Data
@RequiredArgsConstructor
public class VideoDto {
    private final String title;
    private final String description;
    private final String contentType;
    private final String filePath;

    // constructors, getters, setters
}
