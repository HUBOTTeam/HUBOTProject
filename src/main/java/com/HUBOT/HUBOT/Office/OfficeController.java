package com.HUBOT.HUBOT.Office;

import com.HUBOT.HUBOT.Department.Department;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "office")
public class OfficeController {

    private OfficeServices officeServices;

    @PostMapping(value = "addOffice")
    public ResponseEntity<Office> addOffice(@RequestBody Office office){
        Office addOffice = officeServices.addOffice(office);
        if(addOffice != null)
            return new ResponseEntity<>(addOffice, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "getAllOffices")
    public ResponseEntity<List<Office>> getAllOffices(){
        List<Office> offices = officeServices.getAllOffices();
        if (!offices.isEmpty())
            return new ResponseEntity<>(offices,HttpStatus.OK);
        return new ResponseEntity<>(offices,HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "getOfficeById")
    public ResponseEntity<Office> getOffice(@RequestParam String officeId){
        Office office = officeServices.getOffice(officeId);
        if (office != null)
            return new ResponseEntity<>(office,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "getOfficeByDepartment")
    public ResponseEntity<List<Office>> getOfficeByDepartment(@RequestParam Department department){
        List<Office> office = officeServices.getOfficeByDepartment(department);
        if (office != null)
            return new ResponseEntity<>(office,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "updateOfficeKeyword")
    public ResponseEntity<Office> updateOfficeKeyword(@RequestParam String office_id,@RequestParam String keyword){
        Office office = officeServices.updateOfficeKeyword(office_id,keyword);
        if (office != null)
            return new ResponseEntity<>(office,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "deleteOffice")
    public ResponseEntity<Office> deleteOffice(String office_id) {
        Office office = officeServices.deleteOffice(office_id);
        if (office != null)
            return new ResponseEntity<>(office,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
