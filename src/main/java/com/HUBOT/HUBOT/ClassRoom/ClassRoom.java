package com.HUBOT.HUBOT.ClassRoom;

import com.HUBOT.HUBOT.Building.Building;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Document("classrooms")
public class ClassRoom {
    @Id
    private String classRoomId;
    @DBRef
    private Building building;
    @Indexed(unique = true)
    private int classRoomLocationId;
    private int floor;
    private int classRoomNumber;
    private int capacity;
    private String keyword;
    @CreatedDate
    private LocalDateTime addedDate;

    public ClassRoom(){
    }

    public ClassRoom(Building building, int classRoomNumber, int capacity, int classRoomLocationId, int floor, String keyword) {
        this.building = building;
        this.classRoomNumber = classRoomNumber;
        this.capacity = capacity;
        this.classRoomLocationId = classRoomLocationId;
        this.floor = floor;
        this.keyword = keyword;
    }
}