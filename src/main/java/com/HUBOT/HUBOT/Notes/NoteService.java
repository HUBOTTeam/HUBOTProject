package com.HUBOT.HUBOT.Notes;

import com.HUBOT.HUBOT.Schedual.ScheduleSubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository, ScheduleSubjectsRepository scheduleSubjectsRepository) {
        this.noteRepository = noteRepository;
    }


    public Note updateNoteInSchedule(Note note) {
        return noteRepository.save(note);
    }



}
