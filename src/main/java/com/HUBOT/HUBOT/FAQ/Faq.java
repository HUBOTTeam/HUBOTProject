package com.HUBOT.HUBOT.FAQ;

import org.springframework.data.annotation.Id;

public class Faq {
    @Id
    private int faqId;
    private String question;
    private String answer;
    private String category;
}
