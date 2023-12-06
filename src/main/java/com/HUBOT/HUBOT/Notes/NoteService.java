package com.HUBOT.HUBOT.Notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    @Autowired
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    public Note addNoteToSubject(Note note) {
        Note note1 = noteRepository.findByStudentIdAndSubjectsSubjectId(note.getStudent().getId()
                                                                            ,note.getSubjects().getSubjectId());
        if (note1 == null)
            return noteRepository.insert(note);
        return null;
    }

    public Note getNote(String studentId, String subjectId) {
        return noteRepository.findByStudentIdAndSubjectsSubjectId(studentId,subjectId);
    }

    public String updateNote(String noteId,String note) {
        try {
            Note note1 = noteRepository.findById(noteId).orElse(null);
            if (note1 != null){
                note1.setNote(note);
                noteRepository.save(note1);
                return "note updated successfully";
            }
            return null;

        }catch (Exception e){
            return null;
        }
    }
}
