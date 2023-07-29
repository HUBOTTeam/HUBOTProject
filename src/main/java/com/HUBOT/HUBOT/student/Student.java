package com.HUBOT.HUBOT.student;

import com.HUBOT.HUBOT.Department.Department;
import com.HUBOT.HUBOT.User.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Document("students")
public class Student {
    @Id
    private String id;
    private String name;
    @DBRef
    private User user;
    @DBRef
    private Department department;
}
