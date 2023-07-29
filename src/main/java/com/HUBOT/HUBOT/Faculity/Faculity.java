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
public class Faculity {
    @Id
    private String faculityId;
    private String faculityName;
    private String keyword;
    private String description;
    private int faculityLocationId;
    private int floor;
    @DBRef
    private Building building;
}
