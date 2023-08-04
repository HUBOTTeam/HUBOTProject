package com.HUBOT.HUBOT.Faculity;

import com.HUBOT.HUBOT.Building.Building;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document("faculities")
public class Faculty {
    @Id
    private String facultyId;
    @Indexed(unique = true)
    private String facultyName;
    private String keyword;
    private String description;
    @Indexed(unique = true)
    private int facultyLocationId;
    private int floor;
    @DBRef
    private Building building;
}
