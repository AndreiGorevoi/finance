/*
@author Andrei Gorevoi
*/
package by.myapplication.finance.controller.groupEx;

import by.myapplication.finance.model.account.Account;
import by.myapplication.finance.model.groupEx.GroupOfExpanse;
import by.myapplication.finance.service.account.AccountService;
import by.myapplication.finance.service.groupEx.GroupExService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/group")
public class GroupRestController {

    private final GroupExService groupExService;
    private final AccountService accountService;

    @Autowired
    public GroupRestController(GroupExService groupExService, AccountService accountService) {
        this.groupExService = groupExService;
        this.accountService = accountService;
    }

    @PostMapping
    public GroupOfExpanse addGroup(@RequestBody GroupOfExpanse newGroup,@PathParam("accountId") Long accountId){
//        TODO : throw ex
        Account account = accountService.getAccountById(accountId).get();
        newGroup.setAccount_id(account);
        groupExService.saveGroup(newGroup);
        return newGroup;
    }

    @DeleteMapping(value = "/{groupId}")
    public boolean deleteGroupById(@PathVariable Long groupId){
        return groupExService.deleteGroupById(groupId);
    }

    @PutMapping
    public GroupOfExpanse updateGroup(@RequestBody GroupOfExpanse updatedGroup){
        groupExService.updateGroup(updatedGroup);
        return updatedGroup;
    }
}
