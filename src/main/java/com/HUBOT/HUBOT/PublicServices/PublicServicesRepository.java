package com.HUBOT.HUBOT.PublicServices;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicServicesRepository extends MongoRepository<PublicServices, String> {
}
