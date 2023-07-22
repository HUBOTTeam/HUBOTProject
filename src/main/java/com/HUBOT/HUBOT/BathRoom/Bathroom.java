package com.HUBOT.HUBOT.BathRoom;

import com.HUBOT.HUBOT.Building.Building;
import com.HUBOT.HUBOT.Gender;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("bathrooms")
public class Bathroom {
    @Id
    private String bathroomId;
    private String keyword;
    private Gender gender;
    @DBRef
    private Building building; // Represents a reference to the Building document
    @Indexed(unique = true)
    private String bathroomLocationId;
    private int floor;
    @CreatedDate
    private LocalDateTime addedDate;//date that bathroom created

    public Bathroom(String keyword,
                      Gender gender,
                         Building building,
                            String bathroomLocationId,
                              int floor) {
        this.keyword = keyword;
        this.gender = gender;
        this.building = building;
        this.bathroomLocationId = bathroomLocationId;
        this.floor = floor;
    }
}
