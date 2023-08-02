package com.HUBOT.HUBOT.Building;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BuildingRepository extends MongoRepository<Building, String> {
    Building findByBuildingName(String buildingName);
    void deleteByBuildingName(String buildingName);
}
