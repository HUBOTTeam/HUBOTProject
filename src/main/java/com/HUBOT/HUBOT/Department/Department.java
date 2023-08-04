package com.HUBOT.HUBOT.Department;

import com.HUBOT.HUBOT.Faculity.Faculty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Document("departments")
public class Department {
    @Id
    private String departmentId;
    @Indexed(unique = true)
    private String departmentName;
    private String keyword;
    private String description;
    @Indexed(unique = true)
    private int departmentLocationId;
    private int floor;
    @DBRef
    private Faculty faculity;
    @CreatedDate
    private LocalDateTime addedTime;
}
