package com.HUBOT.HUBOT.Major;

import com.HUBOT.HUBOT.Department.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Major")
public class Major {
    @Id
    private String majorId;
    @DBRef
    private Department department;
    @Indexed(unique = true)
    private String majorName;
    @CreatedDate
    private LocalDateTime dateCreated;
}
