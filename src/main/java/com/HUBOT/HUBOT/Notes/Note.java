package com.HUBOT.HUBOT.Notes;

import com.HUBOT.HUBOT.Course.Course;
import com.HUBOT.HUBOT.Schedual.ScheduleSubjects;
import com.HUBOT.HUBOT.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("notes")
public class Note {
    @Id
    private String noteId;
    @DBRef
    private Student student;
    @DBRef
    private ScheduleSubjects subjects;
    private String noteTitle;
    private String note;
}
