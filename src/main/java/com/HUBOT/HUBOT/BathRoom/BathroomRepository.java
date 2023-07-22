package com.HUBOT.HUBOT.BathRoom;

import com.HUBOT.HUBOT.Gender;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BathroomRepository extends MongoRepository<Bathroom, String> {
    List<Bathroom> findByBuildingBuildingId(String buildingId);

    List<Bathroom> findByBuildingBuildingNameAndGender(String buildingName, Gender gender);

    Bathroom findByKeyword(String keyword);
}
