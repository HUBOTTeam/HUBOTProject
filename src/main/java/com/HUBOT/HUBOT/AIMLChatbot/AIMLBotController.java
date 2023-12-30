package com.HUBOT.HUBOT.AIMLChatbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class AIMLBotController {


    private final AIMLBot aimlBot;

    @Autowired
    public AIMLBotController(AIMLBot aimlBot) { // Add SyntaxErrorCorrection to the constructor
        this.aimlBot = aimlBot;
    }

    @PostMapping("/chat")
    public String chatWithBot(@RequestParam String userInput) throws IOException { // Add IOException
        return aimlBot.getResponse(userInput);
    }
}
