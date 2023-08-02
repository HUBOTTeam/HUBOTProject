package com.HUBOT.HUBOT.BathRoom;

import com.HUBOT.HUBOT.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping(path = "/bathroom/")
public class BathroomController {
    private final BathroomService bathroomService;

    @Autowired
    public BathroomController(BathroomService bathroomService) {
        this.bathroomService = bathroomService;
    }

    @PostMapping("addBathroom")
    public ResponseEntity<Bathroom> addBathroom(@RequestBody Bathroom bathroom) {
        Bathroom addedBathroom = bathroomService.addBathroom(bathroom);
        if (addedBathroom != null)
            return new ResponseEntity<>(addedBathroom, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("getBathroomInBuilding")
    public ResponseEntity<List<Bathroom>> getBathroomInBuilding(@RequestParam String buildingId) {
        List<Bathroom> bathrooms = bathroomService.getBathroomInBuilding(buildingId);
        if (bathrooms != null && !bathrooms.isEmpty()) {
            return new ResponseEntity<>(bathrooms, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("getBathroomInBuildingByGender")
    public ResponseEntity<List<Bathroom>> getBathroomInBuildingByGender(
            @RequestParam String buildingId, @RequestParam Gender gender) {
        List<Bathroom> bathrooms = bathroomService.getBathroomInBuildingByGender(buildingId, gender);
        if (bathrooms != null && !bathrooms.isEmpty()) {
            return new ResponseEntity<>(bathrooms, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("getAllBathroom")
    public ResponseEntity<List<Bathroom>> getAllBathroom() {
        List<Bathroom> bathrooms = bathroomService.getAllBathrooms();
        if (!bathrooms.isEmpty()) {
            return new ResponseEntity<>(bathrooms, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("updateBathroom")
    public ResponseEntity<String> updateBathroom(@RequestBody Bathroom bathroom) {
        Bathroom updatedBathroom = bathroomService.updateBathroom(bathroom);
        if (updatedBathroom != null) {
            return new ResponseEntity<>(bathroom.getBathroomId() + " updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update " + bathroom.getBathroomId(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("deleteBathroom")
    public void deleteBathroom(@RequestParam String bathroomId) {
       bathroomService.deleteBathroom(bathroomId);
    }
}
