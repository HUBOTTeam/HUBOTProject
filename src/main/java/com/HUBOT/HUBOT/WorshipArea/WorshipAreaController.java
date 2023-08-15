package com.HUBOT.HUBOT.WorshipArea;

import com.HUBOT.HUBOT.Enum.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping(path = "/worshipArea")
public class WorshipAreaController {
    private final WorshipAreaService worshipAreaService;

    @Autowired
    public WorshipAreaController(WorshipAreaService worshipAreaService) {
        this.worshipAreaService = worshipAreaService;
    }

    @PostMapping("/addWorshipArea")
    public ResponseEntity<WorshipArea> addWorshipArea(@RequestBody WorshipArea worshipArea) {
        WorshipArea addedWorshipArea = worshipAreaService.addWorshipArea(worshipArea);
        if (addedWorshipArea != null) {
            return new ResponseEntity<>(addedWorshipArea, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getWorshipAreaById")
    public ResponseEntity<WorshipArea> getWorshipAreaById(@RequestParam String worshipAreaId) {
        WorshipArea worshipArea = worshipAreaService.getWorshipAreaById(worshipAreaId);
        if (worshipArea != null) {
            return new ResponseEntity<>(worshipArea, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getWorshipAreasByBuildingId")
    public ResponseEntity<List<WorshipArea>> getWorshipAreasByBuildingId(@RequestParam String buildingId) {
        List<WorshipArea> worshipAreas = worshipAreaService.getWorshipAreasByBuildingId(buildingId);
        if (!worshipAreas.isEmpty()) {
            return new ResponseEntity<>(worshipAreas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getAllWorshipAreas")
    public ResponseEntity<List<WorshipArea>> getAllWorshipAreas() {
        List<WorshipArea> worshipAreas = worshipAreaService.getAllWorshipAreas();
        if (worshipAreas != null) {
            return new ResponseEntity<>(worshipAreas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getWorshipAreasByGenderAndBuilding")
    public ResponseEntity<List<WorshipArea>> getWorshipAreasByGenderAndBuilding(
            @RequestParam Gender gender,
            @RequestParam String buildingId) {
        List<WorshipArea> worshipAreas = worshipAreaService.getWorshipAreasByGenderAndBuilding(gender, buildingId);
        if (!worshipAreas.isEmpty()) {
            return new ResponseEntity<>(worshipAreas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateWorshipAreaGender")
    public ResponseEntity<WorshipArea> updateWorshipAreaGender(@RequestParam String worshipAreaId,@RequestParam Gender gender) {
        WorshipArea updatedWorshipArea = worshipAreaService.updateWorshipAreaGender(worshipAreaId,gender);
        if (updatedWorshipArea != null) {
            return new ResponseEntity<>(updatedWorshipArea, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/updateWorshipAreaKeyword")
    public ResponseEntity<WorshipArea> updateWorshipAreaKeyword(@RequestParam String worshipAreaId,@RequestParam String keyword) {
        WorshipArea updatedWorshipArea = worshipAreaService.updateWorshipAreaKeyword(worshipAreaId,keyword);
        if (updatedWorshipArea != null) {
            return new ResponseEntity<>(updatedWorshipArea, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteWorshipArea")
    public ResponseEntity<String> deleteWorshipArea(@RequestParam String worshipAreaId) {
        boolean deleted = worshipAreaService.deleteWorshipArea(worshipAreaId);
        if (deleted) {
            return new ResponseEntity<>("WorshipArea with ID: " + worshipAreaId + " was deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("WorshipArea with ID: " + worshipAreaId + " not found", HttpStatus.NOT_FOUND);
        }
    }
}
