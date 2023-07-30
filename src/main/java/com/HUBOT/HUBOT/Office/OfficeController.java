package com.HUBOT.HUBOT.Office;

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
    public ResponseEntity<String> addOffice(@RequestBody Office office){
        Office addOffice = officeServices.addOffice(office);

        if(addOffice != null)
            return new ResponseEntity<>(addOffice.toString()+" inserted successfully!", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "getAllOffices")
    public ResponseEntity<List<Office>> getAllOffices(){
        List<Office> offices = officeServices.getAllOffices();

        if (!offices.isEmpty())
            return new ResponseEntity<>(offices,HttpStatus.OK);
        return new ResponseEntity<>(offices,HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "getOffice")
    public ResponseEntity<Office> getOffice(@RequestParam String office_id){
        Office office = officeServices.getOffice(office_id);

        if (office != null)
            return new ResponseEntity<>(office,HttpStatus.OK);
        return new ResponseEntity<>(office,HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "updateOfficeKeyword")
    public ResponseEntity<String> updateOfficeKeyword(@RequestParam String office_id,@RequestParam String keyword){
        Office office = officeServices.updateOfficeKeyword(office_id,keyword);

        if (office != null)
            return new ResponseEntity<>(office.toString()+" updated successfully!",HttpStatus.OK);
        return new ResponseEntity<>("failed to updated "+office.toString(),HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "deleteOffice")
    public ResponseEntity<String> deleteOffice(String office_id) {
        return officeServices.deleteOffice(office_id);
    }
}
