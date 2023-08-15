package com.HUBOT.HUBOT.FAQ;

import com.HUBOT.HUBOT.Enum.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/getAllQuestions")
    public ResponseEntity<List<Faq>> getAllQuestions(){
        List<Faq> faq = faqService.getAllQuestions();
        if (faq != null)
            return new ResponseEntity<>(faq,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/getQuestions")//to find a specific Question by it syntax
    public ResponseEntity<Faq> getByQuestion(@RequestParam String question){//not working currently
        Faq faq = faqService.getByQuestion(question);
        if (faq != null)
            return new ResponseEntity<>(faq,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/getByCategory")
    public ResponseEntity<List<Faq>> getByCategory(@RequestParam Category category){
        List<Faq> faq = faqService.getByCategory(category);
        if (faq != null)
            return new ResponseEntity<>(faq,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
    @PutMapping("/updateQuestion")
    public ResponseEntity<Faq> updateQuestion(@RequestParam String faqId,@RequestParam String updatedQuestion) {
        Faq updatedQ = faqService.updateQuestion(faqId,updatedQuestion);
        if (updatedQ != null) {
            return new ResponseEntity<>(updatedQ, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteFaqById")
    public ResponseEntity<String> deleteFaqById(@RequestParam String faqId) {
        boolean deleted = faqService.deleteFaqById(faqId);
        if (deleted) {
            return new ResponseEntity<>("Faq with ID: " + faqId + " was deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Faq with ID: " + faqId + " not found", HttpStatus.NOT_FOUND);
        }
    }

}
