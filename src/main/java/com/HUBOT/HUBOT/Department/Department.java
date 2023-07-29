package com.HUBOT.HUBOT.Department;

import com.HUBOT.HUBOT.Faculity.Faculity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document("departments")
public class Department {
    @Id
    private String departmentId;
    private String departmentName;
    private String keyword;
    private String description;
    @Indexed(unique = true)
    private int departmentLocationId;
    private int floor;
    private Faculity faculity;
}
