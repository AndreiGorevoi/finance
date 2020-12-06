package by.myapplication.finance.service.transaction;

import by.myapplication.finance.model.transaction.AppTransaction;

import java.util.List;
import java.util.Optional;

public interface AppTransactionService {
    Optional<AppTransaction> findTransactionById(Long transactionId);
    List<AppTransaction> findTransactionsByAccountId(Long accountId);
    boolean addTransaction(AppTransaction transaction);
    boolean updateTransaction(AppTransaction updatedTransaction);

}
