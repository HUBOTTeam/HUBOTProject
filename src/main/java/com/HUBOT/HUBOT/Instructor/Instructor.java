package com.HUBOT.HUBOT.Instructor;

import com.HUBOT.HUBOT.Department.Department;
import com.HUBOT.HUBOT.Gender;
import com.HUBOT.HUBOT.Office.Office;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document("instructors")
public class Instructor {
    @Id
    private String instructor_id;
    private String instructor_name;
    Gender gender;
    @DBRef
    private Office office;
    @DBRef
    private Department department;
}
