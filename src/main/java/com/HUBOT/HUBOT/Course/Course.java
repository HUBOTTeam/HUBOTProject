package com.HUBOT.HUBOT.Course;

import com.HUBOT.HUBOT.Department.Department;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Nullable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("courses")
public class Course {
    @Id
    private String courseId;
    @Indexed(unique = true)
    @DBRef
    private Department department;
    @Nullable
    @DBRef
    private Course prerequisiteCurseNumber;
    @Nullable
    @DBRef
    private Course synchronous;
    private long courseNumber;
    private String courseName;
    @Nullable
    private String keyword;
    @Nullable
    private String description;
    private int pointsOfDifficulty;
    private int creditHours;
    @CreatedDate
    private LocalDateTime addedDate;

    @JsonCreator
    public Course(
            @JsonProperty("department") Department department,
            @com.mongodb.lang.Nullable @JsonProperty("prerequisiteCurseNumber") Course prerequisiteCurseNumber, @com.mongodb.lang.Nullable @JsonProperty("synchronous") Course synchronous,
            @JsonProperty("courseNumber") long courseNumber, @JsonProperty("courseName") String courseName,
            @com.mongodb.lang.Nullable @JsonProperty("keyword") String keyword, @com.mongodb.lang.Nullable @JsonProperty("description") String description, @JsonProperty("pointsOfDifficulty") int pointpointsOfDifficulty,
            @JsonProperty("creditHours") int creditHours) {
       this.department = department;
       this.prerequisiteCurseNumber = prerequisiteCurseNumber;
       this.synchronous = synchronous;
       this.courseNumber = courseNumber;
       this.courseName = courseName;
       this.description = description;
       this.keyword = keyword;
       this.pointsOfDifficulty = pointpointsOfDifficulty;
       this.creditHours = creditHours;
    }

}
