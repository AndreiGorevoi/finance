package by.myapplication.finance.repository.transaction;

import by.myapplication.finance.model.transaction.AppTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<AppTransaction,Long> {
    @Query("from AppTransaction where id=?1")
    AppTransaction getTransactionById(Long id);

    @Query("from AppTransaction a where a.account_id.id=?1")
    List<AppTransaction> getAppTransactionsByAccountId(Long accountId);

}
