package com.HUBOT.HUBOT.Lab;

import com.HUBOT.HUBOT.Building.Building;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document("labs")
public class Lab {

    @Id
    private String labId;
    @DBRef
    private Building building;
    private String category;
    private String keyword;
    private int labLocationId;
    private int floor;
}
