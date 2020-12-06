package by.myapplication.finance.controller;

import by.myapplication.finance.model.user.User;
import by.myapplication.finance.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
public class StartController {
    private final UserService userService;

    @Autowired
    public StartController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user")
    public void getUser(@PathParam(value = "login") String login){
        Optional<User> userByLogin = userService.findUserByLogin(login);
        System.out.println(userByLogin.get().getLogin());
    }

    @GetMapping(value = "/test")
    public void test(){
        System.out.println("qwe");
    }
}
