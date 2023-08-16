package com.HUBOT.HUBOT.WorkingDepartment;

import com.HUBOT.HUBOT.Building.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/workingDepartments")
public class WorkingDepartmentController {

    private final WorkingDepartmentService workingDepartmentService;

    @Autowired
    public WorkingDepartmentController(WorkingDepartmentService workingDepartmentService) {
        this.workingDepartmentService = workingDepartmentService;
    }

    @PostMapping("/addWorkingDepartment")
    public ResponseEntity<WorkingDepartment> addWorkingDepartment(@RequestBody WorkingDepartment workingDepartment) {
        WorkingDepartment addedWorkingDepartment = workingDepartmentService.addWorkingDepartment(workingDepartment);
        if (addedWorkingDepartment != null) {
            return new ResponseEntity<>(addedWorkingDepartment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getWorkingDepartmentById")
    public ResponseEntity<WorkingDepartment> getWorkingDepartmentById(@RequestParam String workingDepartmentId) {
        WorkingDepartment workingDepartment = workingDepartmentService.getWorkingDepartmentById(workingDepartmentId);
        if (workingDepartment != null) {
            return new ResponseEntity<>(workingDepartment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getWorkingDepartmentByName")
    public ResponseEntity<WorkingDepartment> getWorkingDepartmentByName(@RequestParam String workingDepartmentName) {
        WorkingDepartment workingDepartment = workingDepartmentService.getWorkingDepartmentByName(workingDepartmentName);
        if (workingDepartment != null) {
            return new ResponseEntity<>(workingDepartment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllWorkingDepartments")
    public ResponseEntity<List<WorkingDepartment>> getAllWorkingDepartments() {
        List<WorkingDepartment> workingDepartments = workingDepartmentService.getAllWorkingDepartments();
        if (!workingDepartments.isEmpty()) {
            return new ResponseEntity<>(workingDepartments, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateWorkingDepartmentName")
    public ResponseEntity<WorkingDepartment> updateWorkingDepartmentName(
            @RequestParam String workingDepartmentId,
            @RequestParam String workingDepartmentName) {
        WorkingDepartment updatedWorkingDepartment = workingDepartmentService.updateWorkingDepartmentName(workingDepartmentId, workingDepartmentName);
        if (updatedWorkingDepartment != null) {
            return new ResponseEntity<>(updatedWorkingDepartment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateWorkingDepartmentDescription")
    public ResponseEntity<WorkingDepartment> updateWorkingDepartmentDescription(
            @RequestParam String workingDepartmentId,
            @RequestParam String description) {
        WorkingDepartment updatedWorkingDepartment = workingDepartmentService.updateWorkingDepartmentDescription(workingDepartmentId, description);
        if (updatedWorkingDepartment != null) {
            return new ResponseEntity<>(updatedWorkingDepartment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateWorkingDepartmentKeyword")
    public ResponseEntity<WorkingDepartment> updateWorkingDepartmentKeyword(
            @RequestParam String workingDepartmentId,
            @RequestParam String keyword) {
        WorkingDepartment updatedWorkingDepartment = workingDepartmentService.updateWorkingDepartmentKeyword(workingDepartmentId, keyword);
        if (updatedWorkingDepartment != null) {
            return new ResponseEntity<>(updatedWorkingDepartment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateWorkingDepartment")
    public ResponseEntity<WorkingDepartment> updateWorkingDepartment(@RequestBody WorkingDepartment workingDepartment) {
        WorkingDepartment updatedWorkingDepartment = workingDepartmentService.updateWorkingDepartment(workingDepartment);
        if (updatedWorkingDepartment != null) {
            return new ResponseEntity<>(updatedWorkingDepartment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteWorkingDepartment")
    public ResponseEntity<String> deleteWorkingDepartment(@RequestParam String workingDepartmentId) {
        boolean deleted = workingDepartmentService.deleteWorkingDepartment(workingDepartmentId);
        if (deleted) {
            return new ResponseEntity<>("Working Department with ID: " + workingDepartmentId + " was deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Working Department with ID: " + workingDepartmentId + " not found", HttpStatus.NOT_FOUND);
        }
    }
}
