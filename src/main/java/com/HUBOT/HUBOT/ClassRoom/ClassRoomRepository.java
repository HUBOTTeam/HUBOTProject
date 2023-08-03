package com.HUBOT.HUBOT.ClassRoom;

import com.HUBOT.HUBOT.Building.Building;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRoomRepository extends MongoRepository<ClassRoom, String> {
    List<ClassRoom> findByBuildingBuildingId(String buildingId);
    @Query("{ 'building.buildingId' : ?0, 'classRoomNumber' : ?1 }")
    ClassRoom findClassRoomByBuildingIdAndClassRoomNumber(String buildingId, int classRoomNumber);

    // Add any additional query methods if needed
}
