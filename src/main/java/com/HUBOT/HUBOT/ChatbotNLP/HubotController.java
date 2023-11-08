package com.HUBOT.HUBOT.ChatbotNLP;

import com.HUBOT.HUBOT.Building.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chatbot")
public class HubotController {

    private final HubotServices hubotServices;
    private HubotSentenceDetector hubotSentenceDetector;

    @Autowired
    public HubotController(HubotServices hubotServices, HubotSentenceDetector hubotSentenceDetector) {
        this.hubotServices = hubotServices;
        this.hubotSentenceDetector = hubotSentenceDetector;
    }

    @PostMapping("/userInputSent")
    public ResponseEntity<Hubot> addUserInput(Hubot hubot){
        Hubot hubot1 = hubotServices.addUserInput(hubot);
        if (hubot1 != null) {
            hubotSentenceDetector.setUserInput(hubot1.getUserInput());
            return new ResponseEntity<>(hubot, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
