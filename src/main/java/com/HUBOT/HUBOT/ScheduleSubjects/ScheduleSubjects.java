package com.HUBOT.HUBOT.ScheduleSubjects;

import com.HUBOT.HUBOT.Course.Course;
import com.HUBOT.HUBOT.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("ScheduleSubjects")
public class ScheduleSubjects {
    @Id
    private String subjectId;
    @DBRef
    private Student student;
    @DBRef
    private Course course;
    private LocalTime startTime;
    private LocalTime endTime;
    private List<String> selectedDays;

}
