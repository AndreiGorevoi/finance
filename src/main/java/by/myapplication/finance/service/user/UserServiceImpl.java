package by.myapplication.finance.service.user;

import by.myapplication.finance.model.role.Role;
import by.myapplication.finance.model.role.RoleName;
import by.myapplication.finance.model.user.User;
import by.myapplication.finance.repository.role.RoleRepository;
import by.myapplication.finance.repository.user.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import javax.transaction.Transactional;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Arrays;
import java.util.Optional;
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    @SneakyThrows
    @Override
    public boolean addUser(User user) {
        Role role = roleRepository.getRoleByName(RoleName.USER).get();
        role.getUsers().add(user);
        user.getRoles().add(role);
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        userRepository.save(user);
        return true;
    }

    @SneakyThrows
    @Override
    public boolean deleteUserById(Long userId) {
        User user = userRepository.getUserById(userId).orElseThrow(()->new UserPrincipalNotFoundException("User with id : "+userId+"not found"));
         userRepository.delete(user);
         return true;
    }

    @SneakyThrows
    @Override
    public boolean deleteUserByLogin(String userName) {
        User user = userRepository.getUserByLogin(userName).orElseThrow(()->new UserPrincipalNotFoundException("User with login:" +userName + "not found "));
        userRepository.delete(user);
        return true;
    }
}
