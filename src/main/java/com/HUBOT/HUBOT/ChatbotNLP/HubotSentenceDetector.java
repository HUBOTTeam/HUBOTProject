package com.HUBOT.HUBOT.ChatbotNLP;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import org.languagetool.JLanguageTool;
import org.languagetool.Languages;
import org.languagetool.rules.RuleMatch;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class HubotSentenceDetector {

    JLanguageTool languageTool;
    List<RuleMatch> matches;
    String correctedText;

    InputStream tokenizationModelIn;
    TokenizerModel tokenizationModel;
    Tokenizer tokenizer;
    ArrayList<String> tokens;

    InputStream sentenceDetectorModelIn;
    SentenceModel sentenceModel;
    SentenceDetectorME sentenceDetectorME;
    String userInput;
    String []sentencesArray;

    public void setUserInput(String userInput){
        this.userInput = userInput;
    }
    public void detectSentences() {
        try {
            sentenceDetectorModelIn = new FileInputStream("opennlp-en-ud-ewt-sentence-1.0-1.9.3.bin");
            sentenceModel = new SentenceModel(sentenceDetectorModelIn);
            sentenceDetectorME = new SentenceDetectorME(sentenceModel);
            sentencesArray = sentenceDetectorME.sentDetect(userInput);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void correctSyntax() {
        try {
            JLanguageTool langTool = new JLanguageTool(Languages.getLanguageForShortCode("en-GB"));
            matches = langTool.check("A sentence with a error in the Hitchhiker's Guide tot he Galaxy");
        //    correctedText = languageTool.correct(userInput, matches);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}
