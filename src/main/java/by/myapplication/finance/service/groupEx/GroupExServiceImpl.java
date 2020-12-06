package by.myapplication.finance.service.groupEx;

import by.myapplication.finance.model.groupEx.GroupOfExpanse;
import by.myapplication.finance.repository.groupeEx.GroupOfExpenseRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
@Service
@Transactional
public class GroupExServiceImpl implements GroupExService {

    private final GroupOfExpenseRepository groupOfExpenseRepository;

    public GroupExServiceImpl(GroupOfExpenseRepository groupOfExpenseRepository) {
        this.groupOfExpenseRepository = groupOfExpenseRepository;
    }

    @Override
    public Optional<GroupOfExpanse> findGroupOfExpanseById(Long groupId) {
        return groupOfExpenseRepository.getGroupOfExpanseById(groupId);
    }

    @Override
    public Optional<GroupOfExpanse> findGroupOfExpanseByName(String groupName) {
        return groupOfExpenseRepository.getGroupOfExpanseByName(groupName);
    }
}
