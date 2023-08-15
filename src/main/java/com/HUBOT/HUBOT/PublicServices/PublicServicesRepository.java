package com.HUBOT.HUBOT.PublicServices;

import com.HUBOT.HUBOT.Enum.TypeOfService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicServicesRepository extends MongoRepository<PublicServices, String> {

    // Custom queries for filtering public services
    List<PublicServices> findByBuildingId(String buildingId);

    List<PublicServices> findByTypeOfService(TypeOfService typeOfService);

    List<PublicServices> findByPublicServicePlaceName(String publicServicePlaceName);
}
