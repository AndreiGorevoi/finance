package by.myapplication.finance.repository.groupeEx;

import by.myapplication.finance.model.groupEx.GroupOfExpanse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupOfExpenseRepository extends JpaRepository<GroupOfExpanse,Long> {

    @Query("from GroupOfExpanse where id=?1")
    Optional<GroupOfExpanse> getGroupOfExpanseById(Long groupId);

    @Query("from GroupOfExpanse where name=?1")
    Optional<GroupOfExpanse> getGroupOfExpanseByName(String groupName);

}
