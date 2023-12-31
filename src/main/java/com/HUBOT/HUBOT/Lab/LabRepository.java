package com.HUBOT.HUBOT.Lab;

import com.HUBOT.HUBOT.Building.Building;
import com.HUBOT.HUBOT.Enum.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabRepository extends MongoRepository<Lab, String> {
//    List<Lab> findByBuildingBuildingId(String buildingId);
//    List<Lab> findByBuildingBuildingIdAndLabNumber(String buildingId, int labNumber);
//    List<Lab> findLabByBuildingIdAndCategory(String buildingId, Category category);
//    List<Lab> findLabsByCategory(Category category);

}