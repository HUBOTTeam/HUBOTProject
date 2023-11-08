package com.HUBOT.HUBOT.ChatbotNLP;

import com.HUBOT.HUBOT.Building.Building;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HubotRepository extends MongoRepository<Hubot, String> {
}
