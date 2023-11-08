package com.HUBOT.HUBOT.ChatbotNLP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("hubot")
public class Hubot {
    @Id
    private String queryId;
    private String userInput;
    @CreatedDate
    private LocalDateTime addedDate;

}


