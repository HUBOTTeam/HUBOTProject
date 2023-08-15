package com.HUBOT.HUBOT.Admin;


import com.HUBOT.HUBOT.Enum.AccessDegree;
import com.HUBOT.HUBOT.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("admins")
public class Admin {
    @Id
    private String adminId;
    @Indexed(unique = true)
    private String adminUserName;
    private AccessDegree accessDegree;//admins have different access abilities FOUR is the highest and down to one
    private String adminFirstName;
    private String adminLastName;
    private Gender gender;
    private String password;
    @CreatedDate
    private LocalDateTime addedDate;//date that admin account created

}
