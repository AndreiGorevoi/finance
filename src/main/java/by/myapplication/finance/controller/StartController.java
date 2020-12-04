package by.myapplication.finance.controller;

import by.myapplication.finance.model.user.User;
import by.myapplication.finance.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController {
    private final UserService userService;

    @Autowired
    public StartController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/user")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping("/test")
    public String testMethod(){
        return "test";
    }
}
