package by.myapplication.finance.service.role;

import by.myapplication.finance.model.role.Role;
import by.myapplication.finance.model.role.RoleName;
import by.myapplication.finance.repository.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> findRoleById(Long roleId) {
        return roleRepository.getRoleById(roleId);
    }

    @Override
    public Optional<Role> findRoleByName(RoleName roleName) {
        return roleRepository.getRoleByName(roleName);
    }

    @Override
    public boolean addRole(Role role) {
        Role save = roleRepository.save(role);
        return true;
    }

    @Override
    public boolean addRoleList(List<Role> roleList) {
        return false;
    }
}
