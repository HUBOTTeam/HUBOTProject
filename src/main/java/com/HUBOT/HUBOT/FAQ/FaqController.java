package com.HUBOT.HUBOT.FAQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/faq")
public class FaqController {

    private final FaqService faqService;

    @Autowired
    public FaqController(FaqService faqService) {
        this.faqService = faqService;
    }

    @PostMapping("/addFaq")
    public ResponseEntity<Faq> addFaq(@RequestBody Faq faq) {
        Faq addedFaq = faqService.addFaq(faq);
        if (addedFaq != null) {
            return new ResponseEntity<>(addedFaq, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateFaq")
    public ResponseEntity<Faq> updateFaq(@RequestBody Faq faq) {
        Faq updatedFaq = faqService.updateFaq(faq);
        if (updatedFaq != null) {
            return new ResponseEntity<>(updatedFaq, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteFaqById")
    public ResponseEntity<String> deleteFaqById(@RequestParam int faqId) {
        boolean deleted = faqService.deleteFaqById(faqId);
        if (deleted) {
            return new ResponseEntity<>("Faq with ID: " + faqId + " was deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Faq with ID: " + faqId + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteFaqByQuestion")
    public ResponseEntity<String> deleteFaqByQuestion(@RequestParam String question) {
        boolean deleted = faqService.deleteFaqByQuestion(question);
        if (deleted) {
            return new ResponseEntity<>("Faq with question: " + question + " was deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Faq with question: " + question + " not found", HttpStatus.NOT_FOUND);
        }
    }
}
