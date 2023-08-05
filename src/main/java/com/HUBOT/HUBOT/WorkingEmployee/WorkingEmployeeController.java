package com.HUBOT.HUBOT.WorkingEmployee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workingEmployees")
public class WorkingEmployeeController {

    private final WorkingEmployeeService workingEmployeeService;

    @Autowired
    public WorkingEmployeeController(WorkingEmployeeService workingEmployeeService) {
        this.workingEmployeeService = workingEmployeeService;
    }

    @PostMapping("/addWorkingEmployee")
    public ResponseEntity<WorkingEmployee> addWorkingEmployee(@RequestBody WorkingEmployee workingEmployee) {
        WorkingEmployee addedWorkingEmployee = workingEmployeeService.addWorkingEmployee(workingEmployee);
        if (addedWorkingEmployee != null) {
            return new ResponseEntity<>(addedWorkingEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllWorkingEmployees")
    public ResponseEntity<List<WorkingEmployee>> getAllWorkingEmployees() {
        List<WorkingEmployee> workingEmployees = workingEmployeeService.getAllWorkingEmployees();
        if (!workingEmployees.isEmpty()) {
            return new ResponseEntity<>(workingEmployees, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getWorkingEmployeeById")
    public ResponseEntity<WorkingEmployee> getWorkingEmployeeById(@RequestParam String workingEmployeeId) {
        WorkingEmployee workingEmployee = workingEmployeeService.getWorkingEmployeeById(workingEmployeeId);
        if (workingEmployee != null) {
            return new ResponseEntity<>(workingEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getWorkingEmployeeByFullName")
    public ResponseEntity<WorkingEmployee> getWorkingEmployeeByFullName(
            @RequestParam String firstName,
            @RequestParam String lastName) {
        WorkingEmployee workingEmployee = workingEmployeeService.getWorkingEmployeeByFullName(firstName, lastName);
        if (workingEmployee != null) {
            return new ResponseEntity<>(workingEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateWorkingEmployee")
    public ResponseEntity<WorkingEmployee> updateWorkingEmployee(@RequestBody WorkingEmployee workingEmployee) {
        WorkingEmployee updatedWorkingEmployee = workingEmployeeService.updateWorkingEmployee(workingEmployee);
        if (updatedWorkingEmployee != null) {
            return new ResponseEntity<>(updatedWorkingEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteWorkingEmployee")
    public ResponseEntity<String> deleteWorkingEmployee(@RequestParam String workingEmployeeId) {
        boolean deleted = workingEmployeeService.deleteWorkingEmployee(workingEmployeeId);
        if (deleted) {
            return new ResponseEntity<>("Working Employee with ID: " + workingEmployeeId + " was deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Working Employee with ID: " + workingEmployeeId + " not found", HttpStatus.NOT_FOUND);
        }
    }
}
