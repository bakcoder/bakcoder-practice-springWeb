package bakcoder.practice.springWeb.controller;

import bakcoder.practice.springWeb.model.User;
import bakcoder.practice.springWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }


    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Integer userId) {
        return userService.getUserById(userId);
    }

    /*

    @PostMapping("")
    public Map<String, Object> registUser(
            @RequestParam(value="userId") Integer userId,
            @RequestParam(value="username") String username) {
        Map<String, Object> map = new HashMap<String, Object>();
        userService.registUser(userId, username);
        map.put("result", "registered");
        return map;
    }
    */


    @PostMapping("")
    public Map<String, Object> registUserbyJson(@RequestBody User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        userService.registUser(user.getUserId(), user.getUsername());
        map.put("result", "registered");
        return map;
    }



    @PutMapping("")
    public Map<String, Object> modifyUser(
            @RequestParam(value="userId") Integer userId,
            @RequestParam(value="username") String username) {
        Map<String, Object> map = new HashMap<String, Object>();
        userService.modifyUser(userId, username);
        map.put("result", "modified");
        return map;
    }

    @DeleteMapping("/{userId}")
    public Map<String, Object> removeUser(@PathVariable("userId") Integer userId) {
        Map<String, Object> map = new HashMap<String, Object>();
        userService.removeUser(userId);
        map.put("result", "deleted");
        return map;
    }
}
