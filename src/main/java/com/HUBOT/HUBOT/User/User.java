package com.HUBOT.HUBOT.User;

import com.HUBOT.HUBOT.Enum.Gender;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Document("users")
public class User {
    @Id
    private String id;

    @JsonProperty("userName")
    @Indexed(unique = true)
    private String userName;

    @JsonProperty("password")
    private String password;

//    @JsonProperty("email")
//    @Indexed(unique = true)
//    private String email;
//
//    @JsonProperty("gender")
//    private Gender gender;

    @CreatedDate
    private LocalDate dob;

    @JsonCreator
    public User(
            @JsonProperty("userName") String userName,
            @JsonProperty("password") String password) {
        this.userName = userName;
        this.password = password;
    }

}
