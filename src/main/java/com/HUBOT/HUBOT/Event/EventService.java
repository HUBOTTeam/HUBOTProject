package com.HUBOT.HUBOT.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getEventsByStudentId(String studentId) {
        return eventRepository.findByStudentId(studentId);
    }

    public Event updateEventTitle(String eventId, String eventTitle) {
        Event event = eventRepository.findById(eventId).orElse(null);
        if (event != null) {
            event.setEventTitle(eventTitle);
            return eventRepository.save(event);
        } else {
            return null;
        }
    }

    public Event updateMessage(String eventId, String message) {
        Event event = eventRepository.findById(eventId).orElse(null);
        if (event != null) {
            event.setMessage(message);
            return eventRepository.save(event);
        } else {
            return null;
        }
    }

    public Event updatePriorityLevel(String eventId, int priorityLevel) {
        Event event = eventRepository.findById(eventId).orElse(null);
        if (event != null) {
            event.setPriorityLevel(priorityLevel);
            return eventRepository.save(event);
        } else {
            return null;
        }
    }

    public Event updateDateOut(String eventId, LocalDateTime dateOut) {
        Event event = eventRepository.findById(eventId).orElse(null);
        if (event != null) {
            event.setDateOut(dateOut);
            return eventRepository.save(event);
        } else {
            return null;
        }
    }

    public boolean deleteEvent(String eventId) {
        Optional<Event> existingEvent = eventRepository.findById(eventId);
        if (existingEvent.isPresent()) {
            eventRepository.delete(existingEvent.get());
            return true;
        }
        return false;
    }
}
