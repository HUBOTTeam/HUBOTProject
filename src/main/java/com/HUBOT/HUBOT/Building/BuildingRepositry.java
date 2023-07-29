package com.HUBOT.HUBOT.Building;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepositry extends MongoRepository<Building,String> {
    Building findBybuildingName(String buildingName);
    void deleteBybuildingName(String buildingName);

}
