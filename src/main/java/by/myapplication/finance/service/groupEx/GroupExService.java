package by.myapplication.finance.service.groupEx;

import by.myapplication.finance.model.groupEx.GroupOfExpanse;

import java.util.Optional;

public interface GroupExService {
    Optional<GroupOfExpanse> findGroupOfExpanseById(Long groupId);
    Optional<GroupOfExpanse> findGroupOfExpanseByName(String groupName);
    boolean saveGroup(GroupOfExpanse newGroup);
    boolean updateGroup(GroupOfExpanse updatedGroup);
    boolean deleteGroupById(Long groupId);
}
