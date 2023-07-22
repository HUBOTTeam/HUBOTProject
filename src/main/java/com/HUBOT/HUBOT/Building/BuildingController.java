package com.HUBOT.HUBOT.Building;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/building/")
public class BuildingController {


    private BuildingServices buildingServices;

    @PostMapping(value = "addBuilding")
    public String addBuilding(@RequestBody Building building){
        return buildingServices.addBuilding(building);
    }@GetMapping(value = "getAllBuildings")
    public List<Building> getAllBuildings() {
        return buildingServices.getAllBuildings();
    }
    @GetMapping("getBuilding")
    public ResponseEntity<Building> getBuilding(@RequestParam String buildingName){
        Building building = buildingServices.getBuilding(buildingName);
        if(building == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
            return new ResponseEntity<>(building, HttpStatus.OK);
    }

    @PutMapping(value = "updateBuildingKeyword")
    public String updateBuildingKeyword(@RequestParam String buildingName , @RequestParam String keyword){
        return buildingServices.updateBuildingKeyword(buildingName,keyword);
    }
    @DeleteMapping(value = "deleteBuilding")
    public String deleteBuilding(@RequestParam String buildingName){
        return buildingServices.deleteBuilding(buildingName);
    }


}
