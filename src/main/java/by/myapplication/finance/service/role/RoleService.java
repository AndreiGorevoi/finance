package by.myapplication.finance.service.role;

import by.myapplication.finance.model.role.Role;
import by.myapplication.finance.model.role.RoleName;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    Optional<Role> findRoleById(Long roleId);
    Optional<Role> findRoleByName(RoleName roleName);
    boolean addRole(Role role);
    boolean addRoleList(List<Role> roleList);
}
