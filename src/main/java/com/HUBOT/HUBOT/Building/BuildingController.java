package com.HUBOT.HUBOT.Building;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/building")
public class BuildingController {

    private final BuildingServices buildingService;

    public BuildingController(BuildingServices buildingService) {
        this.buildingService = buildingService;
    }

    @PostMapping("/add")
    public String addBuilding(@RequestBody Building building) {
        return buildingService.addBuilding(building);
    }

    @GetMapping("/all")
    public List<Building> getAllBuildings() {
        return buildingService.getAllBuildings();
    }

    @GetMapping("/get")
    public ResponseEntity<Building> getBuilding(@RequestParam String buildingName) {
        Building building = buildingService.getBuildingByName(buildingName);
        if (building == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(building, HttpStatus.OK);
        }
    }

    @PutMapping("/update")
    public String updateBuildingKeyword(@RequestParam String buildingName, @RequestParam String keyword) {
        return buildingService.updateBuildingKeyword(buildingName, keyword);
    }

    @DeleteMapping("/delete")
    public String deleteBuilding(@RequestParam String buildingName) {
        return buildingService.deleteBuilding(buildingName);
    }

}
