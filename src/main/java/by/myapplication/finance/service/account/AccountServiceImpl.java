package by.myapplication.finance.service.account;

import by.myapplication.finance.model.account.Account;
import by.myapplication.finance.model.groupEx.GroupOfExpanse;
import by.myapplication.finance.model.transaction.AppTransaction;
import by.myapplication.finance.model.user.User;
import by.myapplication.finance.repository.account.AccountRepository;
import by.myapplication.finance.repository.groupeEx.GroupOfExpenseRepository;
import by.myapplication.finance.repository.transaction.TransactionRepository;
import by.myapplication.finance.repository.user.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final GroupOfExpenseRepository groupOfExpenseRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository,
                              UserRepository userRepository, GroupOfExpenseRepository groupOfExpenseRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.groupOfExpenseRepository = groupOfExpenseRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Optional<Account> getAccountById(Long accountId) {
        return accountRepository.getAccountById(accountId);
    }

    @Override
    public Optional<Account> getAccountByName(String accountName) {
        return accountRepository.getAccountByName(accountName);
    }

    @SneakyThrows
    @Override
    public boolean addAccount(Account newAccount, int startBalance) {
        User user = userRepository.getUserByLogin("test").get();
        user.getAccounts().add(newAccount);
        newAccount.getUsers().add(user);
        GroupOfExpanse groupOfExpanse = new GroupOfExpanse();
        groupOfExpanse.setName("Start cash");
        groupOfExpanse.setAccount_id(newAccount);
        AppTransaction appTransaction = new AppTransaction();
        appTransaction.setDescription("Transaction for start account");
        appTransaction.setValue(startBalance);
        appTransaction.setGroup_id(groupOfExpanse);
        accountRepository.save(newAccount);
        groupOfExpenseRepository.save(groupOfExpanse);
        transactionRepository.save(appTransaction);
        return true;
    }

    @SneakyThrows
    @Override
    public boolean deleteAccountById(Long id) {
        accountRepository.delete(accountRepository.getAccountById(id).orElseThrow(()-> new AccountNotFoundException("account not found")));
        return true;
    }

    @Override
    public Account updateAccount(Account updatedAccount) {
       return accountRepository.save(updatedAccount);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }


}
