package com.HUBOT.HUBOT.WorshipArea;

import com.HUBOT.HUBOT.Gender;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorshipAreaRepository extends MongoRepository<WorshipArea,String> {
    List<WorshipArea> findByBuildingBuildingId(String buildingId);

    List<WorshipArea> findByGenderAndBuildingBuildingId(Gender gender, String buildingId);

}
