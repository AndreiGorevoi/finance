package by.myapplication.finance.repository.transaction;

import by.myapplication.finance.model.transaction.AppTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<AppTransaction,Long> {
    @Query("from AppTransaction where id=?1")
    Optional<AppTransaction> getTransactionById(Long transactionId);

    @Query("from AppTransaction a where a.group_id.id=?1")
    List<AppTransaction> getAppTransactionsByGroupId(Long groupId);

    @Query("from AppTransaction a where a.group_id.account_id=?1")
    List<AppTransaction> getAppTransactionByAccountId(Long accountId);

}
