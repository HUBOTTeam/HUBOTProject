package com.HUBOT.HUBOT.student;

import com.HUBOT.HUBOT.Course.Course;
import com.HUBOT.HUBOT.Department.Department;
import com.HUBOT.HUBOT.Enum.Gender;
import com.HUBOT.HUBOT.User.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@Document("students")
public class Student {
    @Id
    private String id;
    @DBRef
    private User user;
    @DBRef
    private Department department;
    private String firstName;
    private String middleName;
    private String lastName;
    @Indexed(unique = true)
    private String email;
    private Gender gender;

}
