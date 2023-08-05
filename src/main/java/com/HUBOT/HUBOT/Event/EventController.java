package com.HUBOT.HUBOT.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/addEvent")
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        Event addedEvent = eventService.addEvent(event);
        if (addedEvent != null) {
            return new ResponseEntity<>(addedEvent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getEventsByStudentId")
    public ResponseEntity<List<Event>> getEventsByStudentId(@RequestParam String studentId) {
        List<Event> events = eventService.getEventsByStudentId(studentId);
        if (!events.isEmpty()) {
            return new ResponseEntity<>(events, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateEventTitle")
    public ResponseEntity<Event> updateEventTitle(@RequestParam String eventId, @RequestParam String eventTitle) {
        Event updatedEvent = eventService.updateEventTitle(eventId, eventTitle);
        if (updatedEvent != null) {
            return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateMessage")
    public ResponseEntity<Event> updateMessage(@RequestParam String eventId, @RequestParam String message) {
        Event updatedEvent = eventService.updateMessage(eventId, message);
        if (updatedEvent != null) {
            return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updatePriorityLevel")
    public ResponseEntity<Event> updatePriorityLevel(@RequestParam String eventId, @RequestParam int priorityLevel) {
        Event updatedEvent = eventService.updatePriorityLevel(eventId, priorityLevel);
        if (updatedEvent != null) {
            return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateDateOut")
    public ResponseEntity<Event> updateDateOut(@RequestParam String eventId, @RequestParam LocalDateTime dateOut) {
        Event updatedEvent = eventService.updateDateOut(eventId, dateOut);
        if (updatedEvent != null) {
            return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteEvent")
    public ResponseEntity<String> deleteEvent(@RequestParam String eventId) {
        boolean deleted = eventService.deleteEvent(eventId);
        if (deleted) {
            return new ResponseEntity<>("Event with ID: " + eventId + " was deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Event with ID: " + eventId + " not found", HttpStatus.NOT_FOUND);
        }
    }
}
