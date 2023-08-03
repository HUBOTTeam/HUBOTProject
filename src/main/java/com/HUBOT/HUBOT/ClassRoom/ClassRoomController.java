package com.HUBOT.HUBOT.ClassRoom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping(path = "/classroom")
public class ClassRoomController {
    private final ClassRoomService classRoomService;

    @Autowired
    public ClassRoomController(ClassRoomService classRoomService) {
        this.classRoomService = classRoomService;
    }

    @PostMapping("/addClassRoom")
    public ResponseEntity<ClassRoom> addClassRoom(@RequestBody ClassRoom classRoom) {
        ClassRoom addedClassRoom = classRoomService.addClassRoom(classRoom);
        if (addedClassRoom != null) {
            return new ResponseEntity<>(addedClassRoom, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getClassRoomById")
    public ResponseEntity<ClassRoom> getClassRoomById(@RequestParam String classRoomId) {
        ClassRoom classRoom = classRoomService.getClassRoomById(classRoomId);
        if (classRoom != null) {
            return new ResponseEntity<>(classRoom, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getClassRoomByClassRoomNumberInBuilding")
    public ResponseEntity<ClassRoom> getClassRoomByClassRoomNumberInBuilding(@RequestParam String buildingId,@RequestParam int classRoomNumber) {
        ClassRoom classRoom = classRoomService.getClassRoomByClassRoomNumberInBuilding(buildingId,classRoomNumber);
        if (classRoom != null) {
            return new ResponseEntity<>(classRoom, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getClassRoomsByBuildingId")
    public ResponseEntity<List<ClassRoom>> getClassRoomsByBuildingId(@RequestParam String buildingId) {
        List<ClassRoom> classRooms = classRoomService.getClassRoomsByBuildingId(buildingId);
        if (!classRooms.isEmpty()) {
            return new ResponseEntity<>(classRooms, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllClassRooms")
    public ResponseEntity<List<ClassRoom>> getAllClassRooms() {
        List<ClassRoom> classRooms = classRoomService.getAllClassRooms();
        if (!classRooms.isEmpty()) {
            return new ResponseEntity<>(classRooms, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateClassRoom")
    public ResponseEntity<ClassRoom> updateClassRoom(@RequestBody ClassRoom classRoom) {
        ClassRoom updatedClassRoom = classRoomService.updateClassRoom(classRoom);
        if (updatedClassRoom != null) {
            return new ResponseEntity<>(updatedClassRoom, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteClassRoom")
    public ResponseEntity<String> deleteClassRoom(@RequestParam String classRoomId) {
        boolean deleted = classRoomService.deleteClassRoom(classRoomId);
        if (deleted) {
            return new ResponseEntity<>("ClassRoom with ID: " + classRoomId + " was deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("ClassRoom with ID: " + classRoomId + " not found", HttpStatus.NOT_FOUND);
        }
    }
}
