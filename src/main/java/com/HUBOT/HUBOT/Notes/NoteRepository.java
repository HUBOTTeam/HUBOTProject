package com.HUBOT.HUBOT.Notes;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NoteRepository extends MongoRepository<Note, String> {
    List<Note> findByStudentIdAndCourseId(String studentId, String courseId);
}
