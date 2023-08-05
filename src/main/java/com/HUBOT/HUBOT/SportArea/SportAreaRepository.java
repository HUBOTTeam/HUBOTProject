package com.HUBOT.HUBOT.SportArea;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportAreaRepository extends MongoRepository<SportArea, String> {
    List<SportArea> findByBuildingBuildingId(String buildingId);

    List<SportArea> findByTypeOfSport(String typeOfSport);

    List<SportArea> findBySportAreaName(String sportAreaName);
}
