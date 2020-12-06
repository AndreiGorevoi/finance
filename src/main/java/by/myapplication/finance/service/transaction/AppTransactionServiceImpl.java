package by.myapplication.finance.service.transaction;

import by.myapplication.finance.model.transaction.AppTransaction;
import by.myapplication.finance.repository.transaction.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AppTransactionServiceImpl implements AppTransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public AppTransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Optional<AppTransaction> findTransactionById(Long transactionId) {
        return transactionRepository.getTransactionById(transactionId);
    }

    @Override
    public List<AppTransaction> findTransactionsByAccountId(Long accountId) {
        return transactionRepository.getAppTransactionsByAccountId(accountId);
    }

    @Override
    public boolean addTransaction(AppTransaction transaction) {
        transactionRepository.save(transaction);
        return true;
    }

    @Override
    public boolean updateTransaction(AppTransaction updatedTransaction) {
        transactionRepository.save(updatedTransaction);
        return true;
    }
}
