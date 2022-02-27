package peaksoft.service.interfase;

import peaksoft.model.Course;
import peaksoft.model.Group;

import java.util.List;

public interface GroupService {

    Group saveGroup(Group gq);

    void removeGroupById(long id);

    Group getById(long id);

    List<Group> getAllGroup();

    void cleanGroupTable();

    void updateGroup(Group group);
}
