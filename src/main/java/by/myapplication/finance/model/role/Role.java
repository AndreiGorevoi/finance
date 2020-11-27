package by.myapplication.finance.model.role;

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
public class Role extends BaseModel {

    @Column
    private String name;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    private List<User> users;
}
