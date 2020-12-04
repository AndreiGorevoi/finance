package by.myapplication.finance.repository.user;

import by.myapplication.finance.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("from User where id=?1")
    User getUserById(Long id);

    @Query("from User where login=?1")
    User getUserByLogin(String login);


}
