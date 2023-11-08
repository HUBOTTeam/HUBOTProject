package com.HUBOT.HUBOT.ChatbotNLP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HubotServices {
    private final HubotRepository hubotRepository;

    @Autowired
    HubotServices (HubotRepository hubotRepository, HubotSentenceDetector hubotSentenceDetector){
        this.hubotRepository = hubotRepository;
    }
    public Hubot addUserInput(Hubot hubot) {
        return hubotRepository.insert(hubot);
    }



}
