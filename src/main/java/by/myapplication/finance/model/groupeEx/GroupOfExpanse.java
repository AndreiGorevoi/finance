package by.myapplication.finance.model.groupeEx;

import by.myapplication.finance.model.BaseModel;
import by.myapplication.finance.model.account.Account;

import javax.persistence.*;

@Entity
@Table(name = "expense_group")
public class GroupOfExpanse extends BaseModel {

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account_id;
}
