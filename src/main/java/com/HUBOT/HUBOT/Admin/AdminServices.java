package com.HUBOT.HUBOT.Admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminServices {
    @Autowired
    AdminRepository adminRepository;
    public String addAdmin(Admin admin) {//here admin with access degree of 3 can add new admin to the system
         //   if(admin.getAccessDegree() == 5) {
                if (adminRepository.findByAdminUserName(admin.getAdminUserName()) == null) //checking if user already exist
                {
                    try
                    {
                        adminRepository.insert(admin);
                        return "Admin " + admin.getAdminUserName() + " was added successfully";
                    }
                    catch (Exception e) {
                        throw new RuntimeException("There is something wrong in adding admin!");
                    }
                }
                else
                    throw new RuntimeException("User name exist choose another one!");
            }
          //  else
               // throw new RuntimeException("you are not allowed to add admin!\n your access degree is " + admin.getAccessDegree());
    //}

    public Admin getAdmin(String adminUserName){
        try {
            return adminRepository.findByAdminUserName(adminUserName);
        }
        catch(NullPointerException e) {
            throw new RuntimeException("user doesn't exist check your input!");
        }
    }


    public List<Admin> getAllAdmins(){
        try {
            return adminRepository.findAll();
        }
           catch (Exception e){
            throw new RuntimeException("there is something wrong in retrieving admins!");
           }
    }


    public Admin editName(String adminUserName,String adminFirstName,String adminLastName) {
        try {
            Admin admin = adminRepository.findByAdminUserName(adminUserName);
                admin.setAdminFirstName(adminFirstName);
                admin.setAdminLastName(adminLastName);
                adminRepository.save(admin);
                return admin;
        } catch (NullPointerException e) {
            throw new RuntimeException("there is something wrong in retrieving admin\n check the input!");
        }
    }

    public Admin editAdminAccessDegree(String adminUserName, int adminAccessDegree){
        try {
            Admin admin = adminRepository.findByAdminUserName(adminUserName);
            admin.setAccessDegree(adminAccessDegree);
            adminRepository.save(admin);
            return admin;
        } catch (NullPointerException e) {
            throw new RuntimeException("there is something wrong in retrieving admin\n check the input!");
        }
    }

    public Admin editAdminLastName(String adminUserName, String adminLastName) {
        try {
            Admin admin = adminRepository.findByAdminUserName(adminUserName);
            admin.setAdminLastName(adminLastName);
            adminRepository.save(admin);
            return admin;
        } catch (NullPointerException e) {
            throw new RuntimeException("there is something wrong in retrieving admin\n check the input!");
        }
    }
    public String deleteAdmin(String adminUserName){
        Admin admin = adminRepository.findByAdminUserName(adminUserName);
        if (admin != null) {
            adminRepository.delete(admin);
            return "Admin was deleted successfully";
        } else {
            throw new RuntimeException("Admin with username " + adminUserName + " not found.");
        }
    }



    public Admin editAdminPassword(String adminUserName, String password) {
        try {
            Admin admin = adminRepository.findByAdminUserName(adminUserName);
            admin.setPassword(admin.getPassword());
            return admin;
        }catch (NullPointerException e) {
            throw new RuntimeException("there is something wrong in retrieving admin\n check the input!");
        }
    }
}
