package com.HUBOT.HUBOT.User;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/user/")
public class UserController {

    @Autowired
    UserServices userServices;

    @GetMapping(value = "/getAllUsers")
    public List<User> getAllUsers(){
        return userServices.getAllUsers();
    }

    @GetMapping(value = "/getUser/{userName}")
    public User getUser(@PathVariable String userName){
        return userServices.getUser(userName);
    }

    @PostMapping(value = "/createUser")
    public String addUser(@RequestBody User user){
        return userServices.addUser(user);
    }

    @PutMapping(value = "/updateUserName")
    public String udpateUserName(@RequestParam String userName  , @RequestParam String newName){
        return userServices.updateUserName(userName , newName);
    }

    @DeleteMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam String userName){
        return userServices.deleteUser(userName);
    }
}
