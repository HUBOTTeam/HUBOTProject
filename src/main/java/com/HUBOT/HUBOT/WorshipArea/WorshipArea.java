package com.HUBOT.HUBOT.WorshipArea;

import com.HUBOT.HUBOT.Building.Building;
import com.HUBOT.HUBOT.Enum.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@NoArgsConstructor
@Document("worshipAreas")
public class WorshipArea {
    @Id
    private String worshipAreaId;
    @DBRef
    private Building building; // Represents a reference to the Building document
    @Indexed(unique = true)
    private String worshipAreaLocationId;
    private Gender gender;
    private int floor;
    private String keyword;

    public WorshipArea(Building building, Gender gender, int floor,String keyword, String worshipAreaLocationId) {
        this.building = building;
        this.gender = gender;
        this.floor = floor;
        this.keyword = keyword;
        this.worshipAreaLocationId = worshipAreaLocationId;
    }

}
