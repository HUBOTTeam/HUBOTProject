package com.HUBOT.HUBOT.User;

import com.HUBOT.HUBOT.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Data
@Document("users")
public class User {
    @Id
    private String id;
    @Indexed(unique = true)
    private String userName;
    private String password;
    @Indexed(unique = true)
    private String email;
    Gender gender;
    private String major;
    @CreatedDate
    private LocalDate dob;


    public User(String userName, String password, String email, Gender gender, String major) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.major = major;
    }
}
