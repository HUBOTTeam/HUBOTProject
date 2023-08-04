package com.HUBOT.HUBOT.Lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping(path = "/lab")
public class LabController {
    private final LabService labService;

    @Autowired
    public LabController(LabService labService) {
        this.labService = labService;
    }

    // Endpoint to add a new lab
    @PostMapping("/addLab")
    public ResponseEntity<Lab> addLab(@RequestBody Lab lab) {
        Lab addedLab = labService.addLab(lab);
        if (addedLab != null) {
            return new ResponseEntity<>(addedLab, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint to get a lab by its ID
    @GetMapping("/getLabById")
    public ResponseEntity<Lab> getLabById(@RequestParam String labId) {
        Lab lab = labService.getLabById(labId);
        if (lab != null) {
            return new ResponseEntity<>(lab, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to get all labs in a building by building ID
    @GetMapping("/getLabsByBuildingId")
    public ResponseEntity<List<Lab>> getLabsByBuildingId(@RequestParam String buildingId) {
        List<Lab> labs = labService.getLabsByBuildingId(buildingId);
        if (!labs.isEmpty()) {
            return new ResponseEntity<>(labs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to get all labs
    @GetMapping("/getAllLabs")
    public ResponseEntity<List<Lab>> getAllLabs() {
        List<Lab> labs = labService.getAllLabs();
        if (!labs.isEmpty()) {
            return new ResponseEntity<>(labs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to get labs by building ID and lab number
    @GetMapping("/getLabByBuildingAndLabNumber")
    public ResponseEntity<List<Lab>> getLabByBuildingAndLabNumber(
            @RequestParam String buildingId,
            @RequestParam int labNumber) {
        List<Lab> labs = labService.getLabsByBuildingIdAndLabNumber(buildingId, labNumber);
        if (!labs.isEmpty()) {
            return new ResponseEntity<>(labs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to update the category of a lab by lab ID
    @PutMapping("/updateLabCategory")
    public ResponseEntity<Lab> updateLabCategory(
            @RequestParam String labId,
            @RequestParam String category) {
        Lab updatedLab = labService.updateLabCategory(labId, category);
        if (updatedLab != null) {
            return new ResponseEntity<>(updatedLab, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to update the keyword of a lab by lab ID
    @PutMapping("/updateLabKeyword")
    public ResponseEntity<Lab> updateLabKeyword(
            @RequestParam String labId,
            @RequestParam String keyword) {
        Lab updatedLab = labService.updateLabKeyword(labId, keyword);
        if (updatedLab != null) {
            return new ResponseEntity<>(updatedLab, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to update the lab location ID of a lab by lab ID
    @PutMapping("/updateLabLocationId")
    public ResponseEntity<Lab> updateLabLocationId(
            @RequestParam String labId,
            @RequestParam int labLocationId) {
        Lab updatedLab = labService.updateLabLocationId(labId, labLocationId);
        if (updatedLab != null) {
            return new ResponseEntity<>(updatedLab, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to update the floor of a lab by lab ID
    @PutMapping("/updateLabFloor")
    public ResponseEntity<Lab> updateLabFloor(
            @RequestParam String labId,
            @RequestParam int floor) {
        Lab updatedLab = labService.updateLabFloor(labId, floor);
        if (updatedLab != null) {
            return new ResponseEntity<>(updatedLab, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // Endpoint to update a lab (general update) by lab ID
    @PutMapping("/updateLab")
    public ResponseEntity<Lab> updateLab(@RequestBody Lab lab) {
        Lab updatedLab = labService.updateLab(lab);
        if (updatedLab != null) {
            return new ResponseEntity<>(updatedLab, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to delete a lab by lab ID
    @DeleteMapping("/deleteLab")
    public ResponseEntity<String> deleteLab(@RequestParam String labId) {
        boolean deleted = labService.deleteLab(labId);
        if (deleted) {
            return new ResponseEntity<>("Lab with ID: " + labId + " was deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Lab with ID: " + labId + " not found", HttpStatus.NOT_FOUND);
        }
    }
}