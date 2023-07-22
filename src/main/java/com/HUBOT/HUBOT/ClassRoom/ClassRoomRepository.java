package com.HUBOT.HUBOT.ClassRoom;

import com.HUBOT.HUBOT.Building.Building;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRoomRepository extends MongoRepository<ClassRoom, Integer> {
    List<ClassRoom> findByBuildingBuildingId(String buildingId);

    // Add any additional query methods if needed
}
