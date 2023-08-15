package com.HUBOT.HUBOT.Building;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/building")
public class BuildingController {

    private final BuildingServices buildingService;

    @Autowired
    public BuildingController(BuildingServices buildingService) {
        this.buildingService = buildingService;
    }

    @PostMapping("/addBuilding")
    public ResponseEntity<Building> addBuilding(@RequestBody Building building) {
        Building addedBuilding = buildingService.addBuilding(building);
        if (addedBuilding != null) {
            return new ResponseEntity<>(addedBuilding, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllBuildings")
    public List<Building> getAllBuildings() {
        return buildingService.getAllBuildings();
    }

    @GetMapping("/getBuilding")
    public ResponseEntity<Building> getBuilding(@RequestParam String buildingName) {
        Building building = buildingService.getBuildingByName(buildingName);
        if (building != null) {
            return new ResponseEntity<>(building, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateBuildingKeyword")
    public ResponseEntity<Building> updateBuildingKeyword(@RequestParam String buildingName, @RequestParam String keyword) {
        Building updatedBuilding = buildingService.updateBuildingKeyword(buildingName, keyword);
        if (updatedBuilding != null) {
            return new ResponseEntity<>(updatedBuilding, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/updateBuildingDescription")
    public ResponseEntity<Building> updateBuildingDescription(@RequestParam String buildingName, @RequestParam String description) {
        Building updatedBuilding = buildingService.updateBuildingDescription(buildingName, description);
        if (updatedBuilding != null) {
            return new ResponseEntity<>(updatedBuilding, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateBuildingName")
    public ResponseEntity<Building> updateBuildingName(@RequestParam String buildingName, @RequestParam String buildingNewName) {
        Building updatedBuilding = buildingService.updateBuildingName(buildingName, buildingNewName);
        if (updatedBuilding != null) {
            return new ResponseEntity<>(updatedBuilding, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteBuilding")
    public ResponseEntity<String> deleteBuilding(@RequestParam String buildingName) {
        buildingService.deleteBuilding(buildingName);
        return new ResponseEntity<>("Building deleted successfully!", HttpStatus.OK);
    }
}
