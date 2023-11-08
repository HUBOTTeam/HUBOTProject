package com.HUBOT.HUBOT.Admin;


import com.HUBOT.HUBOT.Enum.AccessDegree;
import com.HUBOT.HUBOT.Exeption.NumberOfAdminLessThanRequiredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Validated
@RequestMapping(path = "/admin/")
public class AdminController {

    @Autowired
    private final AdminServices adminServices;

    public AdminController(AdminServices adminServices) {
        this.adminServices = adminServices;
    }

    @PostMapping(value = "createAdmin")//add an admin account
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin){
        if (adminServices.addAdmin(admin) != null)
            return new ResponseEntity<>(admin, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "getAdmin")
    public ResponseEntity<Admin> getAdmin(@RequestParam String adminUserName){
        Admin admin = adminServices.getAdmin(adminUserName);
        if(admin != null)
            return new ResponseEntity<>(admin,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "getAllAdmins")
    public ResponseEntity<List<Admin>> getAllAdmins(){
       List<Admin> admins = adminServices.getAllAdmins();
        if(admins != null)
            return new ResponseEntity<>(admins,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping(value = "editName")
    public ResponseEntity<Admin> editName(@RequestParam String adminUserName,@RequestParam String adminFirstName, @RequestParam String adminLastName) {
        Admin admin = adminServices.editName(adminUserName,adminFirstName, adminLastName);
        if (admin != null)
            return new ResponseEntity<>(admin,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "editAdminAccessDegree")
    public ResponseEntity<Admin> editAdminAccessDegree(@RequestParam String adminUserName,@RequestParam AccessDegree adminAccessDegree) throws NumberOfAdminLessThanRequiredException {
        Admin admin = adminServices.editAdminAccessDegree(adminUserName,adminAccessDegree);
        if (admin != null)
            return new ResponseEntity<>(admin,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "editAdminPassword")
    public ResponseEntity<Admin> editAdminPassword(@RequestParam String adminUserName,@RequestParam String password)  {
        Admin admin = adminServices.editAdminPassword(adminUserName,password);
        if (admin != null)
            return new ResponseEntity<>(admin,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping(value = "deleteAdmin")
    public void deleteAdmin(@RequestParam String adminUserName){
        adminServices.deleteAdmin(adminUserName);
    }
}
