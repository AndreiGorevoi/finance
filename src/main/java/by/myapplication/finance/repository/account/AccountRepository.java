package by.myapplication.finance.repository.account;

import by.myapplication.finance.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    @Query("from Account where id=?1")
    Optional<Account> getAccountById(Long accountId);

    @Query("from Account where name=?1")
    Optional<Account> getAccountByName(String accountName);
}
