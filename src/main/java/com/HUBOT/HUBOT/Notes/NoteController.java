package com.HUBOT.HUBOT.Notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/addNote")
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        Note addedNote = noteService.addNote(note);
        if (addedNote != null) {
            return new ResponseEntity<>(addedNote, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getNotesByStudentIdAndCourseId")
    public ResponseEntity<List<Note>> getNotesByStudentIdAndCourseId(@RequestParam String studentId, @RequestParam String courseId) {
        List<Note> notes = noteService.getNotesByStudentIdAndCourseId(studentId, courseId);
        if (!notes.isEmpty()) {
            return new ResponseEntity<>(notes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteNote")
    public ResponseEntity<String> deleteNoteById(@RequestParam String noteId) {
        boolean deleted = noteService.deleteNoteById(noteId);
        if (deleted) {
            return new ResponseEntity<>("Note with ID: " + noteId + " was deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Note with ID: " + noteId + " not found", HttpStatus.NOT_FOUND);
        }
    }

    // Add more endpoints as needed
}
