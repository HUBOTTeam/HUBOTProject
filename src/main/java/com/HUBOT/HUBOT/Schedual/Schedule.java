package com.HUBOT.HUBOT.Schedual;

import com.HUBOT.HUBOT.Course.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Schedule")
public class Schedule {
    @Id
    private String id;
    private String studentId;
    private int semester;
    private int year;
    private List<Course> courses = new ArrayList<>();

}
