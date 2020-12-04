package by.myapplication.finance.model.account;

import by.myapplication.finance.model.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Account {

    @Column(name = "account_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private int balance;

    @ManyToMany(mappedBy = "accounts",fetch = FetchType.LAZY)
    private List<User> users;

}
