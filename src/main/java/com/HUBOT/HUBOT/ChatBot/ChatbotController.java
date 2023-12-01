package com.HUBOT.HUBOT.ChatBot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/userquery")
public class ChatbotController {
    @Autowired
    ChatbotServices chatbotServices;

    @RequestMapping("/query")
    public ResponseEntity<Chatbot> userInput(@RequestParam String userInput) {
        // Assuming ChatbotServices contains logic to interact with your chatbot

        // Call the service method to process the user input
        Chatbot chatbotResponse = chatbotServices.processUserInput(userInput);

        // Return the response to the client
        return ResponseEntity.ok().body(chatbotResponse);
    }
}
