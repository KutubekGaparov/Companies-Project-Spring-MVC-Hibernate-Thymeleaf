package peaksoft.dao;

import peaksoft.model.Course;
import peaksoft.model.Group;

import java.util.List;

public interface GroupDao {
    Group saveGroup(Group group);

    void removeGroupById(long id);

    Group getById(long id);

    List<Group> getAllGroup();

    void cleanGroupTable();

    void updateGroup(long id ,Group group);
}
