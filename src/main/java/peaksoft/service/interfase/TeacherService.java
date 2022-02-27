package peaksoft.service.interfase;

import peaksoft.model.Teacher;
import java.util.List;

public interface TeacherService {

    Teacher saveTeacher(Teacher teacher);

    void removeTeacherById(long id);

    Teacher getById(long id);

    List<Teacher> getAllTeacher();

    void cleanTeacherTable();

    void updateTeacher(Teacher teacher);
}
