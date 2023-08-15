package com.HUBOT.HUBOT.FAQ;

import com.HUBOT.HUBOT.Enum.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("FAQ")
public class Faq {
    @Id
    private String faqId;
    private List<Category> category;
    private String question;
    private String answer;
}
