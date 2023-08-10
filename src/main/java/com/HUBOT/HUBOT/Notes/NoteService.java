package com.HUBOT.HUBOT.Notes;

import com.HUBOT.HUBOT.Schedual.Schedule;
import com.HUBOT.HUBOT.Schedual.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final ScheduleRepository scheduleRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository, ScheduleRepository scheduleRepository) {
        this.noteRepository = noteRepository;
        this.scheduleRepository = scheduleRepository;
    }

    public Note addNoteToSchedule(Note note) {
        Note addedNote = noteRepository.save(note);
        Schedule schedule = addedNote.getSchedule();
        if (schedule != null) {
            schedule.getNotes().add(addedNote);
            scheduleRepository.save(schedule);
        }
        return addedNote;
    }

    public Note updateNoteInSchedule(Note note) {
        return noteRepository.save(note);
    }

    public boolean deleteNoteFromSchedule(String noteId) {
        Note note = noteRepository.findById(noteId).orElse(null);
        if (note != null) {
            noteRepository.delete(note);

            Schedule schedule = note.getSchedule();
            if (schedule != null) {
                schedule.getNotes().remove(note);
                scheduleRepository.save(schedule);
            }
            return true;
        }
        return false;
    }

    // Other methods...
}
