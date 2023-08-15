package com.HUBOT.HUBOT.FAQ;

import com.HUBOT.HUBOT.Enum.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaqRepository extends MongoRepository<Faq, Integer> {
    Faq findByFaqId(String faqId);
    Faq findByQuestion(String question);
    List<Faq> findByCategory(Category category);
}
