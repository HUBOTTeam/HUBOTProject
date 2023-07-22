package com.HUBOT.HUBOT.Lab;

import com.HUBOT.HUBOT.Building.Building;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabRepository extends MongoRepository<Lab, String> {
    List<Lab> findByBuildingBuildingId(String buildingId);

    // Add any additional query methods if needed
}
