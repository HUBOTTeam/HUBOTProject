package com.HUBOT.HUBOT.FAQ;

import com.HUBOT.HUBOT.Enum.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaqService {

    private final FaqRepository faqRepository;

    @Autowired
    public FaqService(FaqRepository faqRepository) {
        this.faqRepository = faqRepository;
    }

    public Faq addFaq(Faq faq) {
        return faqRepository.save(faq);
    }

    public Faq getByQuestion(String question) {//not working currently
        return faqRepository.findByQuestion(question);
    }

    public List<Faq> getByCategory(Category category) {
        return faqRepository.findByCategory(category);
    }
    public List<Faq> getAllQuestions() {
        return faqRepository.findAll();
    }
    public Faq updateFaq(Faq faq) {
        return faqRepository.save(faq);
    }
    public Faq updateQuestion(String faqId, String updatedQuestion) {
        Faq faq = faqRepository.findByFaqId(faqId);
        if(faq != null){
            faq.setQuestion(updatedQuestion);
            return faq;
        }
        else
            return null;
    }

    public boolean deleteFaqById(String faqId) {
        Faq existingFaq = faqRepository.findByFaqId(faqId);
        if (existingFaq != null) {
            faqRepository.delete(existingFaq);
            return true;
        }
        return false;
    }
}
