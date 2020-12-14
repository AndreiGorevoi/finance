package by.myapplication.finance.service.account;

import by.myapplication.finance.model.account.Account;
import by.myapplication.finance.model.user.User;
import by.myapplication.finance.repository.account.AccountRepository;
import by.myapplication.finance.repository.user.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import javax.transaction.Transactional;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository,
                              UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
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
    public boolean addAccount(Account newAccount) {
        User user = userRepository.getUserByLogin("test").get();
        user.getAccounts().add(newAccount);
        newAccount.getUsers().add(user);
        accountRepository.save(newAccount);
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
