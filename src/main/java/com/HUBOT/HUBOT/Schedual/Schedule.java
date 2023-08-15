package com.HUBOT.HUBOT.Schedual;

import com.HUBOT.HUBOT.Course.Course;
import com.HUBOT.HUBOT.Notes.Note;
import com.HUBOT.HUBOT.Enum.Semester;
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
    @DBRef
    private String studentId;
    private Semester semester;
    private int year;
    @DBRef
    private List<Course> courses = new ArrayList<>();
    @DBRef
    private List<Note> notes; // List of associated notes

}
