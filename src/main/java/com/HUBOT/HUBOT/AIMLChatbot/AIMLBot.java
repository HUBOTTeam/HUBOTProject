package com.HUBOT.HUBOT.AIMLChatbot;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.springframework.stereotype.Component;

@Component
public class AIMLBot {

    private final String botName = "super";
    private final String pathToBot = " C:\\Users\\User\\Desktop\\Project\\project1\\AIML\\program-ab-0.0.4.3";

    private Bot bot;
    private Chat chatSession;

    public AIMLBot() {
        initializeBot();
    }

    private void initializeBot() {
        org.alicebot.ab.MagicBooleans.trace_mode = true;
        bot = new Bot(botName, pathToBot);
        chatSession = new Chat(bot);
    }

    public String getResponse(String userInput) {
        return chatSession.multisentenceRespond(userInput);
    }
}
