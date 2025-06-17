package com.stream.app.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CourseId;

    private String name;


//    @OneToMany(mappedBy = "Courses")
//    private List<Video> videoList = new ArrayList<>();

}