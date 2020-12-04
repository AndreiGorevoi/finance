package by.myapplication.finance.service.user;

import by.myapplication.finance.model.user.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findUserById(Long id);
    Optional<User> findUserByLogin(String login);
    boolean addUser(User user);
    boolean updateUser(User user);
}
