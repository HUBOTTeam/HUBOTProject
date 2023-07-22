package com.HUBOT.HUBOT.Department;

import com.HUBOT.HUBOT.Faculity.Faculity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document("departments")
public class Department {
    @Id
    private int departmentId;
    @Indexed(unique = true)
    private String departmentName;
    private String keyword;
    private String description;
    @Indexed(unique = true)
    private int departmentLocationId;
    @DBRef
    private Faculity faculity;
    private int floor;
}
