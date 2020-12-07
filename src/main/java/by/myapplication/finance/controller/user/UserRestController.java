package by.myapplication.finance.controller.user;

import by.myapplication.finance.model.user.User;
import by.myapplication.finance.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public User addUser(@RequestBody User newUser){
        userService.addUser(newUser);
        return newUser;
    }

    @DeleteMapping(value = "/{userId}")
    public boolean deleteUserById(@PathVariable Long userId){
        return userService.deleteUserById(userId);
    }
    @DeleteMapping(value = "/{login}")
    public boolean deleteUserById(@PathVariable String login){
        return userService.deleteUserByLogin(login);
    }

    @PutMapping
    public User updateUser(@RequestBody User updatedUser){
        userService.updateUser(updatedUser);
        return updatedUser;
    }
}
