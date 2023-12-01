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
        return new ResponseEntity<>(addedNote, HttpStatus.OK);
    }

    @PutMapping("/updateNote")
    public ResponseEntity<Note> updateNoteInSchedule(@RequestBody Note note) {
        Note updatedNote = noteService.updateNoteInSchedule(note);
        return new ResponseEntity<>(updatedNote, HttpStatus.OK);
    }

    //@DeleteMapping("/deleteNote")
  //  public ResponseEntity<String> deleteNoteFromSchedule(@RequestParam String noteId) {
        //  boolean deleted = noteService.deleteNoteFromSchedule(noteId);
//        if (deleted) {
//            return new ResponseEntity<>("Note with ID: " + noteId + " was deleted successfully!", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Note with ID: " + noteId + " not found", HttpStatus.NOT_FOUND);
//        }
//    }

        //}
  //  }
}
