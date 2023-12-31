package com.HUBOT.HUBOT.Instructor;

import com.HUBOT.HUBOT.Department.Department;
import com.HUBOT.HUBOT.Enum.Gender;
import com.HUBOT.HUBOT.Office.Office;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("instructors")
public class Instructor {
    @Id
    private String instructor_id;
    @DBRef
    private Department department;
    @DBRef
    private Office office;
    private String email;
    private String instructorFirstName;
    private String instructorLastName;
    private Gender gender;
}
