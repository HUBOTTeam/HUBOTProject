package com.HUBOT.HUBOT.AIMLChatbot;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.springframework.stereotype.Component;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.text.similarity.LevenshteinDistance;

import org.languagetool.JLanguageTool;
import org.languagetool.Language;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.rules.RuleMatch;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

@Component
public class AIMLBot {

    private final String botName = "super";
    private final String pathToBot = "C:\\Users\\User\\Desktop\\Project\\project1\\AIML\\program-ab-0.0.4.3";

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

    public String getResponse(String userInput) throws IOException {
        userInput = correctSentence(userInput);
        String csvAnswer = searchCSVForAnswer(userInput);
        if (csvAnswer != null) {
            return csvAnswer;
        }

        String botResponse = chatSession.multisentenceRespond(userInput);
        return (botResponse != null && !botResponse.isEmpty()) ? botResponse : "Sorry, I couldn't find an answer.";
    }

    private String searchCSVForAnswer(String userInput) throws IOException {
        userInput = correctSentence(userInput);
        String mostSimilarAnswer = null;
        double maxSimilarity = -1.0;
        double similarityThreshold = 0.7; // Adjust threshold as needed

        List<String> fileNames = List.of(
                "C:\\Users\\User\\Desktop\\Project\\deepcsv\\financial.aiml.csv",
                "C:\\Users\\User\\Desktop\\Project\\deepcsv\\graduatedstudents.aiml.csv",
                "C:\\Users\\User\\Desktop\\Project\\deepcsv\\regesteration.aiml.csv",
                "C:\\Users\\User\\Desktop\\Project\\deepcsv\\regesteration2.aiml.csv",
                "C:\\Users\\User\\Desktop\\Project\\deepcsv\\loans.aiml.csv",
                "C:\\Users\\User\\Desktop\\Project\\deepcsv\\sportsactivity.aiml.csv",
                "C:\\Users\\User\\Desktop\\Project\\deepcsv\\universityid.aiml.csv"
        );

        for (String filePath : fileNames) {
            try (Reader reader = new FileReader(filePath);
                 CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

                for (CSVRecord csvRecord : csvParser) {
                    String question = csvRecord.get(0);  // Assuming the question is in the first column
                    String answer = csvRecord.get(1);    // Assuming the answer is in the second column

                    // Calculate similarity using Levenshtein distance
                    double similarity = calculateSimilarity(userInput, question);
                    if (similarity >= similarityThreshold && similarity > maxSimilarity) {
                        maxSimilarity = similarity;
                        mostSimilarAnswer = answer;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return mostSimilarAnswer;
    }

    // Calculate similarity using Levenshtein distance
    private double calculateSimilarity(String inputText, String csvQuestion) {
        LevenshteinDistance levenshtein = new LevenshteinDistance();
        return 1.0 - ((double) levenshtein.apply(inputText.toLowerCase(), csvQuestion.toLowerCase()) /
                Math.max(inputText.length(), csvQuestion.length()));
    }
    public String correctSentence(String sentence) throws IOException {
        JLanguageTool languageTool = new JLanguageTool(new AmericanEnglish());
        List<RuleMatch> matches = languageTool.check(sentence);

        for (RuleMatch match : matches) {
            if (match.getRule().getId().equals("MORFOLOGIK_RULE_EN_US")) {
                List<String> suggestedReplacements = match.getSuggestedReplacements();
                if (!suggestedReplacements.isEmpty()) {
                    // Choose the first suggestion (most suitable) automatically
                    String suggestedReplacement = suggestedReplacements.get(0);

                    // Replace the error in the sentence
                    int startIndex = match.getFromPos();
                    int endIndex = match.getToPos();
                    sentence = sentence.substring(0, startIndex) + suggestedReplacement + sentence.substring(endIndex);
                    break;  // Stop after correcting the first error (you can modify this behavior)
                }
            }
        }

        return sentence;
    }
}
