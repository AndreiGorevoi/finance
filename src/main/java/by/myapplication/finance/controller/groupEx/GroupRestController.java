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

import java.util.List;

@RestController
@RequestMapping(value = "/group")
@CrossOrigin(origins = "http://localhost:3000")
public class GroupRestController {

    private final GroupExService groupExService;
    private final AccountService accountService;

    @Autowired
    public GroupRestController(GroupExService groupExService, AccountService accountService) {
        this.groupExService = groupExService;
        this.accountService = accountService;
    }

    @PostMapping(value = {"/{accountId}"})
    public GroupOfExpanse addGroup(@RequestBody GroupOfExpanse newGroup,@PathVariable Long accountId){
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

    @GetMapping(value = "/{accountId}")
    public List<GroupOfExpanse> getGroupsByAccountId(@PathVariable Long accountId){
        return groupExService.findGroupOfExpanseByAccountId(accountId);
    }
}
