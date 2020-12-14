package by.myapplication.finance.service.account;

import by.myapplication.finance.model.account.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Optional<Account> getAccountById(Long accountId);
    Optional<Account> getAccountByName(String accountName);
    boolean addAccount(Account newAccount);
    boolean deleteAccountById(Long id);
    Account updateAccount(Account updatedAccount);
    List<Account> getAllAccounts();
}
