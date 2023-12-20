package com.HUBOT.HUBOT.AIMLChatbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AIMLBotController {

    private final AIMLBot aimlBot;

    @Autowired
    public AIMLBotController(AIMLBot aimlBot) {
        this.aimlBot = aimlBot;
    }

    @PostMapping("/chat")
    public String chatWithBot(@RequestParam String userInput) {
        return aimlBot.getResponse(userInput);
    }
}
