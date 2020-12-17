package by.myapplication.finance.service.transaction;

import by.myapplication.finance.model.groupEx.GroupOfExpanse;
import by.myapplication.finance.model.transaction.AppTransaction;
import by.myapplication.finance.repository.groupeEx.GroupOfExpenseRepository;
import by.myapplication.finance.repository.transaction.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AppTransactionServiceImpl implements AppTransactionService {

    private final TransactionRepository transactionRepository;
    private final GroupOfExpenseRepository groupOfExpenseRepository;

    @Autowired
    public AppTransactionServiceImpl(TransactionRepository transactionRepository, GroupOfExpenseRepository groupOfExpenseRepository) {
        this.transactionRepository = transactionRepository;
        this.groupOfExpenseRepository = groupOfExpenseRepository;
    }

    @Override
    public Optional<AppTransaction> findTransactionById(Long transactionId) {
        return transactionRepository.getTransactionById(transactionId);
    }

    @Override
    public List<AppTransaction> findTransactionsByGroupId(Long groupId) {
        return transactionRepository.getAppTransactionsByGroupId(groupId);
    }

    @Override
    public List<AppTransaction> findTransactionsByAccountId(Long accountId) {
        return transactionRepository.getAppTransactionByAccountId(accountId);
    }

    @Override
    public boolean addTransaction(AppTransaction transaction,Long groupId) {
        GroupOfExpanse groupOfExpanse = groupOfExpenseRepository.getGroupOfExpanseById(groupId).get();
        transaction.setGroup_id(groupOfExpanse);
        transaction.setDate(new Date(System.currentTimeMillis()));
        transactionRepository.save(transaction);
        return true;
    }

    @Override
    public boolean updateTransaction(AppTransaction updatedTransaction) {
        transactionRepository.save(updatedTransaction);
        return true;
    }

    @Override
    public boolean deleteTransactionById(Long transactionId) {
        //    TODO: throw exception if transaction not found
        transactionRepository.delete(transactionRepository.getTransactionById(transactionId).get());
        return true;
    }

    @Override
    public int getBalanceForAccount(Long accountId) {
        return transactionRepository.getAppTransactionByAccountId(accountId)
                .stream().mapToInt(AppTransaction::getValue).sum();
    }

}
