package com.HUBOT.HUBOT.Building;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document("buildings")
public class Building {

    @Id
    private String buildingId;
    @Indexed(unique = true)
    private String buildingName;
    private String description;
    private String keyword;
    private int locationId;

}
