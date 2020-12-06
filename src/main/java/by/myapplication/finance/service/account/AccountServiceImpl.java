package by.myapplication.finance.service.account;

import by.myapplication.finance.model.account.Account;
import by.myapplication.finance.repository.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Optional<Account> getAccountById(Long accountId) {
        return accountRepository.getAccountById(accountId);
    }

    @Override
    public Optional<Account> getAccountByName(String accountName) {
        return accountRepository.getAccountByName(accountName);
    }
}
