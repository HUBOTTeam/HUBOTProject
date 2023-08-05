package com.HUBOT.HUBOT.Schedual;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/schedual")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/add")
    public ResponseEntity<Schedule> addSchedual(@RequestBody Schedule schedule) {
        Schedule addedSchedule = scheduleService.addSchedule(schedule);
        if (addedSchedule != null) {
            return new ResponseEntity<>(addedSchedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getById")
    public ResponseEntity<Schedule> getScheduleById(@RequestParam String id) {
        Schedule schedule = scheduleService.getScheduleById(id);
        if (schedule != null) {
            return new ResponseEntity<>(schedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Schedule>> getAllSchedules() {
        List<Schedule> schedules = scheduleService.getAllScheduals();
        if (!schedules.isEmpty()) {
            return new ResponseEntity<>(schedules, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Schedule> updateSchedual(@RequestBody Schedule schedual) {
        Schedule updatedSchedual = scheduleService.updateSchedual(schedual);
        if (updatedSchedual != null) {
            return new ResponseEntity<>(updatedSchedual, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteSchedual(@RequestParam String id) {
        boolean deleted = scheduleService.deleteSchedual(id);
        if (deleted) {
            return new ResponseEntity<>("Schedual with ID: " + id + " was deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Schedual with ID: " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

    // Additional endpoints for handling Schedual
}
