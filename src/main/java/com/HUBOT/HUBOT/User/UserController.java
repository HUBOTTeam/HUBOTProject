package com.HUBOT.HUBOT.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserServices userServices;

    @GetMapping(value = "/getAllUsers")
    public List<User> getAllUsers() {
        return userServices.getAllUsers();
    }

    @GetMapping(value = "/getUser")
    public ResponseEntity<User> getUser(@RequestParam String userName) {
        User user = userServices.getUser(userName);
        if (user != null) {
           return new ResponseEntity<>(user,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/getUserID")
    public ResponseEntity<String> getUserIdByUserName(@RequestParam String userName) {
        String user = userServices.getUserIdByUserName(userName);
        if (user != null) {
            return new ResponseEntity<>(user,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/getUserByID")
    public ResponseEntity<User> getUserById(@RequestParam String id) {
        User user = userServices.getUserById(id);
        if (user != null) {
            return new ResponseEntity<>(user,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        if (userServices.isValidUser(user.getUserName(), user.getPassword())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @PostMapping(value = "/createUser")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        String result = userServices.addUser(user);
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/updateUserName")
    public ResponseEntity<String> updateUserName(@RequestParam String userName, @RequestParam String newName) {
        String result = userServices.updateUserName(userName, newName);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestParam String userName) {
        String result = userServices.deleteUser(userName);
        return ResponseEntity.ok(result);
    }
}
