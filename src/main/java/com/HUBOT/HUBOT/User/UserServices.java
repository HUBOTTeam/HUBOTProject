package com.HUBOT.HUBOT.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(String userName) {
        return userRepository.findByUserName(userName);
    }

    public String getUserIdByUserName(String userName){
        try {
        return userRepository.findByUserName(userName).getId();
        }catch (Exception e){
            return null;
        }
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public boolean isValidUser(String username, String password) {
        User user = userRepository.findByUserName(username);
        return user != null && user.getPassword().equals(password);
    }

    public String addUser(User user) {
        if(userRepository.findByUserName(user.getUserName()) != null)
            return "username exist please choose another one";
        else {
            userRepository.insert(user);
            return "user " + user.getUserName() + " added successfully!";
        }

    }

    public String updateUserName(String userName, String newName) {
        try {
            User user = userRepository.findByUserName(userName);
            user.setUserName(newName);
            userRepository.save(user);
            return "The username updated to " + user.getUserName() + " successfully!";
        } catch (Exception e) {
            return "Failed to update username!";
        }
    }

    public String deleteUser(String userName) {
        try {
            User user = userRepository.findByUserName(userName);
            userRepository.delete(user);
            return "The user " + userName + " is deleted successfully!";
        } catch (Exception e) {
            return "Failed to delete user!";
        }
    }
}
