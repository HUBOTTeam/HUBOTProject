package com.HUBOT.HUBOT.SportArea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sportAreas")
public class SportAreaController {

    private final SportAreaService sportAreaService;

    @Autowired
    public SportAreaController(SportAreaService sportAreaService) {
        this.sportAreaService = sportAreaService;
    }

    @PostMapping("/addSportArea")
    public ResponseEntity<SportArea> addSportArea(@RequestBody SportArea sportArea) {
        SportArea addedSportArea = sportAreaService.addSportArea(sportArea);
        if (addedSportArea != null) {
            return new ResponseEntity<>(addedSportArea, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getSportAreaById")
    public ResponseEntity<SportArea> getSportAreaById(@RequestParam String sportAreaId) {
        SportArea sportArea = sportAreaService.getSportAreaById(sportAreaId);
        if (sportArea != null) {
            return new ResponseEntity<>(sportArea, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllSportAreas")
    public ResponseEntity<List<SportArea>> getAllSportAreas() {
        List<SportArea> sportAreas = sportAreaService.getAllSportAreas();
        if (!sportAreas.isEmpty()) {
            return new ResponseEntity<>(sportAreas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateSportArea")
    public ResponseEntity<SportArea> updateSportArea(@RequestBody SportArea sportArea) {
        SportArea updatedSportArea = sportAreaService.updateSportArea(sportArea);
        if (updatedSportArea != null) {
            return new ResponseEntity<>(updatedSportArea, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteSportArea")
    public ResponseEntity<String> deleteSportArea(@RequestParam String sportAreaId) {
        boolean deleted = sportAreaService.deleteSportArea(sportAreaId);
        if (deleted) {
            return new ResponseEntity<>("Sport Area with ID: " + sportAreaId + " was deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Sport Area with ID: " + sportAreaId + " not found", HttpStatus.NOT_FOUND);
        }
    }

    // Additional endpoints to get sport areas by building, type of sport, and name

    @GetMapping("/getSportAreasByBuildingId")
    public ResponseEntity<List<SportArea>> getSportAreasByBuildingId(@RequestParam String buildingId) {
        List<SportArea> sportAreas = sportAreaService.getSportAreasByBuildingId(buildingId);
        if (!sportAreas.isEmpty()) {
            return new ResponseEntity<>(sportAreas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getSportAreasByTypeOfSport")
    public ResponseEntity<List<SportArea>> getSportAreasByTypeOfSport(@RequestParam String typeOfSport) {
        List<SportArea> sportAreas = sportAreaService.getSportAreasByTypeOfSport(typeOfSport);
        if (!sportAreas.isEmpty()) {
            return new ResponseEntity<>(sportAreas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getSportAreasByName")
    public ResponseEntity<List<SportArea>> getSportAreasByName(@RequestParam String sportAreaName) {
        List<SportArea> sportAreas = sportAreaService.getSportAreasByName(sportAreaName);
        if (!sportAreas.isEmpty()) {
            return new ResponseEntity<>(sportAreas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
