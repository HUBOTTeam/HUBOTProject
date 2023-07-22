package com.HUBOT.HUBOT.Admin;


import org.springframework.beans.factory.annotation.Autowired;
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


    @PostMapping(value = "createAdmin")//add admin account
    public String addAdmin(@RequestBody Admin admin){
        return adminServices.addAdmin(admin);
    }

    @GetMapping(value = "getAdmin")
    public Admin getAdmin(@RequestParam String adminUserName){
        return adminServices.getAdmin(adminUserName);
    }

    @GetMapping(value = "getAllAdmins")
    public List<Admin> getAllAdmins(){
       return adminServices.getAllAdmins();
    }

    @PutMapping(value = "editAdminPassword")
    public Admin editAdminPassword(@RequestParam String adminUserName,@RequestParam String password){
        return adminServices.editAdminPassword(adminUserName,password);
    }

    @PutMapping(value = "editName")
    public Admin editName(@RequestParam String adminUserName,@RequestParam String adminFirstName, @RequestParam String adminLastName) {
        return adminServices.editName(adminUserName,adminFirstName, adminLastName);
    }

    @PutMapping(value = "editAdminAccessDegree")
    public Admin editAdminAccessDegree(@RequestParam String adminUserName,@RequestParam int adminAccessDegree){
               return adminServices.editAdminAccessDegree(adminUserName,adminAccessDegree);
    }


    @DeleteMapping(value = "deleteAdmin")
    public String deleteAdmin(@RequestParam String adminUserName){
        return adminServices.deleteAdmin(adminUserName);
    }
}
