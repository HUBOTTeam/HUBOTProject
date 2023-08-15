package com.HUBOT.HUBOT.WorkingDepartment;

import com.HUBOT.HUBOT.Building.Building;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("WorkingDepartments")
public class WorkingDepartment {
    @Id
    private String workingDepartmentId;
    @DBRef
    private Building building; // Represents a reference to the Building document
    @Indexed(unique = true)
    private String workingDepartmentLocationId;
    private String workingDepartmentName;
    private String description;
    private String keyword;
    private int floor;
}
