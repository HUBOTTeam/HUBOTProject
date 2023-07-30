package com.HUBOT.HUBOT.ClassRoom;

import com.HUBOT.HUBOT.Building.Building;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document("classrooms")
public class ClassRoom {
    @Id
    private String classRoomId;
    @DBRef
    private Building building;
    private int classRoomNumber;
    private int capacity;
    private int classRoomLocationId;
    private int floor;
    private String keyword;
}
