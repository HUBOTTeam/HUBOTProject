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
@Document("students")
public class Student {
    @Id
    private String id;
    private String name;
    @CreatedDate
    private LocalDate dob;
    private Integer age;
    @Indexed(unique = true)
    private String email;
    private User user;
    @DBRef
    private Department department;


    public Student(String name,Integer age, String email , User user , Department department) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.user = user;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", user=" + user +
                ", department=" + department +
                '}';
    }
}
