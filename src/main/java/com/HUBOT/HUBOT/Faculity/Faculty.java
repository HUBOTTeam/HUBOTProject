package com.HUBOT.HUBOT.Faculity;

import com.HUBOT.HUBOT.Building.Building;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("faculities")
public class Faculty {
    @Id
    private String facultyId;
    @DBRef
    private Building building;
    @Indexed(unique = true)
    private String facultyName;
    @Indexed(unique = true)
    private int facultyLocationId;
    private String keyword;
    private String description;
    private int floor;
}
