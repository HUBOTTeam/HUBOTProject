package com.HUBOT.HUBOT.WorkingOffice;

import com.HUBOT.HUBOT.WorkingDepartment.WorkingDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workingOffice")
public class WorkingOfficeController {

    private final WorkingOfficeService workingOfficeService;

    @Autowired
    public WorkingOfficeController(WorkingOfficeService workingOfficeService) {
        this.workingOfficeService = workingOfficeService;
    }

    @PostMapping("/addWorkingOffice")
    public ResponseEntity<WorkingOffice> addWorkingOffice(@RequestBody WorkingOffice workingOffice) {
        WorkingOffice addedWorkingOffice = workingOfficeService.addWorkingOffice(workingOffice);
        return new ResponseEntity<>(addedWorkingOffice, HttpStatus.OK);
    }

    @GetMapping("/getAllWorkingOffices")
    public ResponseEntity<List<WorkingOffice>> getAllWorkingOffices() {
        List<WorkingOffice> workingOffices = workingOfficeService.getAllWorkingOffices();
        return new ResponseEntity<>(workingOffices, HttpStatus.OK);
    }

    @GetMapping("/getWorkingOfficeById")
    public ResponseEntity<WorkingOffice> getWorkingOfficeById(@RequestParam String workingOfficeId) {
        Optional<WorkingOffice> workingOffice = workingOfficeService.getWorkingOfficeById(workingOfficeId);
        return workingOffice.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getWorkingOfficesByWorkingDepartment")
    public ResponseEntity<List<WorkingOffice>> getWorkingOfficesByWorkingDepartment(@RequestParam String workingDepartmentId) {
        List<WorkingOffice> workingOffices = workingOfficeService.getWorkingOfficesByWorkingDepartment(workingDepartmentId);
        if (!workingOffices.isEmpty()) {
            return new ResponseEntity<>(workingOffices, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/updateKeywordAndFloor")
    public ResponseEntity<WorkingOffice> updateKeywordAndFloor(
            @RequestParam String workingOfficeId,
            @RequestParam String keyword,
            @RequestParam int floor) {
        WorkingOffice updatedWorkingOffice = workingOfficeService.updateKeywordAndFloor(workingOfficeId, keyword, floor);
        if (updatedWorkingOffice != null) {
            return new ResponseEntity<>(updatedWorkingOffice, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteWorkingOffice")
    public ResponseEntity<String> deleteWorkingOffice(@RequestParam String workingOfficeId) {
        workingOfficeService.deleteWorkingOffice(workingOfficeId);
        return new ResponseEntity<>("Working Office deleted successfully.", HttpStatus.OK);
    }
}
