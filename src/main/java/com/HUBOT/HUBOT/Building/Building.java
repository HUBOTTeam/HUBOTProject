package com.HUBOT.HUBOT.Building;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Document("buildings")
public class Building {

    @Id
    private String buildingId;
    @Indexed(unique = true)
    private String buildingName;
    private String description;
    private String keyword;
    private int locationId;
    @CreatedDate
    private LocalDateTime addedDate;//date that building created

    public Building(String buildingName, String description,String keyword ,int locationId)  {
        this.buildingName = buildingName;
        this.description = description;
        this.locationId = locationId;
        this.keyword = keyword;
    }

}