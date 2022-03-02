package peaksoft.dao;

import peaksoft.model.Teacher;
import java.util.List;

public interface TeacherDao {
    Teacher saveTeacher(Teacher teacher);

    void removeTeacherById(long id);

    Teacher getById(long id);

    List<Teacher> getAllTeacher();

    void updateTeacher(long id,Teacher teacher);
}
