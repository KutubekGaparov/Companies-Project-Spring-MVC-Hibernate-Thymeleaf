package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.GroupDao;
import peaksoft.model.Group;
import peaksoft.service.interfase.GroupService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    private final GroupDao dao;

    @Autowired
    public GroupServiceImpl(GroupDao dao) {
        this.dao = dao;
    }

    @Override
    public Group saveGroup(Group group) {
        return dao.saveGroup(group);
    }

    @Override
    public void removeGroupById(long id) {
        dao.removeGroupById(id);
    }

    @Override
    public Group getById(long id) {
        return dao.getById(id);
    }

    @Override
    public List<Group> getAllGroup() {
        return dao.getAllGroup();
    }

    @Override
    public void cleanGroupTable() {
        dao.cleanGroupTable();
    }

    @Override
    public void updateGroup(Group group) {
        dao.updateGroup(group);
    }
}
