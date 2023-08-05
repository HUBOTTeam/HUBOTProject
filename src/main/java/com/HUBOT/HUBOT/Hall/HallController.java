package com.HUBOT.HUBOT.Hall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/halls")
public class HallController {

    private final HallService hallService;

    @Autowired
    public HallController(HallService hallService) {
        this.hallService = hallService;
    }

    @PostMapping("/addHall")
    public ResponseEntity<Hall> addHall(@RequestBody Hall hall) {
        Hall addedHall = hallService.addHall(hall);
        if (addedHall != null) {
            return new ResponseEntity<>(addedHall, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getHallById")
    public ResponseEntity<Hall> getHallById(@RequestParam String hallId) {
        Hall hall = hallService.getHallById(hallId);
        if (hall != null) {
            return new ResponseEntity<>(hall, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllHalls")
    public ResponseEntity<List<Hall>> getAllHalls() {
        List<Hall> halls = hallService.getAllHalls();
        if (!halls.isEmpty()) {
            return new ResponseEntity<>(halls, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getHallsByName")
    public ResponseEntity<List<Hall>> getHallsByName(@RequestParam String hallName) {
        List<Hall> halls = hallService.getHallsByName(hallName);
        if (!halls.isEmpty()) {
            return new ResponseEntity<>(halls, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getHallsByCapacity")
    public ResponseEntity<List<Hall>> getHallsByCapacity(@RequestParam int capacity) {
        List<Hall> halls = hallService.getHallsByCapacity(capacity);
        if (!halls.isEmpty()) {
            return new ResponseEntity<>(halls, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getHallsInBuilding")
    public ResponseEntity<List<Hall>> getHallsInBuilding(@RequestParam String buildingId) {
        List<Hall> halls = hallService.getAllHallsInBuilding(buildingId);
        if (!halls.isEmpty()) {
            return new ResponseEntity<>(halls, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/updateHall")
    public ResponseEntity<Hall> updateHall(@RequestBody Hall hall) {
        Hall updatedHall = hallService.updateHall(hall);
        if (updatedHall != null) {
            return new ResponseEntity<>(updatedHall, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteHall")
    public ResponseEntity<String> deleteHall(@RequestParam String hallId) {
        boolean deleted = hallService.deleteHall(hallId);
        if (deleted) {
            return new ResponseEntity<>("Hall with ID: " + hallId + " was deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Hall with ID: " + hallId + " not found", HttpStatus.NOT_FOUND);
        }
    }

    // Additional endpoints for filtering and updating halls in a specific building


    @PutMapping("/updateHallName")
    public ResponseEntity<Hall> updateHallName(
            @RequestParam String hallId,
            @RequestParam String hallName) {
        Hall updatedHall = hallService.updateHallName(hallId, hallName);
        if (updatedHall != null) {
            return new ResponseEntity<>(updatedHall, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateCapacity")
    public ResponseEntity<Hall> updateCapacity(
            @RequestParam String hallId,
            @RequestParam int capacity) {
        Hall updatedHall = hallService.updateCapacity(hallId, capacity);
        if (updatedHall != null) {
            return new ResponseEntity<>(updatedHall, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateFloor")
    public ResponseEntity<Hall> updateFloor(
            @RequestParam String hallId,
            @RequestParam int floor) {
        Hall updatedHall = hallService.updateFloor(hallId, floor);
        if (updatedHall != null) {
            return new ResponseEntity<>(updatedHall, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateKeyword")
    public ResponseEntity<Hall> updateKeyword(
            @RequestParam String hallId,
            @RequestParam String keyword) {
        Hall updatedHall = hallService.updateKeyword(hallId, keyword);
        if (updatedHall != null) {
            return new ResponseEntity<>(updatedHall, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
