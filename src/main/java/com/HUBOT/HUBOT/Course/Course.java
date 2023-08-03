package com.HUBOT.HUBOT.Course;

import com.HUBOT.HUBOT.Department.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("courses")
public class Course {
    @Id
    private String courseId;
    @Indexed(unique = true)
    private int courseNumber;
    private String courseName;
    private String keyword;
    private String description;
    private int pointsOfDifficulty;
    private int creditHours;
    @DBRef
    private Department department;
    @CreatedDate
    private LocalDateTime addedDate;

}
