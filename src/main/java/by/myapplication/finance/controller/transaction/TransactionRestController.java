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

@RestController
@RequestMapping("/transaction")
public class TransactionRestController {

    private final AppTransactionService appTransactionService;
    private final GroupExService groupExService;

    @Autowired
    public TransactionRestController(AppTransactionService appTransactionService,
                                     GroupExService groupExService) {
        this.appTransactionService = appTransactionService;
        this.groupExService = groupExService;
    }

    @PostMapping
    public AppTransaction addTransaction(@RequestBody AppTransaction newTransaction,
                                         @PathParam("groupId") Long groupId){
        GroupOfExpanse groupOfExpanse = groupExService.findGroupOfExpanseById(groupId).get();
        newTransaction.setGroup_id(groupOfExpanse);
        appTransactionService.addTransaction(newTransaction);
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
}
