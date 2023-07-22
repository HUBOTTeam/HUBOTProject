package com.HUBOT.HUBOT.Admin;


import com.HUBOT.HUBOT.Gender;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document("admins")
public class Admin {
    @Id
    private String adminId;
    private int accessDegree;//admins have different access abilities
    private String adminFirstName;
    private String adminLastName;
    private Gender gender;
    @Indexed(unique = true)
    private String adminUserName;
    private String password;
    @CreatedDate
    private LocalDateTime addedDate;//date that admin account created

    public Admin(int accessDegree,
                 String adminFirstName,
                 String adminLastName,
                 Gender gender,
                 String adminUserName,
                 String password) {
        this.accessDegree = accessDegree;
        this.adminFirstName = adminFirstName;
        this.adminLastName = adminLastName;
        this.gender = gender;
        this.adminUserName = adminUserName;
        this.password = password;
    }
}
