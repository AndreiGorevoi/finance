/*
@author Andrei Gorevoi
*/
package by.myapplication.finance.controller.account;

import by.myapplication.finance.model.account.Account;
import by.myapplication.finance.service.account.AccountService;
import by.myapplication.finance.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "http://localhost:3000")
public class AccountRestController {

    private final AccountService accountService;

    @Autowired
    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public Account addAccount(@RequestBody Account newAccount){
      if(newAccount.getName()==null){
          newAccount.setName("default name");
      }
        accountService.addAccount(newAccount);
        return newAccount;
    }

    @DeleteMapping(value = "/{accountId}")
    public boolean deleteAccountById(@PathVariable Long accountId){
        return accountService.deleteAccountById(accountId);
    }

    @PutMapping
    public Account updateAccount(@RequestBody Account updatedAccount){
        return accountService.updateAccount(updatedAccount);
    }

    @GetMapping("/all")
    public List<Account> getAccountsForUserId(){
        return accountService.getAllAccounts();
    }
}
