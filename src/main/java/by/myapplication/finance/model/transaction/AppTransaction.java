package by.myapplication.finance.model.transaction;

import by.myapplication.finance.model.account.Account;
import by.myapplication.finance.model.groupEx.GroupOfExpanse;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
@Data
public class AppTransaction {

    @Column(name = "transaction_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column
    private String description;

    @Column
    private int value;

    @Column
    private boolean type;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account_id;

    @ManyToOne
    @JoinColumn(name = "expense_group_id")
    private GroupOfExpanse group_id;
}
