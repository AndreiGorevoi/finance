package by.myapplication.finance.repository.groupeEx;

import by.myapplication.finance.model.groupeEx.GroupOfExpanse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupOfExpenseRepository extends JpaRepository<GroupOfExpanse,Long> {

    @Query("from GroupOfExpanse where id=?1")
    GroupOfExpanse getGroupOfExpanseById(Long groupId);

    @Query("from GroupOfExpanse where name=?1")
    GroupOfExpanse getGroupOfExpanseByName(String groupName);

}
