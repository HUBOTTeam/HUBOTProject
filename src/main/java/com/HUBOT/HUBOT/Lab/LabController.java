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

    @PostMapping("/addLab")
    public ResponseEntity<Lab> addLab(@RequestBody Lab lab) {
        Lab addedLab = labService.addLab(lab);
        if (addedLab != null) {
            return new ResponseEntity<>(addedLab, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getLabById")
    public ResponseEntity<Lab> getLabById(@RequestParam String labId) {
        Lab lab = labService.getLabById(labId);
        if (lab != null) {
            return new ResponseEntity<>(lab, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getLabsByBuildingId")
    public ResponseEntity<List<Lab>> getLabsByBuildingId(@RequestParam String buildingId) {
        List<Lab> labs = labService.getLabsByBuildingId(buildingId);
        if (!labs.isEmpty()) {
            return new ResponseEntity<>(labs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllLabs")
    public ResponseEntity<List<Lab>> getAllLabs() {
        List<Lab> labs = labService.getAllLabs();
        if (!labs.isEmpty()) {
            return new ResponseEntity<>(labs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateLab")
    public ResponseEntity<Lab> updateLab(@RequestBody Lab lab) {
        Lab updatedLab = labService.updateLab(lab);
        if (updatedLab != null) {
            return new ResponseEntity<>(updatedLab, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

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
