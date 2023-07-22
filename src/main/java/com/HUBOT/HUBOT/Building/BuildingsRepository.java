package com.HUBOT.HUBOT.Building;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BuildingsRepository extends MongoRepository<Building,String> {
    Building findByBuildingName(String buildingName);
    Building deleteByBuildingName(String buildingName);

}
