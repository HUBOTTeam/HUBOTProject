package com.HUBOT.HUBOT.Admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminServices {
    @Autowired
    AdminRepository adminRepository;
    public String addAdmin(Admin admin) {

           if(adminRepository.findByAdminUserName(admin.getAdminUserName()) == null){
        try {
            adminRepository.insert(admin);
            return "Admin "+ admin.getAdminUserName() +" was added successfully";
        }
        catch(Exception e) {
            System.out.print("There is something wrong!");
            return null;
        }
           }
           else {
               System.out.print("User name exist choose another one!");
               return null;
           }
    }

    public Admin getAdmin(String adminUserName){
        try {
            return adminRepository.findByAdminUserName(adminUserName);
        }
        catch(NullPointerException e) {
            System.out.print("user doesn't exist check your input!");
            return null;
        }
    }


    public List<Admin> getAllAdmins(){
            return adminRepository.findAll();
    }

    public Admin editAdminFirstName(Admin admin) {
        if(adminRepository.findByAdminUserName(admin.getAdminUserName()) != null)
            return adminRepository.save(admin);
        else
            return null;
    }
    public Admin editAdminFirstName(String adminUserName,String adminFirstName) {
        try {
            Admin admin = adminRepository.findByAdminUserName(adminUserName);
            admin.setAdminFirstName(adminFirstName);
            adminRepository.save(admin);
            return admin;
        } catch (NullPointerException e) {
            System.out.print("user doesn't exist check your input!");
            return null;
        }
    }

    public Admin editAdminAccessDegree(String adminUserName, int adminAccessDegree){
        try {
            Admin admin = adminRepository.findByAdminUserName(adminUserName);
            admin.setAccessDegree(adminAccessDegree);
            adminRepository.save(admin);
            return admin;
        } catch (NullPointerException e) {
            System.out.print("user doesn't exist check your input!");
            return null;
        }
    }

    public Admin editAdminLastName(String adminUserName, String adminLastName) {
        try {
            Admin admin = adminRepository.findByAdminUserName(adminUserName);
            admin.setAdminLastName(adminLastName);
            adminRepository.save(admin);
            return admin;
        } catch (NullPointerException e) {
            System.out.print("user doesn't exist check your input!");
            return null;
        }
    }
    public String deleteAdmin(String adminUserName){
        try {
            Admin admin = adminRepository.findByAdminUserName(adminUserName);
            adminRepository.delete(admin);
            return "Admin was deleted successfully";
        } catch (NullPointerException e) {
            System.out.print("user doesn't exist check your input!");
            return null;
        }
    }


    public Admin editAdminPassword(String adminUserName, String password) {
        Admin admin = adminRepository.findByAdminUserName(adminUserName);
        if(admin != null){
            admin.setPassword(admin.getPassword());
            return admin;
        }
        return null;
    }
}
