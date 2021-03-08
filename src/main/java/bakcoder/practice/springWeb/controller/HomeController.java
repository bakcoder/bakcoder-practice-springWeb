package bakcoder.practice.springWeb.controller;

import bakcoder.practice.springWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public Map<String, String> home() {
        Map<String, String> res = this.userService.getMessage();
        return res;
    }
}
