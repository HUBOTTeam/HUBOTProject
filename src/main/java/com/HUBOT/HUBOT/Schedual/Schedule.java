package com.HUBOT.HUBOT.Schedual;

import com.HUBOT.HUBOT.Course.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Schedule")
public class Schedule {
    @Id
    private String id;
    @DBRef
    private Course course;
    private String instructor;
    // Add other relevant fields for the current course schedule
}
