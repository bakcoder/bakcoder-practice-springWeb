package bakcoder.practice.springWeb.service;

import bakcoder.practice.springWeb.dao.UserRepository;
import bakcoder.practice.springWeb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Map<String, String> getMessage() {
        Map<String, String> res = new HashMap<>();
        res.put("bak", "coder");
        return res;
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User getUserById(Integer userId) {
        return userRepository.getUserById(userId);
    }

    public void registUser(Integer userId, String username) {
        userRepository.registUser(userId, username);
    }

    public void modifyUser(Integer userId, String username) {
        userRepository.modifyUser(userId, username);
    }

    public void removeUser(Integer userId) {
        userRepository.removeUser(userId);
    }
}
