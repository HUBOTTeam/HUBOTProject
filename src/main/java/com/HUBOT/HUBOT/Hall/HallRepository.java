package com.HUBOT.HUBOT.Hall;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HallRepository extends MongoRepository<Hall, String> {
    List<Hall> findByBuildingBuildingId(String buildingId);

    List<Hall> findByHallName(String hallName);

    List<Hall> findByCapacity(int capacity);
}
