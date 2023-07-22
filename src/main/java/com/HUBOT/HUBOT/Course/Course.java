package com.HUBOT.HUBOT.Course;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("courses")
public class Course {
    @Id
    private int courseId;

    @Indexed(unique = true)
    private int courseNumber;

    private String courseName;
    private String keyword;
    private String description;

    private int pointsOfDifficulty;

    private int departmentId;
    private int creditHours;
}
