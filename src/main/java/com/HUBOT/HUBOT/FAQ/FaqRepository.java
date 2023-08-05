package com.HUBOT.HUBOT.FAQ;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqRepository extends MongoRepository<Faq, Integer> {
    Faq findByFaqId(int faqId);
    Faq findByQuestion(String question);
}
