package by.myapplication.finance.model.groupEx;

import by.myapplication.finance.model.account.Account;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "expense_group")
public class GroupOfExpanse {

    @Column(name = "expense_group_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account_id;
}
