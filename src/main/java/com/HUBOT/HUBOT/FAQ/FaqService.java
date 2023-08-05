package com.HUBOT.HUBOT.FAQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Faq updateFaq(Faq faq) {
        return faqRepository.save(faq);
    }

    public boolean deleteFaqById(int faqId) {
        Faq existingFaq = faqRepository.findByFaqId(faqId);
        if (existingFaq != null) {
            faqRepository.delete(existingFaq);
            return true;
        }
        return false;
    }

    public boolean deleteFaqByQuestion(String question) {
        Faq existingFaq = faqRepository.findByQuestion(question);
        if (existingFaq != null) {
            faqRepository.delete(existingFaq);
            return true;
        }
        return false;
    }
}
