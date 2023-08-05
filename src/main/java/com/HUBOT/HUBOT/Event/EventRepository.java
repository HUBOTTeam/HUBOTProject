package com.HUBOT.HUBOT.Event;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EventRepository extends MongoRepository<Event, String> {
    List<Event> findByStudentId(String studentId);
}
