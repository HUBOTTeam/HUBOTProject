package com.HUBOT.HUBOT.ChatBot;

import org.springframework.stereotype.Service;

@Service
public class ChatbotServices {
    // Assuming you have an instance of your AIML-based chatbot injected or initialized here

    public Chatbot processUserInput(String userInput) {
        // Logic to interact with the AIML-based chatbot
        // Call your chatbot instance and process userInput to get botResponse

        String botResponse = ""; // Replace this with the actual logic to get the response

        return new Chatbot(userInput, botResponse);
    }
}

