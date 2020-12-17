/*
@author Andrei Gorevoi
*/
package by.myapplication.finance.controller.transaction;

import by.myapplication.finance.model.groupEx.GroupOfExpanse;
import by.myapplication.finance.model.transaction.AppTransaction;
import by.myapplication.finance.service.groupEx.GroupExService;
import by.myapplication.finance.service.transaction.AppTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/transaction")
@CrossOrigin(origins = "http://localhost:3000")
public class TransactionRestController {

    private final AppTransactionService appTransactionService;
    private final GroupExService groupExService;

    @Autowired
    public TransactionRestController(AppTransactionService appTransactionService,
                                     GroupExService groupExService) {
        this.appTransactionService = appTransactionService;
        this.groupExService = groupExService;
    }

    @PostMapping("/{groupId}")
    public AppTransaction addTransaction(@RequestBody AppTransaction newTransaction,
                                         @PathVariable Long groupId){
        appTransactionService.addTransaction(newTransaction,groupId);
         return newTransaction;
    }

    @DeleteMapping(value = "/{transactionId}")
    public boolean deleteTransactionById(@PathVariable Long transactionId){
        return appTransactionService.deleteTransactionById(transactionId);
    }

    @PutMapping
    public AppTransaction updateTransaction(@RequestBody AppTransaction updatedTransaction){
         appTransactionService.updateTransaction(updatedTransaction);
         return updatedTransaction;
    }

    @GetMapping("/all")
    public List<AppTransaction> getAllTransactionByAccountId(@RequestParam Long accountId){
        return appTransactionService.findTransactionsByAccountId(accountId);
    }

    @GetMapping("/balance")
    public int getBalanceByAccountId(@RequestParam Long accountId){
        return appTransactionService.getBalanceForAccount(accountId);
    }
}
