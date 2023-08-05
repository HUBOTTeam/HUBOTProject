package com.HUBOT.HUBOT.SportArea;

import com.HUBOT.HUBOT.Building.Building;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("sportAreas")
public class SportArea {
    @Id
    private String sportAreaId;
    @DBRef
    private Building building;
    private String sportAreaName;
    private String typeOfSport;
    private String keyword;
    @Indexed(unique = true)
    private int sportAreaLocationId;
    @CreatedDate
    private LocalDateTime addedDate;

}
