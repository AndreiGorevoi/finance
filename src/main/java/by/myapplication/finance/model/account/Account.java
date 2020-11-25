package by.myapplication.finance.model.account;

import by.myapplication.finance.model.BaseModel;
import by.myapplication.finance.model.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Account extends BaseModel {
    @Column
    private String name;
    @Column
    private int balance;

    @ManyToMany(mappedBy = "accounts",fetch = FetchType.LAZY)
    private List<User> users;

}
