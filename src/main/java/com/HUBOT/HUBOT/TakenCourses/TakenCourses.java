package com.HUBOT.HUBOT.TakenCourses;

import com.HUBOT.HUBOT.Course.Course;
import com.HUBOT.HUBOT.Enum.Semester;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("TakenCourses")
public class TakenCourses {
    @Id
    private String takenCoursesId;
    @DBRef
    private String studentId;
    @DBRef
    private Course course;
//    private Semester semester;
//    private int year;
//    private double grade;
    @CreatedDate
    private LocalDateTime dateAdded;
}
