package com.HUBOT.HUBOT.Building;

import com.HUBOT.HUBOT.Building.Building;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingsRepository extends MongoRepository<Building, String> {
    Building findByBuildingName(String buildingName);

    void deleteByBuildingName(String buildingName);
}
