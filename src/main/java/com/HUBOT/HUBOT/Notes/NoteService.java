package com.HUBOT.HUBOT.Notes;

import com.HUBOT.HUBOT.Schedual.Schedule;
import com.HUBOT.HUBOT.Schedual.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final ScheduleService scheduleService;

    @Autowired
    public NoteService(NoteRepository noteRepository, ScheduleService scheduleService) {
        this.noteRepository = noteRepository;
        this.scheduleService = scheduleService;
    }

    public Note addNoteToSchedule(Note note) {
        // Add note to repository
        Note addedNote = noteRepository.save(note);

        // Update associated schedule with the new note
        Schedule schedule = addedNote.getSchedule();
//        if (schedule != null) {
//            schedule.getNotes().add(addedNote);
//            scheduleService.updateSchedule(schedule);
//        }

        return addedNote;
    }

    public Note updateNoteInSchedule(Note note) {
        // Update note in repository
        Note updatedNote = noteRepository.save(note);

        // Update associated schedule with the updated note
        Schedule schedule = updatedNote.getSchedule();
//        if (schedule != null) {
//            scheduleService.updateSchedule(schedule);
//        }

        return updatedNote;
    }

    public boolean deleteNoteFromSchedule(String noteId) {
        // Find the note to be deleted
        Note note = noteRepository.findById(noteId).orElse(null);
        if (note != null) {
            // Delete note from repository
            noteRepository.delete(note);

            // Update associated schedule after deleting note
            Schedule schedule = note.getSchedule();
//            if (schedule != null) {
//                schedule.getNotes().remove(note);
//                scheduleService.updateSchedule(schedule);
//            }
            return true;
        }
        return false;
    }

    // Other methods...
}
