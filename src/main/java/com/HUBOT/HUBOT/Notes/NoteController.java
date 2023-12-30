package com.HUBOT.HUBOT.Notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/note")
@Document("notes")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/addNote")
    public ResponseEntity<Note> addNoteToSubject(@RequestBody Note note) {
        Note addedNote = noteService.addNoteToSubject(note);
        if(addedNote != null)
           return new ResponseEntity<>(addedNote, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/getNote")
    public ResponseEntity<Note> getNote(@RequestParam String studentId, @RequestParam String subjectId){
        Note note = noteService.getNote(studentId,subjectId);
        if (note != null)
            return new ResponseEntity<>(note,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/updateNote")
    public ResponseEntity<String> updateNote(@RequestParam String noteId,@RequestParam String note){
        String note1 = noteService.updateNote(noteId,note);
        if (note1 != null)
            return new ResponseEntity<>(note1,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}
