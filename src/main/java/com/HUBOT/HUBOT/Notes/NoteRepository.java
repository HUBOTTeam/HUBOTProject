package com.HUBOT.HUBOT.Notes;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface NoteRepository extends MongoRepository<Note, String> {

    @NotNull
    Optional<Note> findById(@NotNull String noteId);
    Note findByStudentIdAndSubjectsSubjectId(String studentId, String subjectId);
}
