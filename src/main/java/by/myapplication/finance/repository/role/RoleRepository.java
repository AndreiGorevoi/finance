package by.myapplication.finance.repository.role;

import by.myapplication.finance.model.role.Role;
import by.myapplication.finance.model.role.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query("from Role where id=?1")
    Optional<Role> getRoleById(Long roleId);

    @Query("from Role where name=?1")
    Optional<Role> getRoleByName(RoleName roleName);

}
