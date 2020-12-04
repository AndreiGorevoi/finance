package by.myapplication.finance.service.user;

import by.myapplication.finance.model.user.User;
import by.myapplication.finance.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        User user = userRepository.getUserById(id);
        return (user==null) ? Optional.empty() : Optional.of(user);
    }

    @Override
    public Optional<User> findUserByLogin(String login) {
        User user = userRepository.getUserByLogin(login);
        return (user==null) ? Optional.empty() : Optional.of(user);
    }

    @Override
    public boolean addUser(User user) {
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        userRepository.save(user);
        return true;
    }
}
